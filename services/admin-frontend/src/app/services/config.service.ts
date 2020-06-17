import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  private apiUri = 'http://localhost:6969/';

  get allAgents(): string {
    return this.apiUri + '/agent';
  }

  get allClients(): string {
    return this.apiUri + '/client';
  }

  get allComments(): string {
    return this.apiUri + '/comment';
  }

  get allVotes(): string {
    return this.apiUri + '/vote';
  }

  get allUsers(): string {
    return this.apiUri + '/user';
  }

  get deleteClient(): string {
    return this.apiUri + '/client';
  }

  get deleteUser(): string {
    return this.apiUri + '/user';
  }

  get deleteComment(): string {
    return this.apiUri + '/comment';
  }

  get putClient(): string {
    return this.apiUri + '/client';
  }

  get putAgent(): string {
    return this.apiUri + '/agent';
  }

  get putUser(): string {
    return this.apiUri + '/user';
  }

  get putComment(): string {
    return this.apiUri + '/comment';
  }
}
