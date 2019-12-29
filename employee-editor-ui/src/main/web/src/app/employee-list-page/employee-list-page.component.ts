import { Component, OnInit } from '@angular/core';
import { Employee } from '../models/employee.model';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';
import { EmployeeAddPageComponent } from '../employee-add-page/employee-add-page.component';

@Component({
  selector: 'app-employee-list-page',
  templateUrl: './employee-list-page.component.html',
  styleUrls: ['./employee-list-page.component.scss']
})
export class EmployeeListPageComponent implements OnInit {

  employees: Employee[];

  constructor(public employee: EmployeeService, private router: Router) { }

  ngOnInit() {
    this.employee.getAll().subscribe(list => this.employees = list, error => {
      console.error(error);
    });
  }

  delete(employee: Employee) {
    this.employee.delete(employee).subscribe(() => {
      if (this.employees.length === 1) {
        this.employees = [];
      } else {
        this.employees = this.employees.filter((value) => value !== employee);
      }
    },
      error => {
        console.error(error);
      }
    );
  }

  edit(employee: Employee) {
    this.router.navigate(['site/edit'], { queryParams: { employee: JSON.stringify(employee) } });
  }

  view(employee: Employee) {
    this.router.navigate(['site/view'], { queryParams: { employee: JSON.stringify(employee) } });
  }

  add() {
    this.router.navigate(['site/add']);
  }
}
