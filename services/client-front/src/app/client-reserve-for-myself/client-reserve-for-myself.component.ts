import { Component, OnInit } from '@angular/core';
import {ClientService} from '../services/client.service';
import {Router} from '@angular/router';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {FormBuilder} from '@angular/forms';

@Component({
  selector: 'app-client-reserve-for-myself',
  templateUrl: './client-reserve-for-myself.component.html',
  styleUrls: ['./client-reserve-for-myself.component.css']
})
export class ClientReserveForMyselfComponent implements OnInit {
  ReservationForm = this.formBuilder.group({
    startTime: [''],
    endTime: [''],
  });
  ad: any = [];
  constructor(private clientService: ClientService, private router: Router, private modalService: NgbModal,
              private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.ad = this.clientService.returnAdToAnother();
  }

  // tslint:disable-next-line:typedef
  perica(){
    this.router.navigate(['/client/clientAds']);
    return this.clientService.createReservation(this.ReservationForm.value, this.ad.id).subscribe();
  }
}
