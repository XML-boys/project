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

  getAllVendors(): Observable<any> {
    return this.http.get<any>(this.configService.allVendors, this.httpOptions);
  }

  deleteVendor(Vendor): Observable<any> {
    return this.http.delete(this.configService.deleteVendor + Vendor);
  }

  deleteModel(idVehicle, idModel): Observable<any> {
    return this.http.delete('http://localhost:6969/codeBook/' + idVehicle + 'model' + idModel);
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

  postVendor(Vendor) {
    return this.http.post(this.configService.postCodeItem, Vendor, this.httpOptions);
  }

  putVendor(id, ci): Observable<any> {
    return this.http.put(this.configService.putCodeItem + id, ci, this.httpOptions);
  }

  getModels(vendor): Observable<any> {
    return this.http.get<any>('http://localhost:6969/codeBook/vendor/' + vendor);
  }
}
