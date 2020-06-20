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



@NgModule({
  declarations: [PagesComponent, MyAdsComponent, NewAdComponent, NewVehicleComponent],
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
        NbCheckboxModule
    ]
})
export class PagesModule { }
