import { Component, OnInit } from '@angular/core';
import {LocalDataSource} from 'ng2-smart-table';
import {MyAdsService} from '../../@core/services/my-ads.service';
import {ReservationsService} from '../../@core/services/reservations.service';
import {LoginService} from '../../@core/services/login.service';

@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.css']
})
export class ReservationsComponent implements OnInit {

  settings = {
    actions: {
      add: false,
      edit: false,
      delete: true,
      custom: [{ name: 'accept', title: '<i class="nb-checkmark" aria-hidden="true"></i>' }]
    },
    delete: {
      deleteButtonContent: '<i class="nb-trash"></i>',
      confirmDelete: true,
    },
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
      endTime: {
        title: 'End date',
        type: 'string',
      },
    },
  };

  source: LocalDataSource = new LocalDataSource();


  constructor(private service: ReservationsService, private auth: LoginService) {

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
    let myInfo;
    this.auth.myInfo().subscribe((data: {}) => {
      myInfo = data;
      this.getMyReservations(myInfo.id);
    });

  }

  getMyReservations(id) {
    this.service.getAllReservations(id).subscribe((data: {}) => {
        this.loadAds(data);
        console.log(data);
        this.source.refresh();
      }
    );
  }
}
