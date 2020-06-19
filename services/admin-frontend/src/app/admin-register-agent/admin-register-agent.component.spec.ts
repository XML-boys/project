import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminRegisterAgentComponent } from './admin-register-agent.component';

describe('AdminRegisterAgentComponent', () => {
  let component: AdminRegisterAgentComponent;
  let fixture: ComponentFixture<AdminRegisterAgentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminRegisterAgentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminRegisterAgentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
