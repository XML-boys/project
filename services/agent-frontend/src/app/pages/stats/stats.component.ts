import { Component, OnInit } from '@angular/core';
import {LocalDataSource} from 'ng2-smart-table';
import {MyAdsService} from '../../@core/services/my-ads.service';

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

  constructor() {

  }

  loadAds(data){
    for (const item of data) {
      const tmp = {
        id: item.id,
        vehicleId: item.vehicleId,
        startTime: item.startTime,
        endDate: item.endDate,
        location: item.location,
        cena: item.cena,
      };
      this.source.add(tmp);

    }
    console.log(this.source);
  }


  ngOnInit(): void {
  }

}
