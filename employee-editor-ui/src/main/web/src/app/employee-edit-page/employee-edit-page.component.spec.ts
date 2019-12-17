import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeEditPageComponent } from './employee-edit-page.component';

describe('EmployeeEditPageComponent', () => {
  let component: EmployeeEditPageComponent;
  let fixture: ComponentFixture<EmployeeEditPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeEditPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeEditPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
