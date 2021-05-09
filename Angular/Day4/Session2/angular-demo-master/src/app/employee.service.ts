import { Injectable } from '@angular/core';
import { Employee } from './employee.model';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor() { }
  employeeList: Employee[] = [{
    id: 1,
    firstName: "Saurabh",
    lastName: "Dimri",
    salary: 2000,
    permanentStaff: "true",
    dob: new Date(),
    department : {id: 1, name: "Employer"},
  }, {
    id: 2,
    firstName: "Jessica",
    lastName: "Jones",
    salary: 3000,
    permanentStaff: "false",
    dob: new Date(),
    department: {id: 2, name: "Payroll"}
  },{
    id: 3,
    firstName: "Antonio",
    lastName: "Dantonio",
    salary: 4000,
    permanentStaff: "true",
    dob: new Date(),
    department : {id:2, name: "Payroll"}
  },{
    id: 4,
    firstName: "John",
    lastName: "Wick",
    salary: 30500,
    permanentStaff: "true",
    dob: new Date(),
    department : {id: 3, name: "Contractor"},
  },{
    id: 5,
    firstName: "Uzumaki",
    lastName: "Naruto",
    salary: 10000,
    permanentStaff: "false",
    dob: new Date(),
    department : {id: 4, name: "Hokage"}
  }];

  emp :Employee;
  getAllEmployees() : Employee[]{
    return this.employeeList;
  }
  getEmployee(employeeId: number): Employee{
    for(this.emp of this.employeeList){
      if(this.emp.id==employeeId)
      return this.emp;

    }
    return null;
  }
  
}
