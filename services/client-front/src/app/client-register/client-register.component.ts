import { Component, OnInit } from '@angular/core';
import {LoginServiceService} from '../services/login-service.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';

@Component({
  selector: 'app-client-register',
  templateUrl: './client-register.component.html',
  styleUrls: ['./client-register.component.css']
})
export class ClientRegisterComponent implements OnInit {

  loginForm: FormGroup;
  isSubmitted  =  false;
  constructor(private service: LoginServiceService, private router: Router, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.loginForm  =  this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
      email: ['', Validators.required]
    });
  }

  // tslint:disable-next-line:typedef
  get formControls() { return this.loginForm.controls; }


  // tslint:disable-next-line:typedef
  register(){
    this.isSubmitted = true;
    if (this.loginForm.invalid){
      console.log(this.loginForm.controls);
      console.log('ne valja');
      this.isSubmitted = false;
      return;
    }
    const user = {
      username: this.loginForm.value.username,
      password: this.loginForm.value.password,
      email: this.loginForm.value.email,
      role: 'Client'
    };
    this.service.register(user).subscribe(
      data => {
        this.router.navigate(['/client/login']);
      }, error => {
        console.log(error.status);
      }
    );

}}
