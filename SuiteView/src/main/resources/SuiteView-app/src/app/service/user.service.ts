import {Http, Response} from "@angular/http";
import "rxjs/Rx";
import { Injectable} from "@angular/core";
import { Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
@Injectable()
export class UserService{
    constructor(private http: Http) {}

    public addUser(userJson:string){
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.post('/api/addUser', userJson, options)
                   .map( (response: Response) => {
                    return response.json();
                });
    }
    public updateUser(userJson:string){
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.post('/api/updateUser', userJson, options)
                   .map( (response: Response) => {
                    return response.json();
                });
    }
    public searchUser(userJson:string){
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.post('/api/userSearch', userJson, options)
                   .map( (response: Response) => {
                    return response.json();
                });
    }
    public removeCameraFromUser(username:string,cameraname:string){
        let json:string;
        json="{\"username\":\""+username+"\","+"\"cameraname\":"+"\""+cameraname+"\"}";
        
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.post('/api/removeCameraUser', json, options)
                   .map( (response: Response) => {
                    return response.json();
                });
    }
    public addCameraToUser(username:string,cameraname:string){
        let json:string;
        json="{\"username\":\""+username+"\","+"\"cameraname\":"+"\""+cameraname+"\"}";
        
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.post('/api/addCameraUser', json, options)
                   .map( (response: Response) => {
                    return response.json();
                });
    }
}