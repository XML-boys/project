import { TestBed } from '@angular/core/testing';

import { AdminSifrarnikService } from './admin-sifrarnik.service';

describe('AdminSifrarnikService', () => {
  let service: AdminSifrarnikService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminSifrarnikService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
