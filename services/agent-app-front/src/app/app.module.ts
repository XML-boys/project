import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AgentCreateAdComponent } from './agent-create-ad/agent-create-ad.component';
import {RouterModule} from '@angular/router';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {AppRoutingModule} from './app.routing';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {AgentLayoutModule} from './agent-layout/agent-layout.module';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {FlatpickrModule} from 'angularx-flatpickr';
import {DatePipe} from '@angular/common';
import {TokenInterceptor} from './security/TokenInterceptor';
import { LoginAgentComponent } from './login-agent/login-agent.component';
import {MatButtonModule, MatDatepickerModule, MatFormFieldModule, MatNativeDateModule, MatSelectModule} from '@angular/material';
import { AgentCreateVehicleComponent } from './agent-create-vehicle/agent-create-vehicle.component';
import { AgentMyAdsComponent } from './agent-my-ads/agent-my-ads.component';
import { AgentReserveForMyselfComponent } from './agent-reserve-for-myself/agent-reserve-for-myself.component';
import { ProfilAgentAppComponent } from './profil-agent-app/profil-agent-app.component';
import { AllAddsAgentAppComponent } from './all-adds-agent-app/all-adds-agent-app.component';
import { AllVehiclesAgentAppComponent } from './all-vehicles-agent-app/all-vehicles-agent-app.component';

@NgModule({
  declarations: [
    AppComponent,
    AgentCreateAdComponent,
    LoginAgentComponent,
    AgentCreateVehicleComponent,
    AgentMyAdsComponent,
    AgentReserveForMyselfComponent,
    ProfilAgentAppComponent,
    AllAddsAgentAppComponent,
    AllVehiclesAgentAppComponent
  ],
  imports: [
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    RouterModule,
    AppRoutingModule,
    NgbModule,
    ReactiveFormsModule,
    AgentLayoutModule,
    FontAwesomeModule,
    FlatpickrModule.forRoot(),
    MatFormFieldModule,
    MatSelectModule,
    MatDatepickerModule,
    MatButtonModule,
    MatFormFieldModule,
    MatNativeDateModule
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi: true},
    DatePipe
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
