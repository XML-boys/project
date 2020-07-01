import {Component, OnInit} from '@angular/core';
import {AdminUpravaService} from '../services/admin-uprava.service';
import {Router} from '@angular/router';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {AdminSifrarnikService} from '../services/admin-sifrarnik.service';

@Component({
    selector: 'app-admin-sifrarnik',
    templateUrl: './admin-sifrarnik.component.html',
    styleUrls: ['./admin-sifrarnik.component.css']
})
export class AdminSifrarnikComponent implements OnInit {

    codeItems: any = [];
    vendors: any = [];
    models: any = [];
    disabledVendors = true;
    selectedVendor;
  selectedModel;
  closeResult: string;
  AdminForm = this.formBuilder.group({
    vendorName: ['']
  });

  EditForm = this.formBuilder.group({
    editVendor: ['']
  });

  EditForm1 = this.formBuilder.group({
    editModel: ['']
  });


  form = new FormGroup({
    vendor: new FormControl()

  });

  modelForm = new FormGroup({
    model: new FormControl()

  });


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
        this.getAllVendors();
        this.getAllItems();
    }



  get f(){

    return this.form.controls;

  }


  submit(){

    console.log(this.form.value);
    this.selectedVendor = this.form.value.vendor;

  }

  deleteV() {
      let codeItem;
      for (codeItem in this.codeItems){
        if (codeItem.vendor === this.selectedVendor){
          this.adminSifrarnikService.deleteVendor(codeItem.id);
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
      this.adminSifrarnikService.getModels(this.selectedVendor).subscribe((data: {}) => {
          this.models = data;
        }
      );
      console.log(this.models);
      console.log(this.selectedVendor);
      this.modalService.open(profil, {size: 'xl'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed`;
    });
  }

  open3() {
      this.vendors.push(this.AdminForm.value.vendorName);
      console.log(this.AdminForm.value.vendorName);
      this.adminSifrarnikService.postVendor(this.AdminForm.value.vendorName).subscribe((data: {}) => {console.log(data); });
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
    for (codeItem in this.codeItems){
      if (codeItem.vendor === this.selectedVendor){
        this.adminSifrarnikService.putVendor(codeItem.id , this.EditForm.value.editVendor);
      }
    }
  }

  editM(model , editMo) {
      this.selectedModel = model;
      this.modalService.open(editMo, {size: 'xl'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed`;
    });
  }

  deleteM(id) {
      let codeItem;
      for (codeItem in this.codeItems) {
        if (codeItem.vendor === this.selectedVendor) {
         this.adminSifrarnikService.deleteModel(codeItem.id , id);
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
      for (codeItem in this.codeItems){
        if (codeItem.vendor === this.selectedVendor){
          this.adminSifrarnikService.putModel(codeItem.id , this.EditForm.value.editVendor);
        }
      }
  }

  addM() {

  }
}


