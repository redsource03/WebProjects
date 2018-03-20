import { Component,Input } from '@angular/core';


@Component({
    selector: 'adminView',
  templateUrl: './adminView.html',
  styleUrls: ['./adminView.css'],
})
export class AdminViewComponent {
    @Input() user:any;
}
