import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {AdminSifrarnikService} from '../services/admin-sifrarnik.service';
import {Router} from '@angular/router';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {MatOption, MatSelectChange} from '@angular/material';
import {AdminSifrarnikComponent} from '../admin-sifrarnik/admin-sifrarnik.component';

@Component({
  selector: 'app-add-model',
  templateUrl: './add-model.component.html',
  styleUrls: ['./add-model.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class AddModelComponent implements OnInit {

  oil = new FormControl();
  oils: string[] = ['diesel' , 'gas', 'TNG', 'electric' , 'hybrid'];

  gear = new FormControl();
  gears: string[] =  ['automatic', 'manual'];
  toppings = new FormControl();
  toppingList: string[] = ['Extra cheese', 'Mushroom', 'Onion', 'Pepperoni', 'Sausage', 'Tomato'];

  EditForm2 = this.formBuilder.group({
    addModelName: [''],
    oil: [''],
    gear: ['']
  });

  model: any = [];

  private newModelName: string;
  private newModelOil: any = [];
  private newModelGear: any = [];
  ModelForm: FormGroup;

  constructor(private adminSifrarnikService: AdminSifrarnikService, private router: Router, private modalService: NgbModal,
              private formBuilder: FormBuilder) { }

  ngOnInit(): void {
  }

  open6() {
    this.newModelName = this.EditForm2.value.addModelName;
    this.newModelOil = this.EditForm2.value.oil;
    this.newModelGear = this.EditForm2.value.gear;
    this.model.name = this.newModelName;
    this.model.gear = this.newModelGear;
    this.model.oil = this.newModelOil;


    const modelcic = { name: this.model.name , gear: this.model.gear , oil: this.model.oil};

    this.adminSifrarnikService.postModel(modelcic  , this.adminSifrarnikService.uzmiId()).subscribe();
    this.router.navigate(['/admin/adminSifrarnik']);

  }


}
