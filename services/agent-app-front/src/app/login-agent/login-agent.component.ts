import { Component, OnInit } from '@angular/core';
import {LoginServiceService} from '../services/login-service.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login-agent',
  templateUrl: './login-agent.component.html',
  styleUrls: ['./login-agent.component.css']
})
export class LoginAgentComponent implements OnInit {
  loginForm: FormGroup;
  isSubmitted  =  false;
  loading = false;
  constructor(private service: LoginServiceService, private router: Router, private formBuilder: FormBuilder) { }

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
      role: 'Agent'
    };
    this.service.login(user).subscribe(
      data => {
        const str = JSON.stringify(data);
        const d = JSON.parse(str);
        localStorage.setItem('jwt', d.jwttoken);
        this.router.navigate(['/agent-app']);
      }, error => {
        console.log(error.status);
      }
    );
  }

}
