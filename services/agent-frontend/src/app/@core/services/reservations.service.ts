import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReservationsService {

  constructor(private http: HttpClient) { }

  getAllReservations(): Observable<any> {
    return this.http.get<any>('http://localhost:6969/reservation', {
      headers: new HttpHeaders().set('Content-Type', 'application/json')
    });
  }
}
