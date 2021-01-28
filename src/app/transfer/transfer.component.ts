import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AccountService } from '../account.service';
import { Transfer } from '../transfer';

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.css']
})
export class TransferComponent implements OnInit {
transfers: Transfer=new Transfer();
constructor(private accountService: AccountService
  ,private router: Router) { }

  
ngOnInit(): void {
}

saveAccount(){
  this.accountService.transferAmount(this.transfers).subscribe( data =>{
    console.log(data);
    this.goToAccountList();
  },
  error => console.log(error));
}

goToAccountList(){
  this.router.navigate(['/accounts']);
}

onSubmit(){
  console.log(this.transfers);
  this.saveAccount();
}
}