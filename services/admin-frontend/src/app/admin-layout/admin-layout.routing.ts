import { Routes } from '@angular/router';
import {AdminUpravaComponent} from '../admin-uprava/admin-uprava.component';
import {AdminSifrarnikComponent} from '../admin-sifrarnik/admin-sifrarnik.component';
import {AdminRegisterAgentComponent} from '../admin-register-agent/admin-register-agent.component';

export const AdminLayoutRutes: Routes = [
  { path: 'adminUprava',      component: AdminUpravaComponent },
  { path: 'adminSifrarnik',      component: AdminSifrarnikComponent },
  { path: 'registerAgent',      component: AdminRegisterAgentComponent },
];
