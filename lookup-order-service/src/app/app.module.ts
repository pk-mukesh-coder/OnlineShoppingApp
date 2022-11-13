import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { OrderLookupServiceComponent } from './order-lookup-service/order-lookup-service.component';
import { SummaryComponent } from './summary/summary.component';
import { RouterModule, Routes } from '@angular/router';
import { MainRoutingModule } from './main/main-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    OrderLookupServiceComponent,
    SummaryComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    MainRoutingModule,
    RouterModule.forRoot([]),

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
