import { Routes } from '@angular/router';
import {AdminUpravaComponent} from '../admin-uprava/admin-uprava.component';

export const AdminLayoutRutes: Routes = [
  { path: 'adminUprava',      component: AdminUpravaComponent },
  { path: 'upravaKomentarima',      component: AdminUpravaComponent },
];
