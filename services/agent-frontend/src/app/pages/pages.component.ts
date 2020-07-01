import { Component, OnInit } from '@angular/core';
import {MENU_ITEMS} from './pages-menu';
import {LoginService} from '../@core/services/login.service';
import {Router} from '@angular/router';
import {FormBuilder} from '@angular/forms';

@Component({
  selector: 'app-pages',
  templateUrl: './pages.component.html',
  styleUrls: []
})
export class PagesComponent {

  constructor(private service: LoginService, private router: Router) {
    if (localStorage.getItem('jwt') === undefined){
      this.router.navigate(['/agent/login']);
    }
    if (localStorage.getItem('jwt') !== undefined){
      this.service.isLoggedIn().subscribe(
        data => {
          const str = JSON.stringify(data);
          const d = JSON.parse(str);
          localStorage.setItem('username', d.username);
        }, error => {
          console.log(error.status);
          this.router.navigate(['/agent/login']);
        }
      );
    }
  }
  menu = MENU_ITEMS;
}
