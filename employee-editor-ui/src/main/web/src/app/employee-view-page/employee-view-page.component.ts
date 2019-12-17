import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-employee-view-page',
  templateUrl: './employee-view-page.component.html',
  styleUrls: ['./employee-view-page.component.scss']
})
export class EmployeeViewPageComponent implements OnInit {
  employee: any;

  constructor(private route: ActivatedRoute, public router: Router) { }

  ngOnInit() {
    this.employee = JSON.parse(this.route.snapshot.queryParams.employee);
  }

}
