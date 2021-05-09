import { skill } from "./skills";

export interface employee extends skill{
    id : number,
    name : string,
    salary : number,
    permanent : boolean,
    dept,
    skill
}
