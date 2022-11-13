import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-order-lookup-service',
  templateUrl: './order-lookup-service.component.html',
  styleUrls: ['./order-lookup-service.component.css']
})

export class OrderLookupServiceComponent implements OnInit{

  orders :any;
  data:any;
  id:any;

  constructor(private _http:HttpClient) {
    this.getRequest().subscribe(
       data => { this.orders = data;
  
    });
}

  ngOnInit(): void {
  }

  getRequest(){
    return this._http.get("http://localhost:8001/orders/");
    }

  getOne(id:number){
    return this._http.get("http://localhost:8001/orders/"+id);

}
}