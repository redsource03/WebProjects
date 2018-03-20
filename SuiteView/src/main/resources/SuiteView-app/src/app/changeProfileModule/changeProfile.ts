import { Component,Input } from '@angular/core';
import {NgForm} from '@angular/forms';
import {  BlockUI, NgBlockUI } from 'ng-block-ui';
import { UserService } from '../service/user.service';

@Component({
    selector: 'changeProfile',
  templateUrl: './changeProfile.html',
  styleUrls: ['./changeProfile.css'],
})
export class ChangeProfileComponent {
    @Input() user:any;
    @BlockUI() blockUI: NgBlockUI;
    constructor(private userService: UserService) {}
    onFormSubmit(userForm: NgForm) {
        this.blockUI.start("Updating User...");
        this.userService.updateUser(userForm.value).subscribe(
          (model: any) => {
            this.blockUI.stop();
            this.blockUI.start(model.Result);
     
            setTimeout(() => {
              this.blockUI.stop();
            }, 4000);
          },
          (error) => console.log(error)
      );
}
