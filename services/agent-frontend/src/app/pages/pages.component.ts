import { Component, OnInit } from '@angular/core';
import {MENU_ITEMS} from './pages-menu';

@Component({
  selector: 'app-pages',
  templateUrl: './pages.component.html',
  styleUrls: []
})
export class PagesComponent {

  menu = MENU_ITEMS;
}
