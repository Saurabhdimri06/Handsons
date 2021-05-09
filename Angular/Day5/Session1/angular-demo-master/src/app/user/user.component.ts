import { ThrowStmt } from '@angular/compiler';
import { stringify } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(private userService: UserService, private fb: FormBuilder) {

  }
  users: User[];
  user: string;
  saveUser: User;
  updateUser: User;
  message: string = '';
  display: string = "none";
  ngOnInit(): void {
    this.getUser();
    this.user = JSON.stringify(this.users)
    //console.log(this.posts);
  }
  saveUserForm = this.fb.group({
    id: [],
    first_name: [''],
    last_name: [''],
    email: [],
    avatar: []
  });

  onSubmit() {
    //console.log(this.saveUserForm.value);
    this.saveUser = this.saveUserForm.value;
    // console.log(this.saveUser);

    this.add();
    this.message = "user added successfully !!";
    this.display = "none";
  }

  add(): void {
    // The server will generate the id for this new user
    this.userService.addUser(this.saveUser)
      .subscribe(user => console.log('User added: ', user));
  }
  //to get all users
  getUser(): void {
    this.userService.getUser().subscribe(
      user => { this.users = user }
    );
  }
  //to display the user creation form 
  activate() {
    this.display = "";
    console.log(this.display);
  }
//to update user
  updateUsers(): void {
    this.updateUser=this.saveUserForm.value;
    //this.saveUser=this.updateUser;
    this.display = "";
    this.userService.updateUser(this.updateUser).
    subscribe(user => console.log('User Updated : ', user));
  }
  //to delete user
  deleteUser():void{
    let userId=this.saveUser.id;
    this.display = "";
    console.log(userId);
    this.userService.deleteUser(userId);
    console.log('User deleted ');
  

  }
  register():void{
    this.userService.register();
    
  }


}