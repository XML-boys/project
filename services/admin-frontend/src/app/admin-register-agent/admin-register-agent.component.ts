import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {FormBuilder, FormGroup} from '@angular/forms';
import {AdminRegisterAgentService} from '../services/admin-register-agent.service';
import {AgentRegister} from '../shared/agentRegister';

@Component({
  selector: 'app-admin-register-agent',
  templateUrl: './admin-register-agent.component.html',
  styleUrls: ['./admin-register-agent.component.css']
})
export class AdminRegisterAgentComponent implements OnInit {

  AgentForm: FormGroup;


  constructor(private adminRegisterAgentService: AdminRegisterAgentService , private router: Router, private modalService: NgbModal,
              private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.AgentForm  =  this.formBuilder.group({
      username: [''],
      password: [''],
      email: [''],
      name: [''],
      companyIdentifier: [''],
      adress: ['']
    });

  }

  submit() {
    this.adminRegisterAgentService.postAgents(this.AgentForm.value).subscribe((data: {}) => {console.log(data); });

  }
}
