import { TestBed } from '@angular/core/testing';

import { ClubserService } from './clubser.service';

describe('ClubserService', () => {
  let service: ClubserService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ClubserService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
