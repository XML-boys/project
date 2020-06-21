import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-layout',
  templateUrl: './admin-layout.component.html',
  styleUrls: ['./admin-layout.component.css']
})
export class AdminLayoutComponent implements OnInit {
  token: string;
  constructor() { }

  ngOnInit(): void {
    this.getToken();
  }

  getToken(){
    this.token = localStorage.getItem('jwt');
  }

}
