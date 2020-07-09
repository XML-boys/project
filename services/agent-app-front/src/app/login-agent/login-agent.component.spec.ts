import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginAgentComponent } from './login-agent.component';

describe('LoginAgentComponent', () => {
  let component: LoginAgentComponent;
  let fixture: ComponentFixture<LoginAgentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginAgentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginAgentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
