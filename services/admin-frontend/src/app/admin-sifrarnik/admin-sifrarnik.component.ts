import { Component, OnInit } from '@angular/core';
import {AdminUpravaService} from '../services/admin-uprava.service';
import {Router} from '@angular/router';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {FormBuilder} from '@angular/forms';
import {AdminSifrarnikService} from '../services/admin-sifrarnik.service';

@Component({
  selector: 'app-admin-sifrarnik',
  templateUrl: './admin-sifrarnik.component.html',
  styleUrls: ['./admin-sifrarnik.component.css']
})
export class AdminSifrarnikComponent implements OnInit {

  codeItems: any = [];
  codeItem: any = [];
  dropDisabled: boolean;
  selected = '';
  selected1 = '';
  selected2 = '';
  selected4 = '';
  selected5 = '';
  selected6 = '';
  selected7 = '';
  selected8 = '';
  selected9 = '';
  selected10 = '';
  selected11 = '';
  selected12 = '';
  selected13 = '';
  selected14 = '';
  closeResult: string;
  vendors: string[][] = [];
  vendors1: any = [];
  loading = false;

  model: any;

  models: any = [];
  gears: any = [];
  oils: any = [];

  modelNames: any = [];
  oil: any;
  gear: any;
  vendorName: any;
  vendor: any;
  addModelName: any;
  ci: any;
  ci1: any;
  gearAdd: any;
  oilAdd: any;
  optionItems: any[];
  item: any = [];

  constructor(private adminSifrarnikService: AdminSifrarnikService , private router: Router, private modalService: NgbModal,
              private formBuilder: FormBuilder) {
  }

  getAllItems(){
    this.adminSifrarnikService.getAllItems()
      .subscribe((data: {}) => {
          this.codeItems = data;
          console.log(data);
          this.inicijalizacija();
        }
      );
  }

  inicijalizacija(){
    console.log('usao');
    for (this.codeItem of this.codeItems){
      this.vendors.push(this.codeItem.vendor);
      console.log(this.codeItem.vendor);
      console.log(this.vendors);
      this.vendors1.push(this.codeItem.vendor);
      console.log(this.vendors1);
      if (this.codeItem.vendor === this.selected){
        this.models = this.codeItem.models;
        for ( this.model of this.models ) {
          this.modelNames.add(this.model.name);
          this.oils = this.model.oil;
          this.gears = this.model.gear;
        }
      }
    }
  }

  ngOnInit(): void {
    this.getAllItems();
  }

  open(selected) {
    let codeItem;
    for (codeItem of this.codeItems){
      if (codeItem.vendor === selected){
        this.adminSifrarnikService.deleteVendor(codeItem.id);
      }

    }
  }

  open3(selected1) {
    let codeItem;
    let model;
    for (codeItem of this.codeItems){
      if (codeItem.vendor === this.selected){
        for ( model of this.models) {
          if (model.name === selected1) {
            this.model.name = '';
            this.model.gear = [];
            this.gears = [];
            this.model.oil = [];
            this.oils = [];
            this.adminSifrarnikService.deleteModel(codeItem.id, this.model.id);
          }
        }
      }
    }
  }

  open1(selected: string, profil1) {
    let codeItem;
    for (codeItem of this.codeItems){
      if (codeItem.vendor === selected){
        this.models = codeItem.models;
        for (this.model of this.models){
          if (this.model.name === this.selected2){
            this.gears = this.model.gear;
            this.oils = this.model.oil;
          }
        }
      }
    }
    this.modalService.open(profil1, {size: 'xl'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed`;
    });
  }

  open2(editGear) {
    this.modalService.open(editGear, {size: 'xl'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed`;
    });
  }




  open4(editOil) {
    this.modalService.open(editOil, {size: 'xl'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed`;
    });

  }

  open22() {
    let forGear;
    for ( forGear of this.gears){
      if ( forGear === this.selected5 )
      {
        forGear = this.gear;
      }
    }
  }

  open11() {
    let foroil;
    for ( foroil of this.oils){
      if ( foroil === this.selected4 )
      {
        foroil = this.oil;
      }
    }
  }

  open33() {
    this.model.gear = this.gears;
    this.model.oil = this.oils;
    this.adminSifrarnikService.putModel(this.model, this.model.id);
  }

  addVendor(addVendorModal) {
    this.modalService.open(addVendorModal, {size: 'xl'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed`;
    });
  }

  open44(vendorName, selected1, selected6, selected7) {
    this.ci1.name = vendorName;
    if (selected1 !== '') {
    this.ci1.models.add(selected1);
    }
    if (selected6 !== '') {
      this.ci1.models.add(selected6);
    }
    if (selected7 !== '') {
      this.ci1.models.add(selected7);
    }
    this.codeItems.add(this.ci1);
    this.adminSifrarnikService.postCodeItem(this.codeItems);
  }

  open333(addModelModule) {
    this.modalService.open(addModelModule, {size: 'xl'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed`;
    });
  }

  open334(addModelName, selected8, selected12, selected13, selected9, selected10, selected11, selected14) {
    this.model.name = addModelName;
    if (selected8 !== ''){
      this.model.oil.add(selected8);
    }
    if (selected12 !== ''){
      this.model.oil.add(selected12);
    }
    if (selected13 !== ''){
      this.model.oil.add(selected13);
    }
    if (selected9 !== ''){
      this.model.gear.add(selected9);
    }
    if (selected10 !== ''){
      this.model.gear.add(selected10);
    }
    if (selected11 !== ''){
      this.model.gear.add(selected11);
    }

    for (this.ci of this.codeItems)
    {
      if (this.ci.vendor === selected14)
      {
        this.ci.models.add(this.model);
      }
    }
    this.adminSifrarnikService.postModel(this.model);
    this.adminSifrarnikService.putCodeItem(this.ci, this.ci.id);
  }

  open335(selected4, selected2) {
    for ( this.oil of this.oils) {
      if (this.oil === selected4)
      {
        this.oils.delete(this.oil);
      }
    }
    for ( this.model of this.models) {
      if (this.model.name === selected2){
        this.adminSifrarnikService.putModel(this.model, this.model.id);
      }
    }
  }

  open336(selected5, selected2) {
    for ( this.gear of this.gears) {
      if (this.gear === selected5)
      {
        this.gears.delete(this.gear);
      }
    }
    for ( this.model of this.models) {
      if (this.model.name === selected2){
        this.adminSifrarnikService.putModel(this.model, this.model.id);
      }
    }
  }

  open444(gearAdd) {
    this.model.gear.add(gearAdd);
    this.adminSifrarnikService.putModel(this.model, this.model.id);
  }

  open338(addGear) {
    this.modalService.open(addGear, {size: 'xl'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed`;
    });
  }

  open337(addOil) {
    this.modalService.open(addOil, {size: 'xl'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed`;
    });
  }

  open445(oilAdd: any) {
    this.model.oil.add(oilAdd);
    this.adminSifrarnikService.putModel(this.model, this.model.id);
  }

  open666(modal, tpkDTOs) {
    this.fills(tpkDTOs);
    this.modalService.open(modal, {size: 'xl'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed`;
    });

  }

  fills(tpk) {
    this.optionItems = [];
    for (const item of tpk) {
      // tslint:disable-next-line:max-line-length
      this.optionItems.push({id: item.id + ',' + item.name + ',' + item.gear + item.oil, value: item.id + ',' + item.name + ',' + item.gear + item.oil, text: item.id + ',' + item.name + ',' + item.gear + item.oil});
      console.log(item);
      this.item = item.id + ',' + item.name + ',' + item.gear + item.oil;
    }
  }
}


