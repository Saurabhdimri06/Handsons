import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }
  loggedin:boolean;

  login(){
    this.loggedin=true;
  }
  logout(){
    this.loggedin=false;
  }
  isLoggedIn():boolean{
    return this.loggedin;
  }

}