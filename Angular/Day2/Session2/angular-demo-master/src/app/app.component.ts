import { ResolvedStaticSymbol } from '@angular/compiler';
import { Component } from '@angular/core';
import { Employee } from './employee.model';
import { Skill } from './skill.model';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'Angular Learning';

  // title = 'Employee Details';

  // employee: Employee  = {firstName: "Rambo",
  // lastName: "Slayer",
  // salary: 100000,
  // id: 1,
  // permanentStaff: "Yes",
  // deptId: 1516,
  // deptName: "Kaizoku",
  // dob: new Date("12-10-1998")
  // };

  // skills: Skill[] = [{id: 1, name: "HTML"},
  // {id: 2, name: "CSS"},
  // {id: 3, name: "JS"}]

  
  
  // ,
  // {firstName: "Zoro",
  // lastName: "Roronoa",
  // bounty: 90000,
  // permanentStaff: true,
  // skill:{id: 1,name: "Swordsman"}, dob: "Date is"}
}
