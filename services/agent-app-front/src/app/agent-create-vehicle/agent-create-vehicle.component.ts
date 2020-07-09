import { Component, OnInit } from '@angular/core';
import {AgentCreateAdService} from '../services/agent-create-ad.service';
import {Router} from '@angular/router';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {FormBuilder} from '@angular/forms';

@Component({
  selector: 'app-agent-create-vehicle',
  templateUrl: './agent-create-vehicle.component.html',
  styleUrls: ['./agent-create-vehicle.component.css']
})
export class AgentCreateVehicleComponent implements OnInit {

  VehicleForm = this.formBuilder.group({
    vendor: [''],
    model: [''],
    oilType: [''],
    gearType: [''],
    vehicleClass: [''],
    distanceKM: [''],
    kidSeats: ['']
  });

  classes = ['SUV', 'Cabrio', 'Limousine', 'Hatchback'];
  codeItems: any = [];
  codeItemId;
  vendors: any = [];
  selectedVendor;
  models: any = [];
  selectedModel;
  oils: any = [];
  gears: any = [];
  selectedOil;
  selectedGear;

  constructor(private agentCreateAdService: AgentCreateAdService, private router: Router, private modalService: NgbModal,
              private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.codeItems = [];
    this.vendors = [];
    this.getAllVendors();
    this.getAllItems();
  }

  getAllItems() {
    this.agentCreateAdService.getAllItems()
      .subscribe((data: {}) => {
          this.codeItems = data;
        }
      );
  }

  getAllVendors() {
    this.agentCreateAdService.getAllVendors()
      .subscribe((data: {}) => {
          this.vendors = data;
        }
      );
  }


  open() {
    this.agentCreateAdService.createVehicle(this.VehicleForm.value).subscribe();
  }

  onChangeVendor(event) {
    this.selectedVendor = event.value;
    this.agentCreateAdService.getModelsByVendor(event.value).subscribe((data: {}) => {
        this.models = data;
      });
    }

  onChangeModel(event) {
    this.selectedModel = event.value;
    for (const model of this.models) {
      if ( model.name === event.value) {
        this.oils = model.oil;
        this.gears = model.gear;
      }
    }
  }

  onChangeOil(event) {
    this.selectedOil = event.value;
  }

  onChangeGear(event) {
    this.selectedGear = event.value;
  }
}
