import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeListPageComponent } from './employee-list-page/employee-list-page.component';
import { EmployeeAddPageComponent } from './employee-add-page/employee-add-page.component';
import { EmployeeEditPageComponent } from './employee-edit-page/employee-edit-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { EmployeeViewPageComponent } from './employee-view-page/employee-view-page.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeListPageComponent,
    EmployeeAddPageComponent,
    EmployeeEditPageComponent,
    LoginPageComponent,
    EmployeeViewPageComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
