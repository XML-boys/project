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

  id;
  model;
  evoId(id){
    return this.id = id;
  }

  uzmiId(){
    return this.id;
  }

  getAds(): Observable<any> {
    return this.http.get<any>(this.configService.agentAds, this.httpOptions);
  }

  getLocations(): Observable<any> {
    return this.http.get<any>(this.configService.allLocations, this.httpOptions);
  }

  getAllVehicle(): Observable<any> {
    return this.http.get<any>('http://localhost:6969/vehicles/');
  }

  getAllVendors(): Observable<any> {
    return this.http.get<any>(this.configService.allVendors, this.httpOptions);
  }

  createAd(ad): Observable<any> {
    return this.http.post<any>('http://localhost:6969/ad', ad);
  }

  createVehicle(ad): Observable<any> {
    return this.http.post<any>('http://localhost:6969/vehicles', ad);
  }

  getModelsByVendor(name): Observable<any> {
    return this.http.get<any>('http://localhost:6969/codeBook/vendor/' + name);
  }

  getAllItems(): Observable<any> {
    return this.http.get<any>(this.configService.allItems, this.httpOptions);
  }
}
