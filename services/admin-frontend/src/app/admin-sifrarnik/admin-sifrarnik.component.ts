import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {AdminUpravaService} from '../services/admin-uprava.service';
import {Router} from '@angular/router';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {AdminSifrarnikService} from '../services/admin-sifrarnik.service';
import {MatSelectModule} from '@angular/material/select';


@Component({
    selector: 'app-admin-sifrarnik',
    templateUrl: './admin-sifrarnik.component.html',
    styleUrls: ['./admin-sifrarnik.component.css']
})
export class AdminSifrarnikComponent implements OnInit {
    codeItems: any = [];
    vendors: any = [];
  oil = new FormControl();
  oils: string[] = ['diesel' , 'gas', 'TNG', 'electric' , 'hybrid'];

  gear = new FormControl();
  gears: string[] =  ['automatic', 'manual'];
  toppings = new FormControl();
  toppingList: string[] = ['Extra cheese', 'Mushroom', 'Onion', 'Pepperoni', 'Sausage', 'Tomato'];
  models: any = [];
  disabledVendors = true;
  selectedVendor;
  selectedModel;
  closeResult: string;

  codeItemId;
  AdminForm = this.formBuilder.group({
    vendorName: ['']
  });

  EditForm = this.formBuilder.group({
    editVendor: ['']
  });

  EditForm1 = this.formBuilder.group({
    editModel: ['']
  });

  EditForm2 = this.formBuilder.group({
    addModelName: ['']
  });


  form = new FormGroup({
    vendor: new FormControl()

  });

  modelForm = new FormGroup({
    model: new FormControl()

  });
  private newModelName;
  private newModelOil;
  private newModelGear;
  isMultiple: true;


    constructor(private adminSifrarnikService: AdminSifrarnikService, private router: Router, private modalService: NgbModal,
                private formBuilder: FormBuilder) {
    }

    getAllItems() {
        this.adminSifrarnikService.getAllItems()
            .subscribe((data: {}) => {
                    this.codeItems = data;
                }
            );
    }

    getAllVendors(){
        this.adminSifrarnikService.getAllVendors()
            .subscribe((data: {}) => {
                    this.vendors = data;
                }
            );
    }

    ngOnInit(): void {
      this.codeItems = [];
      this.vendors = [];
      this.getAllVendors();
      this.getAllItems();
    }



  get f(){

    return this.form.controls;

  }

  get fM(){

    return this.EditForm2.controls;

  }


  submit(){
    this.selectedVendor = this.form.value.vendor;
    let codeItem;
    for (codeItem of this.codeItems){
      if (codeItem.vendor === this.selectedVendor){
        this.adminSifrarnikService.evoId(codeItem.id);
        this.codeItemId = codeItem.id;
      }
    }

  }

  deleteV() {
      let codeItem;
      for (codeItem of this.codeItems){
        if (codeItem.vendor === this.selectedVendor){
          this.adminSifrarnikService.deleteVendor(codeItem.id).subscribe();
          this.codeItems.pop(codeItem);
          this.vendors.pop(codeItem.vendor);
          this.codeItems = [];
          this.vendors = [];
          this.getAllVendors();
          this.getAllItems();
        }
      }
  }

  addV(profil) {
    this.modalService.open(profil, {size: 'xl'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed`;
    });
  }

  editV(profil) {
      this.models = [];
      this.adminSifrarnikService.getModels(this.selectedVendor).subscribe((data: {}) => {
          this.models = data;
        }
      );
      let codeItem;
      for (codeItem of this.codeItems){
      if (codeItem.vendor === this.selectedVendor){
        this.codeItemId = codeItem.id;
      }
    }
      this.modalService.open(profil, {size: 'xl'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed`;
    });
  }

  open3() {
      const vendorAdd = {
      vendor : this.AdminForm.value.vendorName
      };
      this.adminSifrarnikService.postVendor(JSON.stringify(vendorAdd)).subscribe((data: {}) => {console.log(data); });
      this.codeItems = [];
      this.vendors = [];
      this.modalService.dismissAll();
      this.getAllVendors();
      this.getAllItems();
      this.router.navigate(['/admin/adminSifrarnik']);
  }

  open4() {
    let vendorz;
    for (vendorz in this.vendors)
    {
      if (vendorz === this.selectedVendor)
      {
        vendorz = this.EditForm.value.editVendor;
      }
    }
    let codeItem;
    for (codeItem of this.codeItems){
      if (codeItem.vendor === this.selectedVendor){
        this.adminSifrarnikService.putVendor(codeItem.id , this.EditForm.value.editVendor).subscribe();
        this.codeItems = [];
        this.vendors = [];
        this.modalService.dismissAll();
        this.getAllVendors();
        this.getAllItems();
      }
    }
  }

  editM(model , editMo) {
      this.selectedModel = model;
      this.modalService.dismissAll();
      this.adminSifrarnikService.evoModel(model);
      this.router.navigate(['/admin/editModel']);
  }

  deleteM(id) {
      let codeItem;
      for (codeItem of this.codeItems) {
        if (codeItem.vendor === this.selectedVendor) {
          this.adminSifrarnikService.deleteModel(codeItem.id , id).subscribe();
          this.models = [];
          this.adminSifrarnikService.getModels(this.selectedVendor).subscribe((data: {}) => {
                this.models = data;
              }
          );
         }
      }

  }
  open5() {
      let modelz;
      for (modelz in this.models)
      {
        if (modelz === this.selectedModel)
        {
          modelz = this.EditForm1.value.editModel;
        }
      }
      let codeItem;
      for (codeItem of this.codeItems){
        if (codeItem.vendor === this.selectedVendor){
          this.selectedModel.name = this.EditForm1.value.editModel;
          this.adminSifrarnikService.putModel(codeItem.id , this.selectedModel.id, this.selectedModel);
        }
      }
  }


  addM() {
    this.modalService.dismissAll();
    this.router.navigate(['/admin/addModel']);
  }

  open6() {
    this.newModelName = this.EditForm2.value.addModelName;
    this.newModelOil = this.EditForm2.value.oil;
    this.newModelGear = this.EditForm2.value.gear;
  }

  changeVendor(event) {
    this.selectedVendor = event.target.value;
    console.log(this.selectedVendor);
  }

  getSelectedVendor(){
      return this.selectedVendor;
  }

  getSelectedId(){
    return this.codeItemId;
  }
}


