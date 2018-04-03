import { Component,Input } from '@angular/core';
import {  BlockUI, NgBlockUI } from 'ng-block-ui';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { ThreadService } from '../service/thread.service';
@Component({
    selector: 'threadContent',
  templateUrl: './threadContent.html',
  styleUrls: ['./threadContent.css'],
})
export class ThreadContentComponent {
    @Input() thread:any;
    @BlockUI() blockUI: NgBlockUI;
    body:string;
    comments:any;
    constructor(private modalService: NgbModal,private threadService:ThreadService) {}
    public open(content) {
        this.getThreadComment();
        this.modalService.open(content,{ size: 'lg' }).result.then((result) => {
          
        }, (reason) => {
          
        });
    }
    public getThreadComment(){
        this.threadService.getThreadComment(this.thread.threadkey).subscribe(
            (model: any) => {
                this.comments=model;
            },
            (error) => console.log(error)
        );
    }
    public addComment(){
       this.body= this.body.replace(/\n/g,'\\n');
        this.threadService.addThreadComment(this.thread.threadkey,this.body).subscribe(
            (model: any) => {
                this.getThreadComment();
                this.body="";
            },
            (error) => console.log(error)
        );
    }
    trackByIndex(index: number, value: number) {
        return index;
    }
      
}
