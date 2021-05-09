import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, Type } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { HandleError, HttpErrorHandler } from './http-error-handler.service';
import { User } from './user';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    Authorization: 'my-auth-token'
  })
};
@Injectable({
  providedIn: 'root'
})
export class UserService {

  //get users
  httpUrl = 'https://reqres.in/api/users?page=1';
  //create post method
  httpUrl1 = 'https://reqres.in/api/users';
  //update users
  httpUrl2 = 'https://reqres.in/api/users?page=2';
  //delete users
  httpUrl3 = 'https://reqres.in/api/users/2';
  //display register unsucessfull
  httpUrl4='https://reqres.in/api/register';


  private handleError: HandleError;

  constructor(
    private http: HttpClient,
    httpErrorHandler: HttpErrorHandler) {
    this.handleError = httpErrorHandler.createHandleError('UserService');
  }

  /** GET users from the server */
  getUser(): Observable<User[]> {
    return this.http.get<User[]>(this.httpUrl)
      .pipe(
        catchError(this.handleError('getUser', []))
      );
  }
  /** POST: add a new user to the database */
  addUser(post: User): Observable<User> {
    return this.http.post<User>(this.httpUrl1, post, httpOptions)
      .pipe(
        catchError(this.handleError('addUser', post))
      );
  }
  public updateUser(postData: User): Observable<User> {
    return this.http.put<User>(this.httpUrl2, postData, httpOptions).pipe(
      catchError(this.handleError('UpdateUser', postData))
    );
  }
  public deleteUser(id) {
    let endPoints = "/" + id + "/";
    console.log(this.httpUrl3 + endPoints);
    this.http.delete(this.httpUrl3 + endPoints).pipe(
      catchError(this.handleError('deletUser'))
    );
  }
  public register(){

    return this.http.post(this.httpUrl1, httpOptions)
      .pipe(
        catchError(this.handleError('register'))
      );
  }



}