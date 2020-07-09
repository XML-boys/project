import {Routes} from '@angular/router';
import {AgentCreateAdComponent} from '../agent-create-ad/agent-create-ad.component';
import {AgentCreateVehicleComponent} from '../agent-create-vehicle/agent-create-vehicle.component';
import {AgentMyAdsComponent} from '../agent-my-ads/agent-my-ads.component';

export const AgentLayoutRutes: Routes = [
  { path: 'createAd',      component: AgentCreateAdComponent },
  { path: 'createVehicle',      component: AgentCreateVehicleComponent },
  { path: 'myAds',      component: AgentMyAdsComponent }
];
