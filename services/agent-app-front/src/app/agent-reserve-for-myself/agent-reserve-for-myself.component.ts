import { Component, OnInit } from '@angular/core';
import {AgentCreateAdService} from '../services/agent-create-ad.service';
import {Router} from '@angular/router';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {FormBuilder} from '@angular/forms';

@Component({
  selector: 'app-agent-reserve-for-myself',
  templateUrl: './agent-reserve-for-myself.component.html',
  styleUrls: ['./agent-reserve-for-myself.component.css']
})
export class AgentReserveForMyselfComponent implements OnInit {

  ReservationForm = this.formBuilder.group({
    startTime: [''],
    endTime: [''],
  });
  ad: any = [];
  constructor(private agentCreateAdService: AgentCreateAdService , private router: Router, private modalService: NgbModal,
              private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.ad = this.agentCreateAdService.returnAdToAnother();
  }

  perica(){
    this.router.navigate(['/agent-app/myAds']);
    return this.agentCreateAdService.createReservation(this.ReservationForm.value, this.ad.id).subscribe();
  }

}
