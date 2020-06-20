import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-new-vehicle',
  templateUrl: './new-vehicle.component.html',
  styleUrls: ['./new-vehicle.component.scss']
})
export class NewVehicleComponent implements OnInit {

  dropDisabled;
  selected;
  disabledModel = true;
  vendors: any[];

  constructor() { }

  ngOnInit(): void {
  }

}
