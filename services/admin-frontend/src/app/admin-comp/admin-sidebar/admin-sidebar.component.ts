import { Component, OnInit } from '@angular/core';

declare interface RouteInfo {
  path: string;
  title: string;
  icon: string;
  class: string;
}

export const ROUTES: RouteInfo[] = [
  { path: '/admin/adminUprava', title: 'Upravljanje entitetima',  icon: '', class: '' },
  { path: '/admin/adminSifrarnik', title: 'Sifrarnik',  icon: '', class: '' },
  { path: '/admin/registerAgent', title: 'Registruj agenta',  icon: '', class: '' },
  { path: '/admin/registerAdmin', title: 'Registruj admina',  icon: '', class: '' }
];

@Component({
  selector: 'app-admin-sidebar',
  templateUrl: './admin-sidebar.component.html',
  styleUrls: ['./admin-sidebar.component.css']
})
export class AdminSidebarComponent implements OnInit {

  menuItems: any[];
  constructor() { }

  ngOnInit() {
    this.menuItems = ROUTES.filter(menuItem => menuItem);
  }

}
