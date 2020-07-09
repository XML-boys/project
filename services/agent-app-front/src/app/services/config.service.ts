import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  private apiUri = 'http://localhost:6969';

  get allAds(): string {
    return this.apiUri + '/ad';
  }

  get allLocations(): string {
    return this.apiUri + '/location';
  }

  get allVendors(): string {
    return this.apiUri + '/codeBook/vendor';
  }

  get allItems(): string {
    return this.apiUri + '/codeBook';
  }
}
