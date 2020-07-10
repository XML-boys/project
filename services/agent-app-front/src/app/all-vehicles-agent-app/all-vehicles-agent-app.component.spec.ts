import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllVehiclesAgentAppComponent } from './all-vehicles-agent-app.component';

describe('AllVehiclesAgentAppComponent', () => {
  let component: AllVehiclesAgentAppComponent;
  let fixture: ComponentFixture<AllVehiclesAgentAppComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllVehiclesAgentAppComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllVehiclesAgentAppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
