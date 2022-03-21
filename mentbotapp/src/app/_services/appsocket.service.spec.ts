import { TestBed } from '@angular/core/testing';

import { AppsocketService } from './appsocket.service';

describe('AppsocketService', () => {
  let service: AppsocketService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AppsocketService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
