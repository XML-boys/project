import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {LoginServiceService} from '../services/login-service.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {ClientService} from '../services/client.service';

@Component({
  selector: 'app-client-login',
  templateUrl: './client-login.component.html',
  styleUrls: ['./client-login.component.css']
})
export class ClientLoginComponent implements OnInit {

  loginForm: FormGroup;
  isSubmitted = false;
  loading = false;

  ads: any = [];
  ad: any = [];
  closeResult: string;
  comments: any = [];
  votes: any = [];
  location: string;
  cena: string;


  constructor(private service: LoginServiceService, private clientService: ClientService,
              private router: Router, private modalService: NgbModal, private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });

    this.clientService.getAllAds().subscribe((data: {}) => {
      this.ads = data;
    });
  }

  // tslint:disable-next-line:typedef
  get formControls() {
    return this.loginForm.controls;
  }

  // tslint:disable-next-line:typedef
  login() {
    this.isSubmitted = true;
    if (this.loginForm.invalid) {
      return;
    }
    const user = {
      username: this.loginForm.value.username,
      password: this.loginForm.value.password,
      role: 'Client'
    };
    this.service.login(user).subscribe(
      data => {
        const str = JSON.stringify(data);
        const d = JSON.parse(str);
        localStorage.setItem('jwt', d.jwttoken);
        this.router.navigate(['/client']);
      }, error => {
        console.log(error.status);
      }
    );
  }

  // tslint:disable-next-line:typedef
  Register() {

  }

  // tslint:disable-next-line:typedef
  OpenComments(openCom, comments, ad){
    this.comments = comments;
    this.ad = ad;
    this.modalService.open(openCom, {size: 'xl'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed`;
    });
  }

  // tslint:disable-next-line:typedef
  OpenVote(openVot, votes, ad){
    this.votes = votes;
    this.ad = ad;
    this.modalService.open(openVot, {size: 'xl'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed`;
    });
  }

  // tslint:disable-next-line:typedef
  Search() {
    if (this.location !== '') {
      this.ads = this.ads.filter( res => {
        return res.location.toLocaleLowerCase().match(this.location.toLocaleLowerCase());
      });
    } else if (this.location === '') {
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
}
