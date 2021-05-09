import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-learning';
  favMovie = "Lord Of The Rings";
  emp = {id:1, name:"John", salary:5000, permanent:true, dept:{id:8,name:"Gaming"}, 
                    skill : ["HTML","CSS", "JavaScript"]};
}
