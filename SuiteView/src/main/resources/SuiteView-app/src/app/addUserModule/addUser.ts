import { Component, Input,NgModule } from '@angular/core';
import {AddUserModel} from "./addUser.model";
import {NgForm} from '@angular/forms';

import { UserService } from '../service/user.service';
import { Observable }     from 'rxjs/Observable';
import {  BlockUI, NgBlockUI } from 'ng-block-ui';

@Component({
    selector: 'addUser',
    templateUrl: './addUser.html',
    styleUrls: ['./addUser.css']
  })
  export class addUserComponent{
    @BlockUI() blockUI: NgBlockUI;
    constructor(private userService: UserService) {}
    onFormSubmit(userForm: NgForm) {
      this.blockUI.start("Adding User...");
        this.userService.addUser(userForm.value).subscribe(
          (model: any) => {
            this.blockUI.stop();
            this.blockUI.start(model.Result);
     
            setTimeout(() => {
              this.blockUI.stop();
            }, 4000);
          },
          (error) => console.log(error)
      );
       // console.log(userForm.value);
        //console.log('Name:' + userForm.controls['fname'].value);
    } 
  }