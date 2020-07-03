import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {RouterModule} from '@angular/router';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AppRoutingModule } from './app.routing';
import {AdminLayoutComponent} from './admin-layout/admin-layout.component';
import {AdminCompModule} from './admin-comp/admin-comp.module';
import {AdminLayoutModule} from './admin-layout/admin-layout.module';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { AdminUpravaComponent } from './admin-uprava/admin-uprava.component';
import { AdminSifrarnikComponent } from './admin-sifrarnik/admin-sifrarnik.component';
import { AdminRegisterAgentComponent } from './admin-register-agent/admin-register-agent.component';
import { LoginComponent } from './login/login.component';
import {TokenInterceptor} from './security/tokenInterceptor';
import {DatePipe} from '@angular/common';
import { AdminRegisterAdminComponent } from './admin-register-admin/admin-register-admin.component';
import {MatFormFieldModule, MatSelectModule} from '@angular/material';
import { AddModelComponent } from './add-model/add-model.component';
import {AdminNavbarComponent} from './admin-comp/admin-navbar/admin-navbar.component';
import {AdminSidebarComponent} from './admin-comp/admin-sidebar/admin-sidebar.component';
import { EditModelComponent } from './edit-model/edit-model.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminUpravaComponent,
    AdminSifrarnikComponent,
    AdminRegisterAgentComponent,
    LoginComponent,
    AdminRegisterAdminComponent,
    AddModelComponent,
    EditModelComponent
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
    MatFormFieldModule,
    MatSelectModule
  ],
  exports: [],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi: true},
    DatePipe
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
