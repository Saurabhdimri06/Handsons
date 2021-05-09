import { DatePipe } from "@angular/common";
import { department } from "./dept.model";

export interface Employee{
   
    firstName: string,
    lastName: string,
    salary: number,
    id: number;
    permanentStaff: string,
    department: department,
    dob: Date
}

    