import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminUpravaComponent } from './admin-uprava.component';

describe('AdminUpravaComponent', () => {
  let component: AdminUpravaComponent;
  let fixture: ComponentFixture<AdminUpravaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminUpravaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminUpravaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
