import { Component, OnInit } from '@angular/core';
import {Accountdetails} from '../accountdetails';
import { AccountService } from '../account.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {
  accounts: Accountdetails[];
  constructor(private accountService: AccountService,private router:Router) { }
  ngOnInit() {
    this.getAccounts();
  }
  private getAccounts(){
    this.accountService.getAccountList().subscribe(
      data=>{this.accounts=data});
    
  }

  updateAccount(id: number){
    console.log(`-----------`)
    this.router.navigate(['update-account', id]);
  }
  deleteAccount(accountId: number){
    this.accountService.deleteAccount(accountId).subscribe(data=>{
      this.getAccounts();
      console.log(data);
    })
  }
  customerDetails(accountId: number){
    this.router.navigate(['customeraccount-details', accountId]);
  }
  



}
