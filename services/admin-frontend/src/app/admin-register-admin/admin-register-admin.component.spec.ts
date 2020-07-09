import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminRegisterAdminComponent } from './admin-register-admin.component';

describe('AdminRegisterAdminComponent', () => {
  let component: AdminRegisterAdminComponent;
  let fixture: ComponentFixture<AdminRegisterAdminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminRegisterAdminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminRegisterAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
