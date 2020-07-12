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
  ad: any = [];
  agent: any = {};
  closeResult: string;
  reservations: any = [];
  comments: any = [];
  votes: any = [];
  newComments: any = [];
  newVotes: any = [];

  CommentForm = this.formBuilder.group({
    sadrzaj: ['']
  });
  constructor(private agentCreateAdService: AgentCreateAdService , private router: Router, private modalService: NgbModal,
              private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.agentCreateAdService.getAds().subscribe((data: {}) => {
      this.ads = data;
    });
    this.agentCreateAdService.getAgentData().subscribe((data: {}) => {
      this.agent = data;
      console.log(this.agent);
    });

  }

  OpenReservations(openRez, reservations, ad){
    this.reservations = reservations;
    this.ad = ad;
    this.modalService.open(openRez, {size: 'xl'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed`;
    });
  }

  OpenComments(openCom, comments, ad){
    this.newComments = [];
    for (const comment of comments){
      if (comment.approved === true){
        this.newComments.push(comment);
      }
    }
    this.comments = this.newComments;
    this.ad = ad;
    this.modalService.open(openCom, {size: 'xl'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed`;
    });
  }

  OpenVote(openVot, votes, ad){
    this.newVotes = [];
    for (const vote of votes){
      if (vote.approved === true){
        this.newVotes.push(vote);
      }
    }
    this.votes = this.newVotes;
    this.ad = ad;
    this.modalService.open(openVot, {size: 'xl'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed`;
    });
  }

  OdobriRez(reservation) {
    reservation.state = 'Reserved';
    this.agentCreateAdService.approveRes(reservation, this.ad.id, reservation.id).subscribe();
  }

  DeleteRez(reservation) {
    reservation.state = 'Declined';
    this.agentCreateAdService.approveRes(reservation, this.ad.id, reservation.id).subscribe();
  }

  DeleteCom(comment) {
    this.agentCreateAdService.deleteComment(this.ad.id, comment.id).subscribe();
  }

  DeleteVote(vote) {
    this.agentCreateAdService.deleteVote(this.ad.id, vote.id).subscribe();
  }

  ReserveForMe(ad){
    this.ad = ad;
    this.agentCreateAdService.sendAdToAnother(this.ad);
    this.router.navigate(['/agent-app/agent-reserve-for-myself']);
  }

  // tslint:disable-next-line:typedef
  sendComment(){
    this.modalService.dismissAll();
    return this.agentCreateAdService.createComment(this.CommentForm.value, this.ad.id).subscribe();
  }

  // tslint:disable-next-line:typedef
  MakeComment(addComment, comments, ad){
    this.newComments = [];
    for (const comment of comments){
      if (comment.approved === true){
        this.newComments.push(comment);
      }
    }
    this.comments = this.newComments;
    this.ad = ad;
    this.modalService.open(addComment, {size: 'xl'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed`;
    });
  }
}
