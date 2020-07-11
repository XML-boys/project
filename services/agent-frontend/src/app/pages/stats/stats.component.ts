import { Component, OnInit } from '@angular/core';
import {LocalDataSource} from 'ng2-smart-table';
import {MyAdsService} from '../../@core/services/my-ads.service';
import {VehicleService} from '../../@core/services/vehicle.service';

@Component({
  selector: 'app-stats',
  templateUrl: './stats.component.html',
  styleUrls: ['./stats.component.css']
})
export class StatsComponent implements OnInit {

  settings = {
    actions: {
      add: false,
      edit: false,
      delete: false,
    },
    columns: {
      id: {
        title: 'Vehicle id',
        type: 'number',
      },
      name: {
        title: 'Vehicle',
        type: 'number',
      },
      distance: {
        title: 'Distance',
        type: 'string',
      },
      grade: {
        title: 'Grade',
        type: 'string',
      },
      location: {
        title: 'Location',
        type: 'string',
      },
      coments: {
        title: 'Comments',
        type: 'string',
      },
    },
  };

  source: LocalDataSource = new LocalDataSource();

  vehicles: any = [];
  ads: any = [];
  stats = [];

  constructor(private vehicleService: VehicleService, private adService: MyAdsService) {

  }
/*
  fill(){
    for (const veh of this.vehicles) {

  }

  loadAds(){
    for (const veh of this.vehicles) {
      const tmp = {
        id: veh.id,
        name: veh.vendor,
        distance: veh.distanceKM,
        grade: veh.votes,
        cena: item.cena,
      };
      this.source.add(tmp);

    }
    console.log(this.source);
  }

*/


  loadAds(data) {
    for (const item of data) {
      let vehicle = null;
      this.vehicleService.getVehicle(item.vehicleId).subscribe(data2 => {
          vehicle = data2;
          console.log(vehicle);
          let ukupnaOcena = 0;
          let i = 0;
          for (const vote of item.votes) {
            if (vote.approved === true){
              i++;
              ukupnaOcena += vote.vrednost;
            }
          }
          const ocena = ukupnaOcena / item.votes.length;

          const tmp = {
            id: item.id,
            vehicleId: item.vehicleId,
            vehicle: vehicle.vendor + ' ' + vehicle. model,
            oil: vehicle.oilType,
            gear: vehicle.gearType,
            startTime: item.startTime,
            endDate: item.endDate,
            location: item.location,
            cena: item.cena,
            comments: item.comments,
            vote: ocena
          };
          this.source.add(tmp);
          this.source.refresh();


        }
      );
    }
    console.log(this.source);
    console.log('2');
  }
  ngOnInit(): void {
    this.vehicleService.getAllVehicle().subscribe( (data: {}) => {
      this.vehicles = data;
      this.getAllAds();
    });
  }

  getAllAds() {
    this.adService.getAll().subscribe( (data: {}) => {
      this.ads = data;
    });
  }


}
