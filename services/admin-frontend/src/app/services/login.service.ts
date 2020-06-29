import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient, private router: Router) {
  }

  login(user): Observable<Response> {
    return this.http.post<Response>('http://localhost:6969/auth', user);
  }

  getToken(): string {
    console.log(localStorage.getItem('jwt'));
    return localStorage.getItem('jwt');
  }

  logout() {
    localStorage.removeItem('jwt');
    this.router.navigate(['/']);
  }
}
