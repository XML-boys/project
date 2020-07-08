import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminNavbarComponent } from './admin-navbar/admin-navbar.component';
import { AdminSidebarComponent } from './admin-sidebar/admin-sidebar.component';
import {RouterModule} from '@angular/router';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';


@NgModule({
  declarations: [AdminNavbarComponent, AdminSidebarComponent],
  exports: [AdminNavbarComponent, AdminSidebarComponent],
  imports: [
    CommonModule,
    RouterModule,
    NgbModule
  ]
})
export class AdminCompModule { }
