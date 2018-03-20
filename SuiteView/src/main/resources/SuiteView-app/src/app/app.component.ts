import { Component, Input,NgModule,OnInit } from '@angular/core';
import { UserService } from './service/user.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'SuiteView';
  user:any;
  constructor(private userService: UserService) {}
  ngOnInit() {
    this.userService.getCurrentUser().subscribe(
      (model: any) => {
        this.user=model;
      },
      (error) => console.log(error)
  );
    }
}
