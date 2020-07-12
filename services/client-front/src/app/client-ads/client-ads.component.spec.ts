import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientAdsComponent } from './client-ads.component';

describe('ClientAdsComponent', () => {
  let component: ClientAdsComponent;
  let fixture: ComponentFixture<ClientAdsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClientAdsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientAdsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
