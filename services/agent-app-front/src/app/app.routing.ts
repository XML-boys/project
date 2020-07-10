import {Routes, RouterModule} from '@angular/router';
import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {BrowserModule} from '@angular/platform-browser';
import {AgentLayoutComponent} from './agent-layout/agent-layout.component';
import {LoginAgentComponent} from './login-agent/login-agent.component';
import {AgentReserveForMyselfComponent} from './agent-reserve-for-myself/agent-reserve-for-myself.component';

const routes: Routes = [

  {
    path: '',
    redirectTo: 'agent-app/login',
    pathMatch: 'full',
  },
  {
    path: 'agent-app',
    component: AgentLayoutComponent,
    children: [
      {
        path: '',
        loadChildren: './agent-layout/agent-layout.module#AgentLayoutModule'
      }]
  },
  {
    path: 'agent-app/login',
    component: LoginAgentComponent,
    children: [
    ]},
  {
    path: 'agent-app/agent-reserve-for-myself',
    component: AgentReserveForMyselfComponent,
    children: [
    ]},
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
