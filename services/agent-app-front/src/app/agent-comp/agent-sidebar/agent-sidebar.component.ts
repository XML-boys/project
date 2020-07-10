import { Component, OnInit } from '@angular/core';

declare interface RouteInfo {
  path: string;
  title: string;
  icon: string;
  class: string;
}

export const ROUTES: RouteInfo[] = [
  { path: '/agent-app/createAd', title: 'Create ad',  icon: '', class: '' },
  { path: '/agent-app/createVehicle', title: 'Create vehicle',  icon: '', class: '' },
  { path: '/agent-app/myAds', title: 'My ads',  icon: '', class: '' },
  { path: '/agent-app/myProfile', title: 'My profile',  icon: '', class: '' },
  { path: '/agent-app/allAds', title: 'All ads',  icon: '', class: '' },
  { path: '/agent-app/myVehicles', title: 'My vehicles',  icon: '', class: '' },
];

@Component({
  selector: 'app-agent-sidebar',
  templateUrl: './agent-sidebar.component.html',
  styleUrls: ['./agent-sidebar.component.css']
})
export class AgentSidebarComponent implements OnInit {
  menuItems: any[];
  constructor() { }

  ngOnInit() {
    this.menuItems = ROUTES.filter(menuItem => menuItem);
  }

}
