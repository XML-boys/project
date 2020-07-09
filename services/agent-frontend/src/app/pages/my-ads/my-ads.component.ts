import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {SmartTableData} from '../../@core/data/smart-table';
import {LocalDataSource} from 'ng2-smart-table';
import {MyAdsService} from '../../@core/services/my-ads.service';
import {NbDateService, NbWindowService} from '@nebular/theme';
import {ReserveFormComponent} from './reserve-form/reserve-form.component';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ReservationsService} from '../../@core/services/reservations.service';

@Component({
  selector: 'app-my-ads',
  templateUrl: './my-ads.component.html',
  styleUrls: ['./my-ads.component.scss']
})


export class MyAdsComponent implements OnInit {
  @ViewChild('disabledEsc', { read: TemplateRef, static: true }) disabledEscTemplate: TemplateRef<HTMLElement>;
  id;
  min: Date;
  max: Date;
  settings = {
      hideSubHeader: true,
      actions: {
        custom: [
          {
            name: 'reserve',
            title: '<i class="ion-document" title="Manual reservation"></i>'
          },
          {
            name: 'delete',
            title: '<i class="far fa-trash-alt" title="delete"></i>'
          }
        ],
        add: false,
        edit: false,
        delete: false
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
    },
  };
  ReerveForm: FormGroup;
  source: LocalDataSource = new LocalDataSource();

  constructor(private service: MyAdsService, private windowService: NbWindowService, protected dateService: NbDateService<Date>,
              private formBuilder: FormBuilder, private reservationService: ReservationsService) {

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

    this.ReerveForm = this.formBuilder.group({
      startTime: [''],
      endTime: [''],
    });
  }

  onReserve(event) {
    console.log(event);
    if (event.action === 'reserve'){
      console.log('reserve');
      this.id = event.data.id;
      this.min = this.dateService.parse(event.data.startTime, 'DD.MM.YYYY');
      this.max = this.dateService.parse(event.data.endDate, 'DD.MM.YYYY');
      this.openWindowWithoutBackdrop();
    }
    else if (event.action === 'delete'){
      console.log('delete');
    }
  }


  openWindowWithoutBackdrop() {
    this.windowService.open(
      this.disabledEscTemplate,
      {
        title: 'Manual reservation',
        hasBackdrop: false,
        closeOnEsc: true,
      },
    );
  }

  submit() {
    this.reservationService.reserve(this.id, this.ReerveForm.value).subscribe();
  }

  onEditConfirm(event): void {
    if (window.confirm('Are you sure you want to edit?')) {
      event.confirm.resolve();
    } else {
      event.confirm.reject();
    }
  }


}
