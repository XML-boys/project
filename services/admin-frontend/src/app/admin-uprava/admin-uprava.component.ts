import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {FormBuilder} from '@angular/forms';
import {AdminUpravaService} from '../services/admin-uprava.service';

@Component({
  selector: 'app-admin-uprava',
  templateUrl: './admin-uprava.component.html',
  styleUrls: ['./admin-uprava.component.css']
})
export class AdminUpravaComponent implements OnInit {


  users: any = [];
  coments: any = [];
  votes: any = [];
  clients: any = [];


  constructor(private adminUpravaService: AdminUpravaService , private router: Router, private modalService: NgbModal,
              private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.ucitajUsere();
    this.ucitajKomentare();
    this.ucitajOcene();
    this.ucitajKliente();
  }

  ucitajUsere() {
    this.adminUpravaService.getAllUsers()
      .subscribe((data: {}) => {
          this.users = data;
          console.log(data);
        }
      );
  }

  ucitajKomentare() {
    this.adminUpravaService.getAllComments()
      .subscribe((data: {}) => {
          this.coments = data;
          console.log(data);
        }
      );
  }

  ucitajOcene() {
    this.adminUpravaService.getAllVotes()
      .subscribe((data: {}) => {
          this.votes = data;
          console.log(data);
        }
      );
  }

  ucitajKliente() {
    this.adminUpravaService.getAllClients()
      .subscribe((data: {}) => {
          this.clients = data;
          console.log(data);
        }
      );
  }

  open(user) {
    user.approved = true;
    this.adminUpravaService.putUser(user, user.id);
  }

  open1(user) {
    this.adminUpravaService.deleteUser(user.id);
  }

  open4(user) {
    user.blocked = true;
    this.adminUpravaService.putUser(user, user.id);
  }

  open5(user) {
    user.blocked = false;
    this.adminUpravaService.putUser(user, user.id);
  }

  open3(user) {
    user.role = 'Client';
    this.adminUpravaService.putUser(user, user.id);
  }

  open6(user) {
    user.role = 'Agent';
    this.adminUpravaService.putUser(user, user.id);
  }

  open7(user) {
    user.role = 'ADMIN';
    this.adminUpravaService.putUser(user, user.id);
  }

  open8(coment) {
    coment.approved = true;
    this.adminUpravaService.putComment(coment, coment.id);
  }

  open9(coment) {
    this.adminUpravaService.deleteComment(coment.id);
  }

  open10(client) {
    client.blocked = true;
    this.adminUpravaService.putClient(client, client.id);
  }

  open11(client) {
    client.blocked = false;
    this.adminUpravaService.putClient(client, client.id);
  }
}
