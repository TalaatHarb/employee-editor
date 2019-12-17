import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeAddPageComponent } from './employee-add-page.component';

describe('EmployeeAddPageComponent', () => {
  let component: EmployeeAddPageComponent;
  let fixture: ComponentFixture<EmployeeAddPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeAddPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeAddPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
