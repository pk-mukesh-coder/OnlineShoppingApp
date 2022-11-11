import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-order-lookup-service',
  templateUrl: './order-lookup-service.component.html',
  styleUrls: ['./order-lookup-service.component.css']
})

export class OrderLookupServiceComponent implements OnInit{

  orders :any;
  url="http://localhost:8001/orders/customer/7";

  constructor(private _http:HttpClient) {
    this._http.get(this.url).subscribe(
       data => { this.orders = data;
        console.log(data);
              
    })


}

  ngOnInit(): void {
  }

}
