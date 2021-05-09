import { Component, OnInit } from '@angular/core';
import { department } from '../dept.model';
import { Employee } from '../employee.model';
import { Skill } from '../skill.model';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  constructor() {
    // filteredEmployees: Employee[];
   }

  ngOnInit(): void {
  }

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

  searchKey='';
  
  skills: Skill[] = [{
    id: 1,
    name: "html"
  }, {
    id: 2,
    name: "css"
  }];

  departments:department[]=[{
    id:1,
    name:"Employer"
    },{ id:2,
    name:"Payroll"},{
      id:3,
      name:"Contractor"
    }, {
      id: 4,
      name: "Hokage"
  }];
  
  fin='';

  filteredEmployees : Employee[];

  //Create the search method
  search(event): void {
    this.fin = event.target.value;
    this.filteredEmployees = this.employeeList.filter(name => name.firstName.includes(this.fin))
  }

}
