import { employee } from "./employee";

export interface department extends employee{
    id : number,
    name : string
}