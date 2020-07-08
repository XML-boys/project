import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule, } from '@angular/common';
import { BrowserModule  } from '@angular/platform-browser';

import {AdminLayoutComponent} from './admin-layout/admin-layout.component';
import {LoginComponent} from './login/login.component';
import {AddModelComponent} from './add-model/add-model.component';
import {EditModelComponent} from './edit-model/edit-model.component';

const routes: Routes = [

  {
    path: '',
    redirectTo: 'admin/login',
    pathMatch: 'full',
  },
  {
    path: 'admin',
    component: AdminLayoutComponent,
    children: [
      {
        path: '',
        loadChildren: './admin-layout/admin-layout.module#AdminLayoutModule'
      }]
  },
  {
    path: 'admin/login',
    component: LoginComponent,
    children: [
    ]},
  {
    path: 'admin/addModel',
    component: AddModelComponent,
    children: [
    ]},
  {
    path: 'admin/editModel',
    component: EditModelComponent,
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
