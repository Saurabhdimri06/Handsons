import { Component, OnInit } from '@angular/core';
import { NavigationStart, Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
authService:AuthService;
  constructor(private route: Router,authService:AuthService){
    this.authService=authService;
  }

  ngOnInit(){
     this.route.events.subscribe(event =>{
        if (event instanceof NavigationStart){
         
        }
     })
    }
username:string='';
password:string='';
valid:boolean=false;
 submit1():void{
if(this.username=="admin"&&this.password=="password"){
  this.authService.login();
  this.route.navigate(['/modify-emp']);
}

else{

  this.valid=true;
  console.log(this.valid);
}

}
}