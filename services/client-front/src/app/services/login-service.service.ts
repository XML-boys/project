import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  constructor(private http: HttpClient, private router: Router) {
  }
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  login(user): Observable<Response> {
    return this.http.post<Response>('http://localhost:6969/auth', user);
  }

  register(user): Observable<Response> {
    return this.http.post<Response>('http://localhost:6969/reg', user, this.httpOptions);
  }

  getToken(): string {
    return localStorage.getItem('jwt');
  }

  myInfo(): Observable<any> {
    return this.http.get<any>('http://localhost:6969/me');
  }

  // tslint:disable-next-line:typedef
  logout() {
    localStorage.removeItem('jwt');
    this.router.navigate(['/']);
  }
}
