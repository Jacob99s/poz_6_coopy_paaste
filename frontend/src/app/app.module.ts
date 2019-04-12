import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { PackageReceiverDataComponent } from './package-receiver-data/package-receiver-data.component';
import { SupplyMethodComponent } from './supply-method/supply-method.component';
import { PaymentMethodComponent } from './payment-method/payment-method.component';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    PackageReceiverDataComponent,
    SupplyMethodComponent,
    PaymentMethodComponent,
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
