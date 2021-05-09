import { Component, OnInit } from '@angular/core';
import { Employee } from "../employee.model";
import { Skill } from "../skill.model";
import { department } from "../dept.model";

import { FormGroup, FormControl, Validators } from '@angular/forms'; 

@Component({
  selector: 'app-edit-emp-reactive',
  templateUrl: './edit-emp-reactive.component.html',
  styleUrls: ['./edit-emp-reactive.component.css']
})
export class EditEmpReactiveComponent implements OnInit {

  departments:department[] = [];
  skills:Skill[] = [];
  employee:Employee = {id:0,firstName:"", lastName:"", salary:0,permanentStaff:"false",department: {id:0,name:""}, dob:new Date("12/31/2000")};
  
  empForm:FormGroup = new FormGroup({});
  get name() { return this.empForm.get('name'); }
  
  get errors() {
    const name = this.empForm.get('name');
   if(name !== null)
     return name.errors;
   else
     return;
  }

  get department() {
    const department = this.empForm.get('department');
    return this.empForm.get('department') as FormControl;
  }

  get salary(){return this.empForm.get('salary'); }
  get permanent() { return this.empForm.get('permanent'); }
  constructor(private route : ActivatedRoute, private employeeService : EmployeeService) { } 

  ngOnInit(): void {

    this.departments = [{ id: 1, name: "Payroll" },
      { id: 2, name: "Internal" },
      { id: 3, name: "HR" },
      { id:4, name: "Hashira"}
    ];
    this.employee = {id: 3,firstName: "Saurabh", lastName:"Dimri" ,salary: 10000, permanentStaff: "true", department: {id: 1,name: "Payroll"}, dob: new Date("12/31/2000")};
    this.empForm = new FormGroup({
      'name': new FormControl(this.employee.firstName, 
        [
          Validators.required,
          Validators.minLength(4),
          Validators.maxLength(20)
        ]),
      'department': new FormControl(this.departments[0]),
      'salary': new FormControl(this.employee.salary),
      'permanent': new FormControl(this.employee.permanentStaff)
      });
  }

  onSubmit(): void{
    this.employee.firstName = this.empForm.get('name')?.value;
    this.employee.salary = this.empForm.get('salary')?.value;
    this.employee.department = this.empForm.get('department')?.value;
    this.employee.permanentStaff = this.empForm.get('permanent')?.value;
    console.log(this.employee);
    console.log(this.empForm.value);
  }
  
}
