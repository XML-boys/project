import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {ConfigService} from './config.service';
import {FormBuilder} from '@angular/forms';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {Router} from '@angular/router';
import {Observable} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {Agent} from '../shared/agent';
import {Client} from '../shared/client';
import {AdminUpravaComponent} from '../admin-uprava/admin-uprava.component';


@Injectable({
  providedIn: 'root'
})
export class AdminUpravaService {



  constructor(private http: HttpClient, private configService: ConfigService) {}

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    }).set('Authorization', 'Bearer ' + localStorage.getItem('jwt'))
  };

  getAllAgenti(): Observable<Agent> {
    return this.http.get<Agent>(this.configService.allAgents, this.httpOptions);
  }

  getAllClients(): Observable<Response> {
    return this.http.get<Response>(this.configService.allClients, {
      headers: new HttpHeaders().set('Authorization', 'Bearer ' + localStorage.getItem('jwt'))
    });
  }

  getAllComments(): Observable<Response> {
    return this.http.get<Response>(this.configService.allComments, {
      headers: new HttpHeaders().set('Authorization', 'Bearer ' + localStorage.getItem('jwt'))
    });
  }

  getAllVotes(): Observable<Response> {
    return this.http.get<Response>(this.configService.allVotes, {
      headers: new HttpHeaders().set('Authorization', 'Bearer ' + localStorage.getItem('jwt'))
    });
  }

  getAllUsers(): Observable<Response> {
    return this.http.get<Response>(this.configService.allUsers, {
      headers: new HttpHeaders().set('Authorization', 'Bearer ' + localStorage.getItem('jwt'))
    });
  }

  deleteClient(id): Observable<any> {
    return this.http.delete(this.configService.deleteClient + id);
  }

  deleteUser(id): Observable<any> {
    return this.http.delete(this.configService.deleteUser + id);
  }

  deleteComment(id): Observable<any> {
    return this.http.delete(this.configService.deleteComment + id);
  }

  putUser(user, id): Observable<any> {
    return this.http.put(this.configService.putUser + id, user, {
      headers: new HttpHeaders().set('Authorization', 'Bearer ' + localStorage.getItem('jwt'))
    });
  }

  putComment(comment, id): Observable<any> {
    return this.http.put(this.configService.putComment + id, comment, {
      headers: new HttpHeaders().set('Authorization', 'Bearer ' + localStorage.getItem('jwt'))
    });
  }
  putClient(client, id): Observable<any> {
    return this.http.put(this.configService.putClient + id, client, {
      headers: new HttpHeaders().set('Authorization', 'Bearer ' + localStorage.getItem('jwt'))
    });
  }


  /*kreiraj( id ): Observable<any> {
    return this.http.post<any>('http://localhost:8080/api/adminKC/kreirajKarton/' + id, {});
  }

  addHero (hero: Hero): Observable<Hero> {
  return this.http.post<Hero>(this.heroesUrl, hero, httpOptions)
    .pipe(
      catchError(this.handleError('addHero', hero))
    );
}
   */

}
