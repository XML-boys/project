import { TestBed } from '@angular/core/testing';

import { AdminUpravaService } from './admin-uprava.service';

describe('AdminUpravaService', () => {
  let service: AdminUpravaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminUpravaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
