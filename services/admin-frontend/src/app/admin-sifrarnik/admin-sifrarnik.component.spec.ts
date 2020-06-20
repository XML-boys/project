import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminSifrarnikComponent } from './admin-sifrarnik.component';

describe('AdminSifrarnikComponent', () => {
  let component: AdminSifrarnikComponent;
  let fixture: ComponentFixture<AdminSifrarnikComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminSifrarnikComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminSifrarnikComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
