import { Component, OnInit } from '@angular/core';
import { Accountdetails } from '../accountdetails';
import { Router } from '@angular/router';
import { AccountService } from '../account.service';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {

  account: Accountdetails = new Accountdetails();
  constructor(private accountService: AccountService, private router: Router) { }

  ngOnInit(): void {
  }
  saveAccount(){
    this.accountService.createAccount(this.account).subscribe( data =>{
      console.log(data);
      this.goToAccountList();
    },
    error => console.log(error));
  }

  goToAccountList(){
    this.router.navigate(['/accounts']);
  }
  
  onSubmit(){
    console.log(this.account);
    this.saveAccount();
  }
}


