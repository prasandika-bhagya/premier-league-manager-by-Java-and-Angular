import { TestBed } from '@angular/core/testing';

import { MatchSerService } from './match-ser.service';

describe('MatchSerService', () => {
  let service: MatchSerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MatchSerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
