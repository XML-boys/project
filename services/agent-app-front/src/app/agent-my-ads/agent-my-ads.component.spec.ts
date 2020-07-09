import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AgentMyAdsComponent } from './agent-my-ads.component';

describe('AgentMyAdsComponent', () => {
  let component: AgentMyAdsComponent;
  let fixture: ComponentFixture<AgentMyAdsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AgentMyAdsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AgentMyAdsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
