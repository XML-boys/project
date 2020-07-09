import {PagesComponent} from './pages.component';
import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {MyAdsComponent} from './my-ads/my-ads.component';
import {NewAdComponent} from './new-ad/new-ad.component';
import {NewVehicleComponent} from './new-vehicle/new-vehicle.component';
import {ReservationsComponent} from './reservations/reservations.component';
import {NewReservationComponent} from './new-reservation/new-reservation.component';
import {ProfileComponent} from './profile/profile.component';
import {StatsComponent} from './stats/stats.component';
import {ChatComponent} from './chat/chat.component';

const routes: Routes = [{
  path: '',
  component: PagesComponent,
  children: [
    {
      path: '',
      component: StatsComponent,
    },
    {
      path: 'my-ads',
      component: MyAdsComponent,
    },
    {
      path: 'new-ad',
      component: NewAdComponent,
    },
    {
      path: 'new-vehicle',
      component: NewVehicleComponent,
    },
    {
      path: 'reservations',
      component: ReservationsComponent,
    },
    {
      path: 'reserve',
      component: NewReservationComponent,
    },
    {
      path: 'profile',
      component: ProfileComponent,
    },
    {
      path: 'messages',
      component: ChatComponent,
    },
  ]
},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PagesRoutingModule {
}
