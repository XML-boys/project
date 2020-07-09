import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AgentCreateVehicleComponent } from './agent-create-vehicle.component';

describe('AgentCreateVehicleComponent', () => {
  let component: AgentCreateVehicleComponent;
  let fixture: ComponentFixture<AgentCreateVehicleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AgentCreateVehicleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AgentCreateVehicleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
