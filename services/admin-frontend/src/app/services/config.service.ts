import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  private apiUri = 'http://localhost:6969/';

  get allAgents(): string {
    return this.apiUri + '/agent';
  }

  get allItems(): string {
    return this.apiUri + '/codeBook';
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

  get deleteModel(): string {
    return this.apiUri + '/codeBook/{idVehicle}/model/{idModel}';
  }

  get deleteUser(): string {
    return this.apiUri + '/user';
  }

  get deleteVendor(): string {
    return this.apiUri + '/codeBook';
  }

  get deleteComment(): string {
    return this.apiUri + '/comment';
  }

  get putClient(): string {
    return this.apiUri + '/client';
  }

  get putCodeItem(): string {
    return this.apiUri + '/codeItem';
  }

  get putModel(): string {
    return this.apiUri + '/vehicleModel';
  }

  get putUser(): string {
    return this.apiUri + '/user';
  }

  get putComment(): string {
    return this.apiUri + '/comment';
  }

  get postCodeItem(): string {
    return this.apiUri + '/codeItem';
  }
  get postModel(): string {
    return this.apiUri + '/vehicleModel';
  }

  get postAgents(): string {
    return this.apiUri + '/agents';
  }
}