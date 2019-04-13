import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { PackageReceiverDataComponent } from './package-receiver-data/package-receiver-data.component';
import { SupplyMethodComponent } from './supply-method/supply-method.component';
import { PaymentMethodComponent } from './payment-method/payment-method.component';
import { OrderScreenComponent } from './order-screen/order-screen.component';
import { RouterModule, Routes } from '@angular/router';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { ButtonComponent } from './button/button.component';
import { ByuingProgressComponent } from './byuing-progress/byuing-progress.component';
import { CheckboxComponent } from './checkbox/checkbox.component';
import { MapComponent } from './map/map.component';

import { AgmCoreModule } from '@agm/core';

const appRoutes: Routes = [
  { path: 'product', component: OrderScreenComponent },
  {
    path: '',
    redirectTo: '/heroes',
    pathMatch: 'full'
  },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    PackageReceiverDataComponent,
    SupplyMethodComponent,
    PaymentMethodComponent,
    OrderScreenComponent,
    PageNotFoundComponent,
    ButtonComponent,
    ByuingProgressComponent,
    CheckboxComponent,
    MapComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true }
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})


@NgModule({
  imports: [
    MapComponent,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyCJkiekbMK0DsVdFsrSEts_WlgvxCfPThA'
    })
  ],
  providers: [],
  declarations: [AppComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }