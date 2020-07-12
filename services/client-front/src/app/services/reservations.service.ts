import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReservationsService {

  constructor(private http: HttpClient) { }
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };
  getMyReservations(id): Observable<any> {
    return this.http.get<any>('http://localhost:6969/reservation/' + id + '/client', this.httpOptions);
  }

  reserve(id, body): Observable<any> {
    return this.http.post<any>('http://localhost:6969/reservation/' + id, body);
  }

  acceptRes(id, body): Observable<any> {
    return this.http.put<any>('http://localhost:6969/reservation/' + id + '/state', body);
  }
}
