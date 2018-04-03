import { Component,Input } from '@angular/core';
import { ThreadService } from '../service/thread.service';
import {  BlockUI, NgBlockUI } from 'ng-block-ui';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
@Component({
    selector: 'createThread',
  templateUrl: './createThread.html',
  styleUrls: ['./createThread.css'],
})
export class CreateThreadComponent {
    subject:string;
    body:string;
    @Input() user:any;
    @BlockUI() blockUI: NgBlockUI;
    constructor(private threadService: ThreadService,private modalService: NgbModal) {}
    open(content) {
        this.modalService.open(content,{ size: 'lg' }).result.then((result) => {
      
        }, (reason) => {
          
        });
      }
    createThread(){
      this.blockUI.start("Sending Message");
      this.threadService.createThread(this.subject,this.body).subscribe(
        (model: any) => {
          this.blockUI.stop();
          this.blockUI.start("Message Sent");
   
          setTimeout(() => {
            this.blockUI.stop();
          }, 2000);
        },
        (error) => console.log(error)
    );
    }
}
