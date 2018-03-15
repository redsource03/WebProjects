
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpModule} from '@angular/http';

import { EqualValidator } from './directive/equal-validator.directive'; 
import { AppComponent } from './app.component';
import { addUserComponent } from './addUserModule/addUser';
import {addCameraComponent} from './addCameraModule/addCamera';
import {editUserComponent} from './editUserModule/editUser';
import {ImageViewComponent}from './imageViewModule/imageView'
import { FormsModule } from '@angular/forms';

import { UserService} from "./service/user.service";
import { CameraService} from './service/camera.service'
import { ImageService} from './service/image.service'
import { BlockUIModule } from 'ng-block-ui';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';


@NgModule({
  declarations: [
    AppComponent,addUserComponent,EqualValidator,addCameraComponent,editUserComponent,ImageViewComponent
  ],
  imports: [NgbModule.forRoot(),
    BrowserModule,
    FormsModule,
    HttpModule,
    BlockUIModule,
    
  ],
  providers: [UserService,CameraService,ImageService],
  bootstrap: [AppComponent]
})
export class AppModule { }
