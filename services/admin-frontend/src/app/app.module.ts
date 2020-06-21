import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {RouterModule} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AppRoutingModule } from './app.routing';
import {AdminLayoutComponent} from './admin-layout/admin-layout.component';
import {AdminCompModule} from './admin-comp/admin-comp.module';
import {AdminLayoutModule} from './admin-layout/admin-layout.module';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { AdminUpravaComponent } from './admin-uprava/admin-uprava.component';
import { AdminSifrarnikComponent } from './admin-sifrarnik/admin-sifrarnik.component';
import {DropdownListModule} from 'ngx-dropdown-list';
import { AdminRegisterAgentComponent } from './admin-register-agent/admin-register-agent.component';
import { LoginComponent } from './login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminUpravaComponent,
    AdminSifrarnikComponent,
    AdminRegisterAgentComponent,
    LoginComponent
  ],
    imports: [
        BrowserAnimationsModule,
        FormsModule,
        HttpClientModule,
        RouterModule,
        AppRoutingModule,
        NgbModule,
        ReactiveFormsModule,
        AdminLayoutModule,
        FontAwesomeModule,
        DropdownListModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
