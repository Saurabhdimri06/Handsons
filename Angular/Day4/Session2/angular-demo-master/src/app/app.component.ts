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

}
