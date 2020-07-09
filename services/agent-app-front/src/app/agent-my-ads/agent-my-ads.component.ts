import { Component, OnInit } from '@angular/core';
import {AgentCreateAdService} from '../services/agent-create-ad.service';
import {Router} from '@angular/router';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {FormBuilder} from '@angular/forms';

@Component({
  selector: 'app-agent-my-ads',
  templateUrl: './agent-my-ads.component.html',
  styleUrls: ['./agent-my-ads.component.css']
})
export class AgentMyAdsComponent implements OnInit {
  ads: any = [];
  constructor(private agentCreateAdService: AgentCreateAdService , private router: Router, private modalService: NgbModal,
              private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.agentCreateAdService.getAds().subscribe((data: {}) => {
      this.ads = data;
      console.log(this.ads);
    });

  }

}
