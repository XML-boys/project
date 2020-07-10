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

  public imagePath;
  imgURLS: any[] = [];
  public message: string;
  selectedFiles: Blob[] = [];

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


  preview(files) {
    if (files.length === 0) {
      return;
    }

    this.selectedFiles.push(files[0]);
    // this.selectedFile = files[0];

    const mimeType = files[0].type;
    if (mimeType.match(/image\/*/) == null) {
      this.message = 'Only images are supported.';
      return;
    }

    const reader = new FileReader();
    this.imagePath = files;
    reader.readAsDataURL(files[0]);
    reader.onload = (event) => {
      this.imgURLS.push(reader.result);
    };
  }

  removeImage(image: any) {
    const index: number = this.imgURLS.indexOf(image);
    if (index !== -1) {
      this.imgURLS.splice(index, 1);
      this.selectedFiles.splice(index, 1);
    }
  }
}
