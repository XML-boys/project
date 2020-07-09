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
  id;
  model;
  evoId(id){
    return this.id = id;
  }

  uzmiId(){
    return this.id;
  }

  evoModel(model){
    this.model = model;
  }

  uzmiModel(){
    return this.model;
  }

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
    return this.http.delete('http://localhost:6969/codeBook/' + idVehicle + '/model/' + idModel);
  }

  putModel(idCodeItem, idModela, model): Observable<any> {
    return this.http.put('http://localhost:6969/codeBook/' + idCodeItem + '/model/' + idModela, model, this.httpOptions );
  }

  putCodeItem(ci, id): Observable<any> {
    return this.http.put(this.configService.putCodeItem + id, ci, {} );
  }

  postCodeItem(CodeItems) {
    return this.http.post(this.configService.postCodeItem, CodeItems);
  }

  postModel(model, id) {
    console.log(JSON.stringify(model));
    return this.http.post('http://localhost:6969/codeBook/' + id + '/model', JSON.stringify(model) , this.httpOptions );
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
