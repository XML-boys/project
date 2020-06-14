import {PagesComponent} from './pages.component';
import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {MyAdsComponent} from './my-ads/my-ads.component';

const routes: Routes = [{
  path: '',
  component: PagesComponent,
  children: [
    {
      path: 'my-ads',
      component: MyAdsComponent,
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
