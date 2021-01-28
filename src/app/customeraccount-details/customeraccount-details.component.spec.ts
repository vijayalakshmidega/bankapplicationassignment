import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomeraccountDetailsComponent } from './customeraccount-details.component';

describe('CustomeraccountDetailsComponent', () => {
  let component: CustomeraccountDetailsComponent;
  let fixture: ComponentFixture<CustomeraccountDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomeraccountDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomeraccountDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
