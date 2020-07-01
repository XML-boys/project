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


  constructor(private adminUpravaService: AdminUpravaService , private router: Router, private modalService: NgbModal,
              private formBuilder: FormBuilder) { }


  users: any = [];
  coments: any = [];
  votes: any = [];
  clients: any = [];

  token: string;
  ngOnInit(): void {
    this.ucitajUsere();
    this.ucitajKomentare();
    this.ucitajOcene();
    this.ucitajKliente();
    this.getToken();
  }

  getToken(){
    this.token = localStorage.getItem('jwt');
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
    this.adminUpravaService.putUserApproved(user.id);
  }

  open1(user) {
    this.adminUpravaService.deleteUser(user.id);
  }

  open3(user) {
    this.adminUpravaService.putUserRole('Client', user.id);
  }

  open6(user) {
    this.adminUpravaService.putUserRole('Agent', user.id);
  }

  open7(user) {
    this.adminUpravaService.putUserRole('ADMIN', user.id);
  }

  open8(coment, id) {
    coment.approved = true;
    console.log(id);
    this.adminUpravaService.putCommentApproved(coment, id).subscribe();
    this.ucitajKomentare();
  }

  open9(id) {
    this.adminUpravaService.deleteComment(id).subscribe();
  }

  open10(client) {
    this.adminUpravaService.putClientBlock(client.id).subscribe();
  }

  open11(client) {
    this.adminUpravaService.putClientBlockN(client.id).subscribe();
  }

  open110(vote, id) {
    vote.approved = true;
    this.adminUpravaService.putVoteApproved(vote, id).subscribe();
  }

  open111(id) {
    this.adminUpravaService.deleteVote(id).subscribe();
    this.ucitajOcene();
  }
}
