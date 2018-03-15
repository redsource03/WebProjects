import { Component, Input,NgModule,OnInit } from '@angular/core';
import {NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';

import {  ImageService} from '../service/image.service';
import { Observable }     from 'rxjs/Observable';
import {  BlockUI, NgBlockUI } from 'ng-block-ui';

@Component({
  selector: 'imageView',
  templateUrl: './imageView.html',
  styleUrls: ['./imageView.css']
})

export class ImageViewComponent implements OnInit{
   now = new Date();
  model: NgbDateStruct;
  fromTime = {};
  toTime ={};
  @BlockUI() blockUI: NgBlockUI;
  constructor(private imageService: ImageService) {}
  ngOnInit() {
    this.fromTime = {hour:1,minute:1};
    this.toTime ={hour:23,minute:23};
    this.model = {year: this.now.getFullYear(), month: this.now.getMonth()+1 , day: this.now.getDate()};
    }
  selectToday() {
    console.log(this.model);
    console.log(this.fromTime);
    console.log(this.toTime);
  }
  searchImage (){
    this.blockUI.start("Searching Image...");
        this.imageService.searchImage("crk90-ctv-008",this.model,this.fromTime,this.toTime).subscribe(
          (model: any) => {
            this.blockUI.stop();
            this.blockUI.start(model.Result);
            console.log(model);
            setTimeout(() => {
              this.blockUI.stop();
            }, 4000);
          },
          (error) => console.log(error)
      );
  }

  
}
