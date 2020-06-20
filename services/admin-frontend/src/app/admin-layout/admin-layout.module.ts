import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminLayoutComponent } from './admin-layout.component';
import {RouterModule} from '@angular/router';
import {AdminCompModule} from '../admin-comp/admin-comp.module';
import {AdminLayoutRutes} from './admin-layout.routing';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';



@NgModule({
  declarations: [AdminLayoutComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(AdminLayoutRutes),
    FormsModule,
    NgbModule,
    ReactiveFormsModule,
    AdminCompModule
  ],
  exports: [AdminLayoutComponent
  ]
})
export class AdminLayoutModule { }
