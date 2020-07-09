import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PagesComponent } from './pages.component';
import {ThemeModule} from '../@theme/theme.module';
import {
    NbButtonModule,
    NbCardModule,
    NbCheckboxModule,
    NbDatepickerModule,
    NbInputModule,
    NbMenuModule,
    NbSelectModule
} from '@nebular/theme';
import {RouterModule} from '@angular/router';
import {PagesRoutingModule} from './pages-routing.module';
import { MyAdsComponent } from './my-ads/my-ads.component';
import {Ng2SmartTableModule} from 'ng2-smart-table';
import { NewAdComponent } from './new-ad/new-ad.component';
import { NewVehicleComponent } from './new-vehicle/new-vehicle.component';
import {DropdownListModule} from 'ngx-dropdown-list';
import {ReactiveFormsModule} from '@angular/forms';
import { ReservationsComponent } from './reservations/reservations.component';
import { NewReservationComponent } from './new-reservation/new-reservation.component';
import { ProfileComponent } from './profile/profile.component';
import { StatsComponent } from './stats/stats.component';
import { ChatComponent } from './chat/chat.component';
import { VehiclesComponent } from './vehicles/vehicles.component';
import { ReserveFormComponent } from './my-ads/reserve-form/reserve-form.component';



@NgModule({
  declarations: [PagesComponent, MyAdsComponent, NewAdComponent, NewVehicleComponent, ReservationsComponent, NewReservationComponent, ProfileComponent, StatsComponent, ChatComponent, VehiclesComponent, ReserveFormComponent],
    imports: [
        CommonModule,
        ThemeModule,
        NbMenuModule,
        RouterModule,
        PagesRoutingModule,
        NbCardModule,
        Ng2SmartTableModule,
        NbSelectModule,
        NbInputModule,
        NbButtonModule,
        NbDatepickerModule,
        NbCheckboxModule,
        DropdownListModule,
        ReactiveFormsModule
    ]
})
export class PagesModule { }
