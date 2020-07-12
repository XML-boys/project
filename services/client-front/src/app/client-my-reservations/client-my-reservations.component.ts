import { Component, OnInit } from '@angular/core';
import {ClientService} from '../services/client.service';
import {Router} from '@angular/router';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {FormBuilder} from '@angular/forms';

@Component({
  selector: 'app-client-my-reservations',
  templateUrl: './client-my-reservations.component.html',
  styleUrls: ['./client-my-reservations.component.css']
})
export class ClientMyReservationsComponent implements OnInit {
  reservations: any = [];
  idClienta;
  ads: any = [];
  ad: any = [];
  rez: any = [];
  constructor(private clientService: ClientService , private router: Router, private modalService: NgbModal,
              private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.idClienta = this.clientService.uzmiId();
    this.clientService.getMyReservations(this.clientService.uzmiId()).subscribe((data: {}) => {
      this.reservations = data;
    });
    this.clientService.getAllAds().subscribe((data: {}) => {
      this.ads = data;
    });
  }

  // tslint:disable-next-line:typedef
  DeleteRez(reservation) {
    for (this.ad of this.ads){
      for (this.rez of this.ad.reservations){
        if (this.rez.id === reservation.id){
          reservation.state = 'Declined';
          return this.clientService.approveRes(reservation, this.ad.id, reservation.id).subscribe();
        }
      }
    }
  }

}
