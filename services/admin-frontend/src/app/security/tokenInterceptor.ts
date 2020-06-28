import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import {LoginService} from '../services/login.service';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {
  userTokenState: string;

  constructor(public auth: LoginService) {
  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        console.log('pokrenut interseptor');
        request = request.clone({
          setHeaders: {
            Authorization: `Bearer ${this.auth.getToken()}`
          }
        });
        console.log('prosledjen');
        return next.handle(request);
  }

}
