import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {VehicleService} from '../../@core/services/vehicle.service';
import {MyAdsService} from '../../@core/services/my-ads.service';

@Component({
  selector: 'app-new-ad',
  templateUrl: './new-ad.component.html',
  styleUrls: ['./new-ad.component.scss']
})
export class NewAdComponent implements OnInit {

  AdForm: FormGroup;
  vehicles: any = [];

  constructor(private formBuilder: FormBuilder, private vehicleService: VehicleService, private adService: MyAdsService) {
  }

  ngOnInit(): void {
    this.AdForm = this.formBuilder.group({
      vehicleId: [''],
      startTime: [''],
      endDate: [''],
      location: [''],
      cena: [''],
      damage: ['']
    });

    this.vehicleService.getAllVehicle().subscribe((data: {}) => {
      this.vehicles = data;
    });
  }

  submit() {
    this.adService.createAd(this.AdForm.value).subscribe(); }
}
