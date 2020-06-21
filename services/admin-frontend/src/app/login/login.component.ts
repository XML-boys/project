import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {LoginService} from '../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  isSubmitted  =  false;
  loading = false;
  constructor(private service: LoginService, private router: Router, private formBuilder: FormBuilder ) { }

  ngOnInit(): void {
    this.loginForm  =  this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  get formControls() { return this.loginForm.controls; }

  login(){
    this.isSubmitted = true;
    if (this.loginForm.invalid){
      return;
    }
    const user = {
      username: this.loginForm.value.username,
      password: this.loginForm.value.password,
      role: 'ADMIN'
    };
    this.service.login(user).subscribe(
      data => {
        const str = JSON.stringify(data);
        const d = JSON.parse(str);
        localStorage.setItem('jwt', d.jwttoken);
        this.router.navigate(['/admin']);
      }, error => {
        console.log(error.status);
      }
    );
  }

}
