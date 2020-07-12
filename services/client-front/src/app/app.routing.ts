import {Routes, RouterModule} from '@angular/router';
import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {BrowserModule} from '@angular/platform-browser';
import {ClientLoginComponent} from './client-login/client-login.component';
import {ClientLayoutComponent} from './client-layout/client-layout.component';
import {ClientRegisterComponent} from './client-register/client-register.component';
import {ClientReserveForMyselfComponent} from './client-reserve-for-myself/client-reserve-for-myself.component';

const routes: Routes = [

  {
    path: '',
    redirectTo: 'client/login',
    pathMatch: 'full',
  },
  {
    path: 'client',
    component: ClientLayoutComponent,
    children: [
      {
        path: '',
        loadChildren: './client-layout/client-layout.module#ClientLayoutModule'
      }]
  },
  {
    path: 'client/login',
    component: ClientLoginComponent,
    children: [
    ]},
  {
    path: 'client/register',
    component: ClientRegisterComponent,
    children: [
    ]},
  {
    path: 'client/client-reserve-for-myself',
    component: ClientReserveForMyselfComponent,
    children: [
    ]}
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
