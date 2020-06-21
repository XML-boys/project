import {Component, Inject, OnInit} from '@angular/core';
import {VehicleService} from '../../@core/services/vehicle.service';
import {DOCUMENT} from '@angular/common';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-new-vehicle',
  templateUrl: './new-vehicle.component.html',
  styleUrls: ['./new-vehicle.component.scss']
})
export class NewVehicleComponent implements OnInit {

  VehicleForm: FormGroup;
  isSubmitted  =  false;
  disabledModel = true;
  disabledOil = true;
  disabledGear = true;
  vendors: any = [];
  models: any = [];
  oil: any = [];
  gear: any = [];

  selectedVendor;
  selectedModel;
  selectedOil;
  selectedGear;


  constructor(private vehicleService: VehicleService, private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {

  this.VehicleForm  =  this.formBuilder.group({
    vendor: [''],
    model: [''],
    oType: [''],
    gearType: [''],
    distance: [''],
    seats: ['']
  });


  this.disabledOil = true;
  this.disabledGear = true;
  this.models = [];
  this.vehicleService.getAllVendors().subscribe((data: {}) => {
    this.vendors = data;
  });
  }

  get formControls() { return this.VehicleForm.controls; }


  onChangeVendor(event) {
    this.selectedVendor = event;
    this.vehicleService.getModelsByVendor(event).subscribe((data: {}) => {
      this.models = data;
      this.disabledModel = false;
    });
  }

  onChangeModel(event) {
    this.selectedModel = event;
    for (const model of this.models) {
      if ( model.name === event) {
        this.oil = model.oil;
        this.gear = model.gear;
        this.disabledOil = false;
        this.disabledGear = false;
      }
    }
  }

  onChangeOil(event) {
    this.selectedOil = event;
  }

  onChangeGear(event) {
    this.selectedGear = event;
  }

  submit() {
  this.vehicleService.addVehicle(this.VehicleForm.value).subscribe((data: {}) => {console.log(data); });

  }
}
