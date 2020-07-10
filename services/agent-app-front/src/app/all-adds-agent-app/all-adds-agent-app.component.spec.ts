import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllAddsAgentAppComponent } from './all-adds-agent-app.component';

describe('AllAddsAgentAppComponent', () => {
  let component: AllAddsAgentAppComponent;
  let fixture: ComponentFixture<AllAddsAgentAppComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllAddsAgentAppComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllAddsAgentAppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
