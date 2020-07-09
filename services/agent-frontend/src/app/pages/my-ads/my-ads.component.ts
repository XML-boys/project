import { Component, OnInit } from '@angular/core';
import {SmartTableData} from '../../@core/data/smart-table';
import {LocalDataSource} from 'ng2-smart-table';
import {MyAdsService} from '../../@core/services/my-ads.service';

@Component({
  selector: 'app-my-ads',
  templateUrl: './my-ads.component.html',
  styleUrls: ['./my-ads.component.scss']
})
export class MyAdsComponent implements OnInit {
  settings = {
    actions: {
      add: false,
      edit: false,
      delete: false,
      custom: [    {
        name: 'edit',
        title: '<i class="nb-trash"></i>'
      },
      ],
      position: 'right'
    },
    accept: {
      custom: [          {
        name: 'save',
        title: '<i class="nb-checkmark"></i>' }
      ],
    },
    columns: {
      id: {
        title: 'Ad ID',
        type: 'number',
      },
      vehicleId: {
        title: 'Vehicle ID',
        type: 'number',
      },
      startTime: {
        title: 'Start date',
        type: 'string',
      },
      endDate: {
        title: 'End date',
        type: 'string',
      },
      location: {
        title: 'Location',
        type: 'string',
      },
      cena: {
        title: 'Price',
        type: 'string',
      },
      proba: {
        title: 'proba',
        type: 'html',
      },
    },
  };

  source: LocalDataSource = new LocalDataSource();

  constructor(private service: MyAdsService) {

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
        proba: '<button click= "prb(' + item.id + ') >save </button>'
      };
      this.source.add(tmp);

    }
    console.log(this.source);
  }

  onDeleteConfirm(event): void {
    if (window.confirm('Are you sure you want to delete?')) {
      event.confirm.resolve();
    } else {
      event.confirm.reject();
    }
  }

  ngOnInit(): void {
    this.service.getAll().subscribe((data: {}) => {
        this.loadAds(data);
        console.log(data);
        this.source.refresh();
      }
    );
  }

  onReserve(event) {
    console.log(event.data.id);
  }

  prb(event) {
    console.log(event);
  }

}
