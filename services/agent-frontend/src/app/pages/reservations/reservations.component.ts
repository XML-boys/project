import { Component, OnInit } from '@angular/core';
import {LocalDataSource} from 'ng2-smart-table';
import {MyAdsService} from '../../@core/services/my-ads.service';
import {ReservationsService} from '../../@core/services/reservations.service';

@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.css']
})
export class ReservationsComponent implements OnInit {

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
    custom: [
      { name: 'accept', title: '<i class="fa fa-eye"></i>'}],
    update: true,
    columns: {
      id: {
        title: 'Reservation ID',
        type: 'number',
      },
      adId: {
        title: 'Ad ID',
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
      accept: {
        title: 'Location',
        type: 'string',
      }
    },
  };

  source: LocalDataSource = new LocalDataSource();


  constructor(private service: ReservationsService) {

  }

  loadAds(data){
    for (const item of data) {
      const tmp = {
        id: item.id,
        adId: item.reklama.id,
        startTime: item.startTime,
        endDate: item.endDate,
        location: item.reklama.location,
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
    this.service.getAllReservations().subscribe((data: {}) => {
        this.loadAds(data);
        console.log(data);
        this.source.refresh();
      }
    );
  }

}
