import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Employee } from './models/employee.model';
import { baseUrl } from '../environments/environment';

const getAllUrl = '/api/employees';
const updateUrl = '/api/employees/';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  create(employee: Employee) {
    const httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.httpClient.post<Employee>(
      `${baseUrl}${getAllUrl}`,
      employee, { headers: httpHeaders, withCredentials: true });
  }

  delete(employee: Employee) {
    return this.httpClient.delete<Employee>(`${baseUrl}${updateUrl}${employee.id}`, { withCredentials: true });
  }

  getAll() {
    return this.httpClient.get<Employee[]>(`${baseUrl}${getAllUrl}`, { withCredentials: true });
  }

  update(employee: Employee) {
    const httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.httpClient.put<Employee>(`${baseUrl}${updateUrl}${employee.id}`, employee, { headers: httpHeaders, withCredentials: true });
  }

  constructor(private httpClient: HttpClient) {
  }
}
