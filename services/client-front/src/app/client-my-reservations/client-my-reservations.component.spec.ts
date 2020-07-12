import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientMyReservationsComponent } from './client-my-reservations.component';

describe('ClientMyReservationsComponent', () => {
  let component: ClientMyReservationsComponent;
  let fixture: ComponentFixture<ClientMyReservationsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClientMyReservationsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientMyReservationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
