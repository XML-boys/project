import { Component, OnInit } from '@angular/core';
import {AgentCreateAdService} from '../services/agent-create-ad.service';
import {Router} from '@angular/router';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {FormBuilder} from '@angular/forms';

@Component({
  selector: 'app-all-adds-agent-app',
  templateUrl: './all-adds-agent-app.component.html',
  styleUrls: ['./all-adds-agent-app.component.css']
})
export class AllAddsAgentAppComponent implements OnInit {
  ads: any = [];
  ad: any = [];
  closeResult: string;
  comments: any = [];
  votes: any = [];
  constructor(private agentCreateAdService: AgentCreateAdService , private router: Router, private modalService: NgbModal,
              private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.agentCreateAdService.getAllAds().subscribe((data: {}) => {
      this.ads = data;
    });
  }

  ReserveForMe(ad){
    this.ad = ad;
    this.agentCreateAdService.sendAdToAnother(this.ad);
    this.router.navigate(['/agent-app/agent-reserve-for-myself']);
  }

  OpenComments(openCom, comments, ad){
    this.comments = comments;
    this.ad = ad;
    this.modalService.open(openCom, {size: 'xl'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed`;
    });
  }

  OpenVote(openVot, votes, ad){
    this.votes = votes;
    this.ad = ad;
    this.modalService.open(openVot, {size: 'xl'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed`;
    });
  }

}
