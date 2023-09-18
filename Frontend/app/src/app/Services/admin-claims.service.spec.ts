import { TestBed } from '@angular/core/testing';

import { AdminClaimsService } from './admin-claims.service';

describe('AdminClaimsService', () => {
  let service: AdminClaimsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminClaimsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
