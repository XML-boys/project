import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {FormBuilder} from '@angular/forms';
import {AdminRegisterAgentService} from '../services/admin-register-agent.service';
import {AgentRegister} from '../shared/agentRegister';

@Component({
  selector: 'app-admin-register-agent',
  templateUrl: './admin-register-agent.component.html',
  styleUrls: ['./admin-register-agent.component.css']
})
export class AdminRegisterAgentComponent implements OnInit {

  agents: any = [];
  agent: any = [];
  constructor(private adminRegisterAgentService: AdminRegisterAgentService , private router: Router, private modalService: NgbModal,
              private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.getAgents();
  }

  getAgents(){
    this.adminRegisterAgentService.getAgents()
      .subscribe((data: {}) => {
          this.agents = data;
          console.log(data);
        }
      );
  }

  open(username: any, password: any, email: any, name: any, companyIdentifier: any, adress: any) {
    this.agent.username = username;
    this.agent.password = password;
    this.agent.email = email;
    this.agent.name = name;
    this.agent.companyIdentifier = companyIdentifier;
    this.agent.adress = adress;
    this.adminRegisterAgentService.postAgents(this.agent).subscribe();
  }
}
