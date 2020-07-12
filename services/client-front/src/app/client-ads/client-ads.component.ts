import { Component, OnInit } from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {Router} from '@angular/router';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {ClientService} from '../services/client.service';

@Component({
  selector: 'app-client-ads',
  templateUrl: './client-ads.component.html',
  styleUrls: ['./client-ads.component.css']
})
export class ClientAdsComponent implements OnInit {
  ReservationForm = this.formBuilder.group({
    startTime: [''],
    endTime: [''],
    location: ['']
  });
  ads: any = [];
  ad: any = [];
  closeResult: string;
  lokacije: string[] = ['Beograd' , 'Novi Sad', 'Cacak', 'Sabac' , 'Sremska Mitrovica'];
  comments: any = [];
  votes: any = [];
  newComments: any = [];
  newVotes: any = [];
  vehicle: any = [];
  CommentForm = this.formBuilder.group({
    sadrzaj: ['']
  });
  VoteForm = this.formBuilder.group({
    vrednost: ['']
  });

  startTime: string;
  cena: string;
  vehicleId: string;
  constructor(private clientService: ClientService , private router: Router, private modalService: NgbModal,
              private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.clientService.getChosenAds().subscribe((data: {}) => {
      this.ads = data;
    });
  }

  // tslint:disable-next-line:typedef
  perica(openCom){
    this.clientService.getChosenAds().subscribe((data: {}) => {
      this.ads = data;
    });
    this.modalService.open(openCom, {size: 'xl'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed`;
    });
  }

  // tslint:disable-next-line:typedef
  ReserveForMe(ad){
    this.ad = ad;
    this.clientService.sendAdToAnother(this.ad);
    this.router.navigate(['/client/client-reserve-for-myself']);
    this.modalService.dismissAll();
  }

  // tslint:disable-next-line:typedef
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

  // tslint:disable-next-line:typedef
  MakeVote(addVote, votes, ad){
    this.newVotes = [];
    for (const vote of votes){
      if (vote.approved === true){
        this.newVotes.push(vote);
      }
    }
    this.votes = this.newVotes;
    this.ad = ad;
    this.modalService.open(addVote, {size: 'xl'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed`;
    });
  }

  // tslint:disable-next-line:typedef
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

  // tslint:disable-next-line:typedef
  sendComment(){
    this.modalService.dismissAll();
    return this.clientService.createComment(this.CommentForm.value, this.ad.id).subscribe();
  }

  // tslint:disable-next-line:typedef
  sendVote(){
    this.modalService.dismissAll();
    return this.clientService.createVote(this.VoteForm.value, this.ad.id).subscribe();
  }

  // tslint:disable-next-line:typedef
  Search() {
    if (this.startTime !== '') {
      this.ads = this.ads.filter( res => {
        return res.startTime.toLocaleLowerCase().match(this.startTime.toLocaleLowerCase());
      });
    } else if (this.startTime === '') {
      this.ngOnInit();
    }
  }

  // tslint:disable-next-line:typedef
  Search1() {
    if (this.cena !== '') {
      this.ads = this.ads.filter( res => {
        return res.cena.toLocaleLowerCase().match(this.cena.toLocaleLowerCase());
      });
    } else if (this.cena === '') {
      this.ngOnInit();
    }
  }

  // tslint:disable-next-line:typedef
  OpenDetails(openDetails, ad){
    this.ad = ad;
    this.newVotes = [];
    for (const vote of ad.votes){
      if (vote.approved === true){
        this.newVotes.push(vote);
      }
    }
    this.votes = this.newVotes;
    this.newComments = [];
    for (const comment of ad.comments){
      if (comment.approved === true){
        this.newComments.push(comment);
      }
    }
    this.comments = this.newComments;
    this.clientService.getVehicleById(this.ad.vehicleId).subscribe((data: {}) => {
      this.vehicle = data;
    });
    this.modalService.open(openDetails, {size: 'xl'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed`;
    });
  }


}
