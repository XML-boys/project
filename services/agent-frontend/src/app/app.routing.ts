import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {BrowserModule} from '@angular/platform-browser';

const routes: Routes = [

  {
    path: 'agent',
    loadChildren: () => import('./pages/pages.module')
      .then(m => m.PagesModule),
  },
/*  , {
    path: 'signup',
    component: ,
    children: [
    ]}
 */
];

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  exports: [
  ],
})
export class AppRoutingModule { }
