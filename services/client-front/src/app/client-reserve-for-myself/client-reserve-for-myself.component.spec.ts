import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientReserveForMyselfComponent } from './client-reserve-for-myself.component';

describe('ClientReserveForMyselfComponent', () => {
  let component: ClientReserveForMyselfComponent;
  let fixture: ComponentFixture<ClientReserveForMyselfComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClientReserveForMyselfComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientReserveForMyselfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
