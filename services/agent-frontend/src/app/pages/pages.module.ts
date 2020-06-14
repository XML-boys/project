import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PagesComponent } from './pages.component';
import {ThemeModule} from '../@theme/theme.module';
import {NbCardModule, NbMenuModule} from '@nebular/theme';
import {RouterModule} from '@angular/router';
import {PagesRoutingModule} from './pages-routing.module';
import { MyAdsComponent } from './my-ads/my-ads.component';
import {Ng2SmartTableModule} from 'ng2-smart-table';



@NgModule({
  declarations: [PagesComponent, MyAdsComponent],
  imports: [
    CommonModule,
    ThemeModule,
    NbMenuModule,
    RouterModule,
    PagesRoutingModule,
    NbCardModule,
    Ng2SmartTableModule
  ]
})
export class PagesModule { }
