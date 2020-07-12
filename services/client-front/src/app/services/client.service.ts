import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Router} from '@angular/router';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private http: HttpClient, private router: Router) { }
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };
  ad: any = [];
  id;
  reservations: any = [];
  ads: any = [];
  // tslint:disable-next-line:typedef
  evoId(id){
    return this.id = id;
  }

  // tslint:disable-next-line:typedef
  uzmiId(){
    return this.id;
  }

  // tslint:disable-next-line:typedef
  evoRezervacije(res){
    this.reservations = res;
  }

  // tslint:disable-next-line:typedef
  uzmiRezervacije(){
    return this.reservations;
  }
  // tslint:disable-next-line:typedef
  evoAds(ads){
    this.ads = ads;
  }

  // tslint:disable-next-line:typedef
  uzmiAds(){
    return this.ads;
  }
  getClient(): Observable<any> {
    return this.http.get<any>('http://localhost:6969/me');
  }

  updateClient(client,id): Observable<any> {
    return this.http.put('http://localhost:6969/client/' + id, client, this.httpOptions );
  }

  getChosenAds(): Observable<any> {
    return this.http.get<any>('http://localhost:6969/ad', this.httpOptions);
  }

  // tslint:disable-next-line:typedef
  sendAdToAnother(ad){
    this.ad = ad;
  }

  // tslint:disable-next-line:typedef
  returnAdToAnother(){
    return this.ad;
  }

  createVote(vote, adId): Observable<any> {
    return this.http.post<any>('http://localhost:6969/vote/' + adId, vote, this.httpOptions);
  }

  createComment(comment, adId): Observable<any> {
    return this.http.post<any>('http://localhost:6969/comment/' + adId, comment, this.httpOptions);
  }

  createReservation(reservation, adId): Observable<any> {
    return this.http.post<any>('http://localhost:6969/reservation/' + adId, reservation, this.httpOptions);
  }

  getMyReservations(id): Observable<any> {
    return this.http.get<any>('http://localhost:6969/reservation/' + id + '/client', this.httpOptions);
  }

  getAllAds(): Observable<any> {
    return this.http.get<any>('http://localhost:6969/ad', this.httpOptions);
  }

  getVehicleById(id): Observable<any> {
    return this.http.get<any>('http://localhost:6969/vehicles/' + id, this.httpOptions);
  }

  approveRes(reservation, adId, reservationId): Observable<any> {
    return this.http.put('http://localhost:6969/reservation/' + adId + '/' + reservationId, reservation, this.httpOptions );
  }
}
