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


@Injectable({
  providedIn: 'root'
})
export class AdminUpravaService {



  constructor(private http: HttpClient, private configService: ConfigService) {}

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  getAllAgenti(): Observable<Agent> {
    return this.http.get<Agent>(this.configService.allAgents, this.httpOptions);
  }

  getAllClients(): Observable<Client> {
    return this.http.get<Client>(this.configService.allClients, this.httpOptions);
  }

  getAllComments(): Observable<Client> {
    return this.http.get<Client>(this.configService.allComments, this.httpOptions);
  }

  getAllVotes(): Observable<Client> {
    return this.http.get<Client>(this.configService.allVotes, this.httpOptions);
  }

  getAllUsers(): Observable<Client> {
    return this.http.get<Client>(this.configService.allUsers, this.httpOptions);
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
    return this.http.put(this.configService.putUser + id, user, {} );
  }

  putComment(comment, id): Observable<any> {
    return this.http.put(this.configService.putComment + id, comment, {} );
  }

  putClient(client, id): Observable<any> {
    return this.http.put(this.configService.putClient + id, client, {} );
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
