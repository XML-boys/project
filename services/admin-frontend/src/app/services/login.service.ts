import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  login(user): Observable<Response> {
    return this.http.post<Response>('http://localhost:6969/auth', user);
  }

  getToken(): string{
    return localStorage.getItem('jwt');
  }
}
