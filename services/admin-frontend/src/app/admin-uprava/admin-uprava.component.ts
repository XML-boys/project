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
    this.adminUpravaService.putUserApproved(user.id).subscribe();
    this.ucitajUsere();
  }

  open1(user) {
    this.adminUpravaService.deleteUser(user.id).subscribe();
    this.ucitajUsere();
  }

  open3(user) {
    this.adminUpravaService.putUserRole('Client', user.id).subscribe();
    this.ucitajUsere();
  }

  open6(user) {
    this.adminUpravaService.putUserRole('Agent', user.id).subscribe();
    this.ucitajUsere();
  }

  open7(user) {
    this.adminUpravaService.putUserRole('ADMIN', user.id).subscribe();
    this.ucitajUsere();
  }

  open8(coment, id) {
    coment.approved = true;
    console.log(id);
    this.adminUpravaService.putCommentApproved(coment, id).subscribe();
    this.ucitajKomentare();
  }

  open9(comment, id) {
    this.adminUpravaService.deleteComment(comment.reklamak.id, id).subscribe();
    this.ucitajKomentare();
  }

  open10(client) {
    this.adminUpravaService.putClientBlock(client.id).subscribe();
    this.ucitajKliente();
  }

  open11(client) {
    this.adminUpravaService.putClientBlockN(client.id).subscribe();
    this.ucitajKliente();
  }

  open110(vote, id) {
    vote.approved = true;
    this.adminUpravaService.putVoteApproved(vote, id).subscribe();
    this.ucitajOcene();
  }

  open111(idReklame, id) {
    this.adminUpravaService.deleteVote(idReklame, id).subscribe();
    this.ucitajOcene();
  }
}
