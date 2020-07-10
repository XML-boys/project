import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AgentReserveForMyselfComponent } from './agent-reserve-for-myself.component';

describe('AgentReserveForMyselfComponent', () => {
  let component: AgentReserveForMyselfComponent;
  let fixture: ComponentFixture<AgentReserveForMyselfComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AgentReserveForMyselfComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AgentReserveForMyselfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
