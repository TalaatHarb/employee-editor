import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../models/employee.model';
import { EmployeeService } from '../employee.service';

const MESSAGE_TIME_OUT = 1500;

@Component({
  selector: 'app-employee-edit-page',
  templateUrl: './employee-edit-page.component.html',
  styleUrls: ['./employee-edit-page.component.scss']
})
export class EmployeeEditPageComponent implements OnInit {

  employee: Employee;
  success = false;
  failure = false;
  message: any;

  constructor(private route: ActivatedRoute, private employeeService: EmployeeService, public router: Router) { }

  ngOnInit() {
    this.employee = JSON.parse(this.route.snapshot.queryParams.employee);
  }

  save() {
    this.employeeService.update(this.employee).subscribe(() => {
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
