import { Component, OnInit } from '@angular/core';

declare interface RouteInfo {
  path: string;
  title: string;
  icon: string;
  class: string;
}

export const ROUTES: RouteInfo[] = [
  { path: '/adminUprava', title: 'Upravljanje entitetima',  icon: '', class: '' },
  { path: '/adminSifrarnik', title: 'Sifrarnik',  icon: '', class: '' },
  { path: '/registerAgent', title: 'Registruj agenta',  icon: '', class: '' }
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
