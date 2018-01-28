import { Component, Input,NgModule,OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import {EditUserModel} from "./editUser.model";
import { UserService } from '../service/user.service';
import { CameraService } from '../service/camera.service';
import { Observable }     from 'rxjs/Observable';
import {  BlockUI, NgBlockUI } from 'ng-block-ui';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
@Component({
    selector: 'editUser',
    templateUrl: './editUser.html',
    styleUrls: ['./editUser.css']
  })
  
  export class editUserComponent implements OnInit {

    ngOnInit() {

        this.getAllCamera();

    }
    public camArry= [];
    public user:EditUserModel = new EditUserModel();
    closeResult: string;

    @BlockUI() blockUI: NgBlockUI;
    constructor(private userService: UserService,private cameraService: CameraService,private modalService: NgbModal) {}
    open(content) {
        this.modalService.open(content).result.then((result) => {
          this.closeResult = `Closed with: ${result}`;
        }, (reason) => {
          this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
        });
      }
    
      private getDismissReason(reason: any): string {
        if (reason === ModalDismissReasons.ESC) {
          return 'by pressing ESC';
        } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
          return 'by clicking on a backdrop';
        } else {
          return  `with: ${reason}`;
        }
      }
    
    onFormSubmit(userForm: NgForm) {
      
        this.blockUI.start("Searching User...");
          this.userService.searchUser(userForm.value).subscribe(
            (model: any) => {
                this.user = new EditUserModel();
              
              this.user=model;
              if(this.user.username==null){
                this.blockUI.stop();
                this.blockUI.start("Not Found");
                setTimeout(() => {
                    this.blockUI.stop();
                  }, 4000);
              }else{
                setTimeout(() => {
                    this.blockUI.stop();
                  }, 1500);
              }
              
            },
            (error) => console.log(error)
        );
         // console.log(userForm.value);
          //console.log('Name:' + userForm.controls['fname'].value);
      }
    trackByIndex(index: number, value: number) {
        return index;
    }
    getAllCamera(){
        this.cameraService.getAllCamera().subscribe(
            (model: any) => {
                this.camArry = model;
              
            },
            (error) => console.log(error)
        );
    }
    remove(user,cam){
        this.blockUI.start("Removing Camera...");
        this.userService.removeCameraFromUser(user,cam).subscribe(
            (model: any) => {
                this.user=model;
                this.blockUI.stop();
                this.blockUI.start("Camera has been removed");
                setTimeout(() => {
                    this.blockUI.stop();
                  }, 1500);
            },
            (error) => console.log(error)
        );
    }
    add(user,cam){
        this.blockUI.start("Adding Camera...");
        this.userService.addCameraToUser(user,cam).subscribe(
            (model: any) => {
                this.user=model;
                this.blockUI.stop();
                this.blockUI.start("Camera has been added");
                setTimeout(() => {
                    this.blockUI.stop();
                  }, 1500);
              
            },
            (error) => console.log(error)
        );
    }
     
  }