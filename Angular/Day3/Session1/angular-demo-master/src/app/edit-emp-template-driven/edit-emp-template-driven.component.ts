import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee.model';
import { Skill } from '../skill.model';
import { department } from "../dept.model";

@Component({
  selector: 'app-edit-emp-template-driven',
  templateUrl: './edit-emp-template-driven.component.html',
  styleUrls: ['./edit-emp-template-driven.component.css']
})
export class EditEmpTemplateDrivenComponent implements OnInit {

  departments:department[] = [
    { id: 1, name: "Payroll" },
    { id: 2, name: "Internal" },
    { id: 3, name: "HR" },
    { id:4, name: "Hashira"}
  ];

  employee: Employee  = {firstName: "Saurabh",
  lastName: "Dimri",
  salary: 100000,
  id: 1,
  permanentStaff: "Yes",
  department: {
    id: 4,
    name: "Hashira"
  },
  dob: new Date("07-06-1998")
  };

  skills: Skill[] = [{id: 1, name: "HTML"},
  {id: 2, name: "CSS"},
  {id: 3, name: "JS"}]

  constructor(
    
  ) { }

  ngOnInit(): void {
  }

  compareFn(id1: number,id2: number): boolean {
    return id1==id2;
}
  onSubmit(): void {
    console.log(this.employee);
  }

changeFn(event:Event): void {
    if((event.target as HTMLInputElement).value == '1')
    {
      this.employee.department = this.departments[0];
    }
    else if((event.target as HTMLInputElement).value == '2')
    {
      this.employee.department = this.departments[1];
    }
    else if((event.target as HTMLInputElement).value == '3')
    {
      this.employee.department = this.departments[2];
    } 
  }
}
