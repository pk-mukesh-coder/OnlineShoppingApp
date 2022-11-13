import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { OrderLookupServiceComponent } from '../order-lookup-service/order-lookup-service.component';
import { orderLineItems } from './orderLineItems';

@Component({
  selector: 'app-summary',
  templateUrl: './summary.component.html',
  styleUrls: ['./summary.component.css']
})


export class SummaryComponent implements OnInit{
  
  orders:any=orderLineItems;
  id:any;
  data:any;

  constructor(private route: ActivatedRoute,private OrderLookupServiceComponent:OrderLookupServiceComponent) {
    
}
  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    this.getOne();    
   }
   getOne(){
this.OrderLookupServiceComponent.getOne(this.id).subscribe(data=>{
  this.orders=data;
  console.log(this.orders);
  console.log(this.id);
})
   }

  
}
