import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {FormBuilder} from '@angular/forms';
import {AgentCreateAdService} from '../services/agent-create-ad.service';
import {MatDatepicker} from '@angular/material';
import {Subject} from 'rxjs';
import {Ad} from '../classes/Ad';

@Component({
  selector: 'app-agent-create-ad',
  templateUrl: './agent-create-ad.component.html',
  styleUrls: ['./agent-create-ad.component.css']
})
export class AgentCreateAdComponent implements OnInit {
  ads: any = [];
  locations: any = [];
  ad: any = [];
  add: Ad;
  dropDisabled: boolean;
  selected = '';

  dmg: boolean;
  notdmg: boolean;

  dmgBTN: any;
  notdmgBTN: any;
  events: any;
  refresh: Subject<any> = new Subject();
  source: any;
  constructor(private agentCreateAdService: AgentCreateAdService , private router: Router, private modalService: NgbModal,
              private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.getAds();
    this.getLocations();
  }

  getAds(){
    this.agentCreateAdService.getAds()
      .subscribe((data: {}) => {
          this.ads = data;
          console.log(data);
        }
      );
  }

  getLocations(){
    this.agentCreateAdService.getLocations()
      .subscribe((data: {}) => {
          this.locations = data;
          console.log(data);
        }
      );
  }

  onItemChange(value: any) {
    this.dmgBTN = document.getElementById('dmg');
    this.notdmgBTN = document.getElementById('notdmg');
    if (this.dmgBTN.checked) {
      this.ad.damage = true;
    } else if (this.notdmgBTN.checked) {
      this.ad.damage = false;
    }
  }

  open() {
  }

  updateSource($event: Event) {
    // this.add.pictures = $event.target[0];
  }

  submitPhoto() {
  }

  getFile($event: any) {}


}
