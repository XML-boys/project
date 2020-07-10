import { Component, OnInit } from '@angular/core';
import {AgentCreateAdService} from '../services/agent-create-ad.service';
import {Router} from '@angular/router';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {FormBuilder} from '@angular/forms';

@Component({
  selector: 'app-all-vehicles-agent-app',
  templateUrl: './all-vehicles-agent-app.component.html',
  styleUrls: ['./all-vehicles-agent-app.component.css']
})
export class AllVehiclesAgentAppComponent implements OnInit {
  vehicles: any = [];

  constructor(private agentCreateAdService: AgentCreateAdService , private router: Router, private modalService: NgbModal,
              private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.agentCreateAdService.getVehicles().subscribe((data: {}) => {
      this.vehicles = data;
    });
  }

  deleteVehicle(id){
    this.agentCreateAdService.deleteVehicle(id).subscribe();
  }

}
