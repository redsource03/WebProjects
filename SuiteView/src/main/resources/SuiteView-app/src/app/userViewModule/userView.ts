import { Component,OnInit, Input  } from '@angular/core';


@Component({
    selector: 'userView',
  templateUrl: './userView.html',
  styleUrls: ['./userView.css'],
})
export class UserViewComponent {
    @Input() user:any;
}
