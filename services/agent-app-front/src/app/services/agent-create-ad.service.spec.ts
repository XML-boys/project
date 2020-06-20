import { TestBed } from '@angular/core/testing';

import { AgentCreateAdService } from './agent-create-ad.service';

describe('AgentCreateAdService', () => {
  let service: AgentCreateAdService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AgentCreateAdService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
