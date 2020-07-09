import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {FormBuilder} from '@angular/forms';
import {AgentCreateAdService} from '../services/agent-create-ad.service';
import {MatFormFieldModule} from '@angular/material/form-field';

@Component({
  selector: 'app-agent-create-ad',
  templateUrl: './agent-create-ad.component.html',
  styleUrls: ['./agent-create-ad.component.css']
})
export class AgentCreateAdComponent implements OnInit {
  lokacije: string[] = ['Beograd' , 'Novi Sad', 'Cacak', 'Sabac' , 'Sremska Mitrovica'];
  vehicles: any = [];
  selectedVehicleId;

  AdForm = this.formBuilder.group({
    vehicleId: [''],
    startTime: [''],
    endDate: [''],
    location: [''],
    cena: [''],
    damage: ['']
  });

  constructor(private agentCreateAdService: AgentCreateAdService , private router: Router, private modalService: NgbModal,
              private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.agentCreateAdService.getAllVehicle().subscribe((data: {}) => {
      this.vehicles = data;
    });
  }


  perica() {
    this.agentCreateAdService.createAd(this.AdForm.value).subscribe();
  }


}
