import { Component, OnInit } from '@angular/core';
import {AdminRegisterAgentService} from '../services/admin-register-agent.service';
import {Router} from '@angular/router';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-admin-register-admin',
  templateUrl: './admin-register-admin.component.html',
  styleUrls: ['./admin-register-admin.component.css']
})
export class AdminRegisterAdminComponent implements OnInit {

  AdminForm: FormGroup;

  constructor(private adminRegisterAgentService: AdminRegisterAgentService , private router: Router, private modalService: NgbModal,
              private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.AdminForm  =  this.formBuilder.group({
      username: [''],
      password: [''],
      email: [''],
      firstName: [''],
      lastName: ['']
    });
  }

  submit() {
    this.adminRegisterAgentService.postAdmin(this.AdminForm.value).subscribe((data: {}) => {console.log(data); });

  }

}
