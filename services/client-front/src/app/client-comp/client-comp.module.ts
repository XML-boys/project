import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ClientNavbarComponent } from './client-navbar/client-navbar.component';
import { ClientSidebarComponent } from './client-sidebar/client-sidebar.component';
import {RouterModule} from '@angular/router';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';



@NgModule({
  declarations: [ClientNavbarComponent, ClientSidebarComponent],
  exports: [ClientNavbarComponent, ClientSidebarComponent],
  imports: [
    CommonModule,
    RouterModule,
    NgbModule
  ]
})
export class ClientCompModule { }
