
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpModule} from '@angular/http';

import { EqualValidator } from './directive/equal-validator.directive'; 
import { AppComponent } from './app.component';
import { addUserComponent } from './addUserModule/addUser';
import {addCameraComponent} from './addCameraModule/addCamera';
import {editUserComponent} from './editUserModule/editUser';
import {ImageViewComponent}from './imageViewModule/imageView';
import {AdminViewComponent} from './adminViewModule/adminView';
import {UserViewComponent} from './userViewModule/userView';
import {ChangeProfileComponent} from './changeProfileModule/changeProfile';
import {CreateThreadComponent} from './createThreadModule/createThread'

import { FormsModule } from '@angular/forms';

import { UserService} from "./service/user.service";
import { CameraService} from './service/camera.service'
import { ImageService} from './service/image.service'
import { ThreadService} from './service/thread.service'

import { BlockUIModule } from 'ng-block-ui';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';


@NgModule({
  declarations: [
    AppComponent,addUserComponent,EqualValidator,addCameraComponent,editUserComponent,
    ImageViewComponent,AdminViewComponent,UserViewComponent,ChangeProfileComponent,
    CreateThreadComponent
  ],
  imports: [NgbModule.forRoot(),
    BrowserModule,
    FormsModule,
    HttpModule,
    BlockUIModule,
  ],
  providers: [UserService,CameraService,ImageService,ThreadService],
  bootstrap: [AppComponent]
})
export class AppModule { }
