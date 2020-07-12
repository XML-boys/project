import { Component, OnInit } from '@angular/core';

declare interface RouteInfo {
  path: string;
  title: string;
  icon: string;
  class: string;
}

export const ROUTES: RouteInfo[] = [
  { path: '/client/clientProfil', title: 'My profil',  icon: '', class: '' },
  { path: '/client/clientAds', title: 'All ads',  icon: '', class: '' },
  { path: '/client/myReservations', title: 'My reservations',  icon: '', class: '' },
  { path: '/client/chat', title: 'My chat',  icon: '', class: '' },
];
@Component({
  selector: 'app-client-sidebar',
  templateUrl: './client-sidebar.component.html',
  styleUrls: ['./client-sidebar.component.css']
})
export class ClientSidebarComponent implements OnInit {
  menuItems: any[];
  constructor() { }

  ngOnInit(): void {
    this.menuItems = ROUTES.filter(menuItem => menuItem);
  }

}
