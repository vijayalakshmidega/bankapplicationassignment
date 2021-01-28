import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AccountComponent } from './account/account.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { CreateAccountComponent } from './create-account/create-account.component';
import { UpdateAccountComponent } from './update-account/update-account.component';
import { FormsModule } from '@angular/forms';
import { CustomeraccountDetailsComponent } from './customeraccount-details/customeraccount-details.component';
import { DepositComponent } from './deposit/deposit.component';
import { WithdrawComponent } from './withdraw/withdraw.component';
import { TransferComponent } from './transfer/transfer.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { BasicAuthHtppInterceptorService } from './basic-auth-htpp-interceptor.service';


@NgModule({
  declarations: [
    AppComponent,
    AccountComponent,
    CreateAccountComponent,
    UpdateAccountComponent,
    CustomeraccountDetailsComponent,
    DepositComponent,
    WithdrawComponent,
    TransferComponent,
    LoginComponent,
    LogoutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule


  ],
  providers: [
    {  
      provide:HTTP_INTERCEPTORS, useClass:BasicAuthHtppInterceptorService, multi:true 
    }

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
