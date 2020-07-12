import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppRoutingModule} from './app.routing';
import {AppComponent} from './app.component';
import {ClientLoginComponent} from './client-login/client-login.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {ClientLayoutComponent} from './client-layout/client-layout.component';
import {ClientLayoutModule} from './client-layout/client-layout.module';
import {RouterModule} from '@angular/router';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {TokenInterceptor} from './security/TokenInterceptor';
import {DatePipe} from '@angular/common';
import {MatButtonModule, MatDatepickerModule, MatFormFieldModule, MatNativeDateModule, MatSelectModule} from '@angular/material';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FlatpickrModule} from 'angularx-flatpickr';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ClientCompModule} from './client-comp/client-comp.module';
import { ClientRegisterComponent } from './client-register/client-register.component';
import { ClientProfilComponent } from './client-profil/client-profil.component';
import { ClientAdsComponent } from './client-ads/client-ads.component';
import { ClientReserveForMyselfComponent } from './client-reserve-for-myself/client-reserve-for-myself.component';
import { ClientMyReservationsComponent } from './client-my-reservations/client-my-reservations.component';

@NgModule({
  declarations: [
    AppComponent,
    ClientLoginComponent,
    ClientLayoutComponent,
    ClientRegisterComponent,
    ClientProfilComponent,
    ClientAdsComponent,
    ClientReserveForMyselfComponent,
    ClientMyReservationsComponent
  ],
  imports: [
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    RouterModule,
    AppRoutingModule,
    NgbModule,
    ReactiveFormsModule,
    FontAwesomeModule,
    FlatpickrModule.forRoot(),
    MatFormFieldModule,
    MatSelectModule,
    MatDatepickerModule,
    MatButtonModule,
    MatFormFieldModule,
    MatNativeDateModule,
    ClientLayoutModule,
    ClientCompModule
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi: true},
    DatePipe
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
