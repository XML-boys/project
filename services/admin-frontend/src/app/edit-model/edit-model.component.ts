import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {FormBuilder, FormControl} from '@angular/forms';
import {AdminSifrarnikService} from '../services/admin-sifrarnik.service';
import {Router} from '@angular/router';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-edit-model',
  templateUrl: './edit-model.component.html',
  styleUrls: ['./edit-model.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class EditModelComponent implements OnInit {

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

  constructor(private adminSifrarnikService: AdminSifrarnikService, private router: Router, private modalService: NgbModal,
              private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.model = this.adminSifrarnikService.uzmiModel();
  }

  open6() {
    this.model.name = this.EditForm2.value.addModelName;
    this.model.gear = this.EditForm2.value.gear;
    this.model.oil = this.EditForm2.value.oil;
    this.adminSifrarnikService.putModel( this.adminSifrarnikService.uzmiId() , this.model.id, this.model ).subscribe();
    this.router.navigate(['/admin/adminSifrarnik']);

  }

}
