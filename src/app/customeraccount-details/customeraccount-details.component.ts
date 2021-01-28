import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AccountService } from '../account.service';
import { Accountdetails } from '../accountdetails';

@Component({
  selector: 'app-customeraccount-details',
  templateUrl: './customeraccount-details.component.html',
  styleUrls: ['./customeraccount-details.component.css']
})
export class CustomeraccountDetailsComponent implements OnInit {
accountId: number;
account: Accountdetails=new Accountdetails();
  constructor(private accountService: AccountService,
    private router: ActivatedRoute) { }

    ngOnInit(): void {
      this.accountId = this.router.snapshot.params['accountId'];
      this.account=new Accountdetails();
  this.accountService.getAccountById(this.accountId).subscribe(data=>{
    this.account=data;
  });
}
}
