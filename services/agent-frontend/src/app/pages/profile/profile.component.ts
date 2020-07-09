import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {ProfileService} from '../../@core/services/profile.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
  profileForm: FormGroup;
  isSubmitted  =  false;
  loadedData: any = {};
  constructor(private service: ProfileService, private router: Router, private formBuilder: FormBuilder ) { }

  ngOnInit(): void {
    this.profileForm  =  this.formBuilder.group({
      email: ['', Validators.required],
      company: ['', Validators.required],
      name: ['', Validators.required],
      address: ['', Validators.required]
    });

    this.loadData();
  }

  loadData(){
    this.service.getAgentData().subscribe(data => {
      this.loadedData = data;
      this.profileForm.value.email = data.email;
      this.profileForm.value.company = data.companyIdentifier;
      this.profileForm.value.name = data.name;
      this.profileForm.value.address = data.address;

      }
    );
  }

  update(){
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
      address: this.profileForm.value.address,
    };
    this.service.update(agent, this.loadedData.id).subscribe();

  }
}
