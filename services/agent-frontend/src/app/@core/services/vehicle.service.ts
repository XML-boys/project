import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Ad} from '../model/Ad';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  constructor(private http: HttpClient) { }

  getAllVe(): Observable<Ad> {
    return this.http.get<Ad>('http://localhost:6969/ad');
  }
}
