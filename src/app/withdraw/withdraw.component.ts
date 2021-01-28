import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AccountService } from '../account.service';
import { Withdraw } from '../withdraw';

@Component({
  selector: 'app-withdraw',
  templateUrl: './withdraw.component.html',
  styleUrls: ['./withdraw.component.css']
})
export class WithdrawComponent implements OnInit {
 withdraw: Withdraw=new Withdraw();
 constructor(private accountService: AccountService
  ,private router: Router) { }

  
ngOnInit(): void {
}

saveAccount(){
  this.accountService.withdrawAmount(this.withdraw).subscribe( data =>{
    console.log(data);
    this.goToAccountList();
  },
  error => console.log(error));
}

goToAccountList(){
  this.router.navigate(['/accounts']);
}

onSubmit(){
  console.log(this.withdraw);
  this.saveAccount();
}
}