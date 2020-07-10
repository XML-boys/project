import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {AgentCreateAdService} from '../services/agent-create-ad.service';

@Component({
  selector: 'app-profil-agent-app',
  templateUrl: './profil-agent-app.component.html',
  styleUrls: ['./profil-agent-app.component.css']
})
export class ProfilAgentAppComponent implements OnInit {

  profileForm: FormGroup;
  isSubmitted  =  false;
  loadedData: any = {};
  constructor(private agentCreateAdService: AgentCreateAdService , private router: Router, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.profileForm  =  this.formBuilder.group({
      email: ['', Validators.required],
      company: ['', Validators.required],
      name: ['', Validators.required],
      adress: ['', Validators.required]
    });

    this.loadData();
  }

  loadData(){
    this.agentCreateAdService.getAgentData().subscribe(data => {
        this.loadedData = data;
        this.profileForm.value.email = data.email;
        this.profileForm.value.company = data.companyIdentifier;
        this.profileForm.value.name = data.name;
        this.profileForm.value.adress = data.adress;

      }
    );
  }

  update(){
    console.log('okinuto');
    this.isSubmitted = true;
    if (this.profileForm.invalid){
      this.isSubmitted = false;
      console.log(this.profileForm.controls);
      return;
    }
    const agent = {
      email: this.profileForm.value.email,
      companyIdentifier: this.profileForm.value.company,
      name: this.profileForm.value.name,
      adress: this.profileForm.value.adress,
    };

    return this.agentCreateAdService.updateAgent(JSON.stringify(agent), this.loadedData.id).subscribe();

  }
}
