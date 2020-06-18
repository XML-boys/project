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
    add: {
      addButtonContent: '<i class="nb-plus"></i>',
      createButtonContent: '<i class="nb-checkmark"></i>',
      cancelButtonContent: '<i class="nb-close"></i>',
    },
    edit: {
      editButtonContent: '<i class="nb-edit"></i>',
      saveButtonContent: '<i class="nb-checkmark"></i>',
      cancelButtonContent: '<i class="nb-close"></i>',
    },
    delete: {
      deleteButtonContent: '<i class="nb-trash"></i>',
      confirmDelete: true,
    },
    update: true,
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
      endTime: {
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
        endTime: item.endTime,
        location: item.location,
        cena: item.cena,
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

}
