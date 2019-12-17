import { Component, OnInit } from '@angular/core';
import { Employee } from '../models/employee.model';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeService } from '../employee.service';
import { v4 } from 'node_modules/uuid';

const MESSAGE_TIME_OUT = 1500;

@Component({
  selector: 'app-employee-add-page',
  templateUrl: './employee-add-page.component.html',
  styleUrls: ['./employee-add-page.component.scss']
})
export class EmployeeAddPageComponent implements OnInit {

  employee: Employee;
  success = false;
  failure = false;
  message: any;

  constructor(private route: ActivatedRoute, private employeeService: EmployeeService, public router: Router) { }

  ngOnInit() {
    this.employee = { id: null, firstName: null, lastName: null, email: null };
  }

  create() {
    console.log('create started');
    this.employee.id = v4();
    console.log(this.employee.id);
    this.employeeService.create(this.employee).subscribe(() => {
      this.success = true;
      this.failure = false;
      setTimeout(() => {
        this.success = false;
        this.router.navigate(['site/list']);
      }, MESSAGE_TIME_OUT);
    }, error => {
      this.failure = true;
      this.success = false;
      this.message = error.message;
      console.error(error);
    });
  }

}
