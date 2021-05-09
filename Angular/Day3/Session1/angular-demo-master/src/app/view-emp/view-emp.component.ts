import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee.model';
import { Skill } from '../skill.model';

@Component({
  selector: 'app-view-emp',
  templateUrl: './view-emp.component.html',
  styleUrls: ['./view-emp.component.css']
})
export class ViewEmpComponent implements OnInit {

  title = 'Employee Details';

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

  constructor() { }

  ngOnInit(): void {
  }

}
