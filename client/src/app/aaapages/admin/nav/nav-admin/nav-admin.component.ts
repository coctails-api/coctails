import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav-admin',
  templateUrl: './nav-admin.component.html',
  styleUrls: ['./nav-admin.component.css'],
})
export class NavAdminComponent implements OnInit {
  isOpen = false;
  showSublist = false;

  constructor() {}

  ngOnInit(): void {}

  toggleMenu() {
    this.isOpen = !this.isOpen;
  }
}
