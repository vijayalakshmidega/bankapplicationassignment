import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AccountService } from '../account.service';
import { Accountdetails } from '../accountdetails';
import { Deposit } from '../deposit';


@Component({
  selector: 'app-deposit',
  templateUrl: './deposit.component.html',
  styleUrls: ['./deposit.component.css']
})
export class DepositComponent implements OnInit {
accountId: number;
deposit: Deposit= new Deposit();
  constructor(private accountService: AccountService
    ,private router: Router) { }
  
    
  ngOnInit(): void {
  }

  saveAccount(){
    this.accountService.depositAmount(this.deposit).subscribe( data =>{
      console.log(data);
      this.goToAccountList();
    },
    error => console.log(error));
  }

  goToAccountList(){
    this.router.navigate(['/accounts']);
  }
  
  onSubmit(){
    console.log(this.deposit);
    this.saveAccount();
  }
}
