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
    })
  };

  getAllAgenti(): Observable<Agent> {
    return this.http.get<Agent>(this.configService.allAgents, this.httpOptions);
  }

  /*getAllClients(): Observable<Response> {
    return this.http.get<Response>(this.configService.allClients, {
      headers: new HttpHeaders().set('Authorization', 'Bearer ' + localStorage.getItem('jwt'))
    });
  }*/

  getAllClients(): Observable<Response> {
    return this.http.get<Response>('http://localhost:6969/client');
  }

  getAllUsers(): Observable<Response> {
    console.log(localStorage.getItem('jwt'));
    return this.http.get<Response>('http://localhost:6969/user');
  }

  getAllComments(): Observable<Response> {
    return this.http.get<Response>(this.configService.allComments, {
      headers: new HttpHeaders().set('Authorization', `Bearer ${localStorage.getItem('jwt')}`)
    });
  }

  getAllVotes(): Observable<Response> {
    return this.http.get<Response>(this.configService.allVotes, {
      headers: new HttpHeaders().set('Authorization', 'Bearer ' + localStorage.getItem('jwt'))
    });
  }

  /*getAllUsers(): Observable<Response> {
    return this.http.get<Response>(this.configService.allUsers, {
      headers: new HttpHeaders().set('Authorization', 'Bearer ' + localStorage.getItem('jwt'))
    });
  }*/

  deleteClient(id): Observable<any> {
    return this.http.delete(this.configService.deleteClient + id);
  }

  deleteUser(id): Observable<any> {
    return this.http.delete(this.configService.deleteUser + id);
  }

  deleteComment(adId, id): Observable<any> {
    return this.http.delete('http://localhost:6969/comment/' + adId + '/' + id);
  }

  deleteVote(idReklame, id): Observable<any> {
    return this.http.delete('http://localhost:6969/vote/' + idReklame + '/' + id);
  }

  putUser(id): Observable<any> {
    return this.http.put('http://localhost:6969/user/' + id + '/approved/true', {
      headers: new HttpHeaders().set('Authorization', 'Bearer ' + localStorage.getItem('jwt'))
    });
  }

  putUserApproved(id): Observable<any> {
    return this.http.put('http://localhost:6969/user/' + id + '/approved/true', {
      headers: new HttpHeaders().set('Authorization', 'Bearer ' + localStorage.getItem('jwt'))
    });
  }

  putUserRole(role, id): Observable<any> {
    return this.http.put('http://localhost:6969/user/' + id + '/role', role , this.httpOptions);
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

  putClientBlock(id): Observable<any> {
    return this.http.put('http://localhost:6969/client/' + id + '/blocked/true', 'caos');
  }

  putClientBlockN(id): Observable<any> {
    return this.http.put('http://localhost:6969/client/' + id + '/blocked/false', {
      headers: new HttpHeaders().set('Authorization', 'Bearer ' + localStorage.getItem('jwt'))
    });
  }

  putCommentApproved(comment, id): Observable<any> {
    console.log('opaljen');
    return this.http.put('http://localhost:6969/comment/' + id + '/approved/true', null , {
      headers: new HttpHeaders().set('Authorization', 'Bearer ' + localStorage.getItem('jwt'))
    });
  }

  putVoteApproved(vote, id): Observable<any> {
    return this.http.put('http://localhost:6969/vote/' + id + '/approved/true', vote , {
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
