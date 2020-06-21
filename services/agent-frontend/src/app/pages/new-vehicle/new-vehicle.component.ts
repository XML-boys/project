import { Component, OnInit } from '@angular/core';
import {VehicleService} from '../../@core/services/vehicle.service';

@Component({
  selector: 'app-new-vehicle',
  templateUrl: './new-vehicle.component.html',
  styleUrls: ['./new-vehicle.component.scss']
})
export class NewVehicleComponent implements OnInit {

  dropDisabled;
  selected;
  disabledModel = true;
  disabledOil = true;
  disabledGeatr = true;
  vendors: any = [];
  models: any = [];

  constructor(private vehicleService: VehicleService) { }

  ngOnInit(): void {
    this.vehicleService.getAllVendors().subscribe((data: {}) => {
      this.vendors = data;
    });
  }

  onChange() {
    console.log('changed');
  }
}
