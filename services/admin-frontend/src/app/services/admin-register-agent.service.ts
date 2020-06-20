import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {ConfigService} from './config.service';
import {Observable} from 'rxjs';
import {Agent} from '../shared/agent';

@Injectable({
  providedIn: 'root'
})
export class AdminRegisterAgentService {

  constructor(private http: HttpClient, private configService: ConfigService) { }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  getAgents(): Observable<Agent> {
    return this.http.get<Agent>(this.configService.allAgents, this.httpOptions);
  }

  postAgents(Agents) {
    return this.http.post(this.configService.postAgents, Agents);
  }
}
