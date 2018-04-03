import { Component,Input,OnInit } from '@angular/core';
import { ThreadService } from '../service/thread.service';
@Component({
    selector: 'threadList',
  templateUrl: './threadList.html',
  styleUrls: ['./threadList.css'],
})
export class ThreadListComponent implements OnInit {
    threadList:any;
    ngOnInit() {
        this.threadService.getUserThreads().subscribe(
            (model: any) => {
                this.threadList=model;
            },
            (error) => console.log(error)
        );
    }
    @Input() user:any;
    constructor(private threadService: ThreadService) {
        
    }
    trackByIndex(index: number, value: number) {
        return index;
    }
      
}

