import { Component, Input,NgModule,OnInit } from '@angular/core';
import {NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';
import {NgbCarouselConfig} from '@ng-bootstrap/ng-bootstrap';

import {  ImageService} from '../service/image.service';
import {CameraService} from '../service/camera.service'

import { Observable }     from 'rxjs/Observable';
import {  BlockUI, NgBlockUI } from 'ng-block-ui';

import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';

import {ImageViewModel} from "./imageView.model";

@Component({
  selector: 'imageView',
  templateUrl: './imageView.html',
  styleUrls: ['./imageView.css'],
  providers: [NgbCarouselConfig] 
})

export class ImageViewComponent implements OnInit{
    
   now = new Date();
  model: NgbDateStruct;
  fromTime = {};
  toTime ={};
  closeResult: string;
  imageArr :ImageViewModel[]=[];
  camArry=[];
  selectedCamera:string;
  @Input() user:any;
  @BlockUI() blockUI: NgBlockUI;
  constructor(private imageService: ImageService,private cameraService:CameraService, config: NgbCarouselConfig,private modalService: NgbModal) {
    config.interval = 10000;
    config.wrap = false;
    config.keyboard = false;
  }
  ngOnInit() {
    this.fromTime = {hour:1,minute:1};
    this.toTime ={hour:23,minute:23};
    this.model = {year: this.now.getFullYear(), month: this.now.getMonth()+1 , day: this.now.getDate()};
    this.getCameraUser();
   
    }
  searchImage (content){
   
    this.blockUI.start("Searching Image...");
        this.imageService.searchImage(this.selectedCamera,this.model,this.fromTime,this.toTime).subscribe(
          (model: any) => {
            this.blockUI.stop();
            this.blockUI.start(model.Result);
            this.imageArr=model;
            this.modalService.open(content,{ size: 'lg' }).result.then((result) => {
                this.closeResult = `Closed with: ${result}`;
              }, (reason) => {
                this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
              });
            setTimeout(() => {
              this.blockUI.stop();
            }, 2000);
          },
          (error) => console.log(error)
      );
  }
  deleteImage(objectKey){
    console.log(objectKey);
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

    trackByIndex(index: number, value: number) {
        return index;
    }
    getCameraUser(){
        this.cameraService.getAllCameraUser().subscribe(
            (model: any) => {
                this.camArry = model;
                this.selectedCamera = this.camArry[0];
            },
            (error) => console.log(error)
        );
    }

  
}
