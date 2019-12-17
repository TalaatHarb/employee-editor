import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeListPageComponent } from './employee-list-page/employee-list-page.component';
import { AuthGuard } from './auth/auth.guard';
import { EmployeeEditPageComponent } from './employee-edit-page/employee-edit-page.component';
import { EmployeeAddPageComponent } from './employee-add-page/employee-add-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { EmployeeViewPageComponent } from './employee-view-page/employee-view-page.component';


const routes: Routes = [
  { path: 'site/list', component: EmployeeListPageComponent, canActivate: [AuthGuard] },
  { path: 'site/add', component: EmployeeAddPageComponent, canActivate: [AuthGuard] },
  { path: 'site/view', component: EmployeeViewPageComponent, canActivate: [AuthGuard] },
  { path: 'site/edit', component: EmployeeEditPageComponent, canActivate: [AuthGuard] },
  { path: 'login', component: LoginPageComponent },
  { path: '', component: EmployeeListPageComponent, canActivate: [AuthGuard] },
  { path: '**', component: EmployeeListPageComponent, canActivate: [AuthGuard] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
