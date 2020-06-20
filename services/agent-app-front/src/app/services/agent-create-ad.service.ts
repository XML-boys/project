import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {ConfigService} from './config.service';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AgentCreateAdService {

  constructor(private http: HttpClient, private configService: ConfigService) { }
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  getAds(): Observable<any> {
    return this.http.get<any>(this.configService.allAds, this.httpOptions);
  }

  getLocations(): Observable<any> {
    return this.http.get<any>(this.configService.allLocations, this.httpOptions);
  }
}
