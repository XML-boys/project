import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Ad} from '../model/Ad';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  constructor(private http: HttpClient) { }

  getAllVendors(): Observable<any> {
    return this.http.get<any>('http://localhost:6969/codeBook/vendor');
  }
  getModelsByVendor(name): Observable<any> {
    return this.http.get<any>('http://localhost:6969/codeBook/vendor/' + name);
  }

  addVehicle(vehicle): Observable<any> {
    return this.http.post<any>('http://localhost:6969/vehicles', vehicle);
  }
/*
  getHeaders() {
    const userToken = localStorage.getItem('jwt');

    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    headers.append('Authorization', 'Bearer ' + userToken);

    return headers;
  }
  getAllClients(): Observable<Response> {
    return this.http.get<Response>('http://localhost:6969/client', this.getHeaders());
  }
*/

  getAllVehicle(): Observable<any> {
    return this.http.get<any>('http://localhost:6969/vehicles/');
  }

  deleteVehicle(id): Observable<any> {
    return this.http.delete<any>('http://localhost:6969/vehicles/' + id);
  }
}
