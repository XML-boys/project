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
import {DropdownListModule} from 'ngx-dropdown-list';
import {HttpClientModule} from '@angular/common/http';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {FlatpickrModule} from 'angularx-flatpickr';

@NgModule({
  declarations: [
    AppComponent,
    AgentCreateAdComponent
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
    DropdownListModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
