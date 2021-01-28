import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AccountComponent } from './account/account.component';
import { AuthGaurdService } from './auth-gaurd.service';
import { CreateAccountComponent } from './create-account/create-account.component';
import { CustomeraccountDetailsComponent } from './customeraccount-details/customeraccount-details.component';
import { DepositComponent } from './deposit/deposit.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { TransferComponent } from './transfer/transfer.component';
import { UpdateAccountComponent } from './update-account/update-account.component';
import { WithdrawComponent } from './withdraw/withdraw.component';


const routes: Routes = [
  {path:'accounts', component: AccountComponent,canActivate:[AuthGaurdService]},
  {path:'create-account', component: CreateAccountComponent,canActivate:[AuthGaurdService]},
  {path:'update-account/:accountId', component: UpdateAccountComponent,canActivate:[AuthGaurdService]},
  {path:'customeraccount-details/:accountId', component: CustomeraccountDetailsComponent,canActivate:[AuthGaurdService]},
  {path:'transfer', component: TransferComponent,canActivate:[AuthGaurdService]},
  {path:'deposit', component: DepositComponent,canActivate:[AuthGaurdService]},
  {path:'withdraw', component: WithdrawComponent,canActivate:[AuthGaurdService]},
  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent ,canActivate:[AuthGaurdService]},
  {path:'', redirectTo:'accounts', pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
