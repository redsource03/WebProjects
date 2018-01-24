import { Component, Input,NgModule } from '@angular/core';
import {NgForm} from '@angular/forms';

import { CameraService } from '../service/camera.service';
import { Observable }     from 'rxjs/Observable';
import {  BlockUI, NgBlockUI } from 'ng-block-ui';

@Component({
    selector: 'addCamera',
    templateUrl: './addCamera.html',
    styleUrls: ['./addCamera.css']
  })
  export class addCameraComponent{
    @BlockUI() blockUI: NgBlockUI;
    constructor(private cameraService: CameraService) {}
    onFormSubmit(cameraForm: NgForm) {
        this.blockUI.start("Adding Camera...");
          this.cameraService.addCamera(cameraForm.value).subscribe(
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