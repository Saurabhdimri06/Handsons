import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {EditEmpComponent} from './edit-emp/edit-emp.component';
import {ViewEmpComponent} from './view-emp/view-emp.component';
import {EditEmpTemplateDrivenComponent} from "./edit-emp-template-driven/edit-emp-template-driven.component";
import {EditEmpReactiveComponent} from "./edit-emp-reactive/edit-emp-reactive.component";
import {EditEmpFormBuilderComponent} from "./edit-emp-form-builder/edit-emp-form-builder.component";
import { UserComponent } from './user/user.component';

// './components/home/home.component'
const routes: Routes = [
  {path: 'edit-emp', component: EditEmpComponent},
  {path: 'view-emp', component: ViewEmpComponent},
  {path: 'edit-emp-template', component: EditEmpTemplateDrivenComponent},
  {path: 'edit-emp-reactive', component: EditEmpReactiveComponent},
  {path: 'edit-emp-form-builder', component: EditEmpFormBuilderComponent},
  { path: 'user-list', component:UserComponent },
];

@NgModule({
  
  
  // imports: [RouterModule.forRoot(routes)],
  imports: [RouterModule.forRoot(routes)],
  // imports: [
  //   BrowserModule, RouterModule
  // ],
  exports: [RouterModule],
  
})
export class AppRoutingModule { }

