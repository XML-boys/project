import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfilAgentAppComponent } from './profil-agent-app.component';

describe('ProfilAgentAppComponent', () => {
  let component: ProfilAgentAppComponent;
  let fixture: ComponentFixture<ProfilAgentAppComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfilAgentAppComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfilAgentAppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
