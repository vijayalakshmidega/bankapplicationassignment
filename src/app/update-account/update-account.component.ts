import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AccountService } from '../account.service';
import { Accountdetails } from '../accountdetails';

@Component({
  selector: 'app-update-account',
  templateUrl: './update-account.component.html',
  styleUrls: ['./update-account.component.css']
})
export class UpdateAccountComponent implements OnInit {
  accountId: number;
  account: Accountdetails = new Accountdetails();
  constructor(private accountService: AccountService,
    private route: ActivatedRoute, private router: Router) { }
  
  ngOnInit(): void {
    this.accountId=this.route.snapshot.params['accountId'];
   this.accountService.getAccountById(this.accountId).subscribe(data=>{
    this.account=data;
    }, error=>console.log(error))
  }

  onSubmit(){
    this.accountService.updateEmployee(this.accountId, this.account)
    .subscribe(data=> {
        this.goToAccountList();
    }, error=> console.log(error))
  }
goToAccountList(){
    this.router.navigate(['/accounts']);
  }
}


