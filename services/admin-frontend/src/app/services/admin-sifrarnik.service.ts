import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {ConfigService} from './config.service';
import {Observable} from 'rxjs';
import {Agent} from '../shared/agent';

@Injectable({
  providedIn: 'root'
})
export class AdminSifrarnikService {

  constructor(private http: HttpClient, private configService: ConfigService) { }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  getAllItems(): Observable<any> {
    return this.http.get<any>(this.configService.allItems, this.httpOptions);
  }

  deleteVendor(id): Observable<any> {
    return this.http.delete(this.configService.deleteVendor + id);
  }

  deleteModel(idVehicle, idModel): Observable<any> {
    return this.http.delete(this.configService.deleteModel + idVehicle + idModel);
  }

  putModel(model, id): Observable<any> {
    return this.http.put(this.configService.putModel + id, model, {} );
  }

  putCodeItem(ci, id): Observable<any> {
    return this.http.put(this.configService.putCodeItem + id, ci, {} );
  }

  postCodeItem(CodeItems) {
    return this.http.post(this.configService.postCodeItem, CodeItems);
  }

  postModel(Model) {
    return this.http.post(this.configService.postModel, Model);
  }
}
