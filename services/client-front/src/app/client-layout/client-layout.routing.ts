import {Routes} from '@angular/router';
import {ClientProfilComponent} from '../client-profil/client-profil.component';
import {ClientAdsComponent} from '../client-ads/client-ads.component';
import {ClientMyReservationsComponent} from '../client-my-reservations/client-my-reservations.component';
import {ClientChatComponent} from '../client-chat/client-chat.component';
export const ClientLayoutRutes: Routes = [
  { path: 'clientProfil',      component: ClientProfilComponent },
  { path: 'clientAds',      component: ClientAdsComponent },
  { path: 'myReservations',      component: ClientMyReservationsComponent },
  { path: 'chat',      component: ClientChatComponent }
]
