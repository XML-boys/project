import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ClientCompModule} from '../client-comp/client-comp.module';
import {RouterModule} from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FlatpickrModule} from 'angularx-flatpickr';
import {ClientLayoutRutes} from './client-layout.routing';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    ClientCompModule,
    RouterModule.forChild(ClientLayoutRutes),
    FormsModule,
    NgbModule,
    ReactiveFormsModule,
    FlatpickrModule.forRoot()
  ]
})
export class ClientLayoutModule { }
