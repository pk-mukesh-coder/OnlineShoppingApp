import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderLookupServiceComponent } from './order-lookup-service.component';

describe('OrderLookupServiceComponent', () => {
  let component: OrderLookupServiceComponent;
  let fixture: ComponentFixture<OrderLookupServiceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrderLookupServiceComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OrderLookupServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
