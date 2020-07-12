import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ClientService} from '../services/client.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-client-profil',
  templateUrl: './client-profil.component.html',
  styleUrls: ['./client-profil.component.css']
})
export class ClientProfilComponent implements OnInit {
  profileForm: FormGroup;
  isSubmitted  =  false;
  loadedData: any = {};
  idClienta;
  constructor(private clientService: ClientService , private router: Router, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.profileForm  =  this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      adress: ['', Validators.required],
      email: ['', Validators.required]
    });

    this.loadData();
    // this.idClienta = this.loadedData.value.userId;
    // this.clientService.evoId(this.idClienta);

  }

  // tslint:disable-next-line:typedef
  loadData(){
    this.clientService.getClient().subscribe(data => {
        this.loadedData = data;
        this.profileForm.value.firstName = data.firstName;
        this.profileForm.value.lastName = data.lastName;
        this.profileForm.value.adress = data.adress;
        this.profileForm.value.email = data.email;
        this.idClienta = data.userId;
        this.clientService.evoId(data.userId);
      }
    );
  }

  // tslint:disable-next-line:typedef
  update(){
    console.log('okinuto');
    this.isSubmitted = true;
    if (this.profileForm.invalid){
      this.isSubmitted = false;
      console.log(this.profileForm.controls);
      return;
    }
    const client = {
      firstName: this.profileForm.value.firstName,
      lastName: this.profileForm.value.lastName,
      adress: this.profileForm.value.adress,
      email: this.profileForm.value.email
    };

    return this.clientService.updateClient(JSON.stringify(client), this.loadedData.id).subscribe();

  }

}
