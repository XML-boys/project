import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AgentCreateAdComponent } from './agent-create-ad.component';

describe('AgentCreateAdComponent', () => {
  let component: AgentCreateAdComponent;
  let fixture: ComponentFixture<AgentCreateAdComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AgentCreateAdComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AgentCreateAdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
