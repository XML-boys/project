import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {ConfigService} from './config.service';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AgentCreateAdService {

  constructor(private http: HttpClient, private configService: ConfigService) { }
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  id;
  model;
  ad: any = [];
  evoId(id){
    return this.id = id;
  }

  uzmiId(){
    return this.id;
  }

  sendAdToAnother(ad){
    this.ad = ad;
  }

  returnAdToAnother(){
    return this.ad;
  }

  getAds(): Observable<any> {
    return this.http.get<any>(this.configService.agentAds, this.httpOptions);
  }

  getLocations(): Observable<any> {
    return this.http.get<any>(this.configService.allLocations, this.httpOptions);
  }

  getAllVehicle(): Observable<any> {
    return this.http.get<any>('http://localhost:6969/vehicles/');
  }

  getAllVendors(): Observable<any> {
    return this.http.get<any>(this.configService.allVendors, this.httpOptions);
  }

  createAd(ad): Observable<any> {
    return this.http.post<any>('http://localhost:6969/ad', ad);
  }

  createVehicle(ad): Observable<any> {
    return this.http.post<any>('http://localhost:6969/vehicles', ad);
  }

  getModelsByVendor(name): Observable<any> {
    return this.http.get<any>('http://localhost:6969/codeBook/vendor/' + name);
  }

  getAllItems(): Observable<any> {
    return this.http.get<any>(this.configService.allItems, this.httpOptions);
  }

  approveRes(reservation, adId, reservationId): Observable<any> {
    return this.http.put('http://localhost:6969/reservation/' + adId + '/' + reservationId, reservation, this.httpOptions );
  }

  deleteRes(adId, reservationId): Observable<any> {
    return this.http.delete('http://localhost:6969/reservation/' + adId + '/' + reservationId);
  }

  deleteComment(adId, commentId): Observable<any> {
    return this.http.delete('http://localhost:6969/comment/' + adId + '/' + commentId);
  }

  deleteVote(adId, voteId): Observable<any> {
    return this.http.delete('http://localhost:6969/vote/' + adId + '/' + voteId);
  }

  createReservation(reservation, adId): Observable<any> {
    return this.http.post<any>('http://localhost:6969/reservation/' + adId, reservation, this.httpOptions);
  }

  getAgentData(): Observable<any> {
    return this.http.get<any>('http://localhost:6969/agent/me/user/1');
  }

  updateAgent(agent, id): Observable<any> {
    return this.http.put<any>('http://localhost:6969/agent/' + id, agent, this.httpOptions);
  }

  getAllAds(): Observable<any> {
    return this.http.get<any>(this.configService.allAds, this.httpOptions);
  }

  getVehicles(): Observable<any> {
    return this.http.get<any>(this.configService.allVehicles, this.httpOptions);
  }

  deleteVehicle(VehicleId): Observable<any> {
    return this.http.delete('http://localhost:6969/vehicles/' + VehicleId);
  }

  createComment(comment, adId): Observable<any> {
    return this.http.post<any>('http://localhost:6969/comment/' + adId, comment, this.httpOptions);
  }

  createVote(vote, adId): Observable<any> {
    return this.http.post<any>('http://localhost:6969/vote/' + adId, vote, this.httpOptions);
  }

}
