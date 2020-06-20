import { TestBed } from '@angular/core/testing';

import { AdminRegisterAgentService } from './admin-register-agent.service';

describe('AdminRegisterAgentService', () => {
  let service: AdminRegisterAgentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminRegisterAgentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
