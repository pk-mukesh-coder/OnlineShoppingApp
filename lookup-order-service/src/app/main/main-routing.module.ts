import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OrderLookupServiceComponent } from '../order-lookup-service/order-lookup-service.component';
import { SummaryComponent } from '../summary/summary.component';


const routes:Routes=[
    
 { path:'summary',component:SummaryComponent},
 { path:'summary/:id',component:SummaryComponent},
 { path: 'orderservice', redirectTo: 'summary', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MainRoutingModule { }
