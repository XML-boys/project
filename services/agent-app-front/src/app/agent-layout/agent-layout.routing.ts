import {Routes} from '@angular/router';
import {AgentCreateAdComponent} from '../agent-create-ad/agent-create-ad.component';
import {AgentCreateVehicleComponent} from '../agent-create-vehicle/agent-create-vehicle.component';
import {AgentMyAdsComponent} from '../agent-my-ads/agent-my-ads.component';
import {ProfilAgentAppComponent} from '../profil-agent-app/profil-agent-app.component';
import {AllAddsAgentAppComponent} from '../all-adds-agent-app/all-adds-agent-app.component';
import {AllVehiclesAgentAppComponent} from '../all-vehicles-agent-app/all-vehicles-agent-app.component';

export const AgentLayoutRutes: Routes = [
  { path: 'createAd',      component: AgentCreateAdComponent },
  { path: 'createVehicle',      component: AgentCreateVehicleComponent },
  { path: 'myAds',      component: AgentMyAdsComponent },
  { path: 'myProfile',      component: ProfilAgentAppComponent },
  { path: 'allAds',      component: AllAddsAgentAppComponent },
  { path: 'myVehicles',      component: AllVehiclesAgentAppComponent }
];
