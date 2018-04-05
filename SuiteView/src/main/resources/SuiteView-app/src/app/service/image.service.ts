import {Http, Response} from "@angular/http";
import "rxjs/Rx";
import { Injectable} from "@angular/core";
import { Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
@Injectable()
export class ImageService{
    constructor(private http: Http) {}
    public searchImage(cameraName:string, date:any, from:any, to:any){
        let infoJson:string;
        infoJson="{\"date\":\""+date.year+"-"+date.month+"-"+date.day+"\","+"\"cameraName\":"+"\""+cameraName+"\""
        +",\"fromHour\":"+"\""+from.hour+"\",\"fromMinute\":"+"\""+from.minute+"\","
        +"\"toHour\":"+"\""+to.hour+"\",\"toMinute\":"+"\""+to.minute+"\"}";
        
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.post('/api/searchImageByCDT', infoJson, options)
                   .map( (response: Response) => {
                    return response.json();
                });
    }
    public deleteImage(cameraName:string, date:string, objectKey:string){
        let infoJson:string;
        infoJson="{\"cameraName\":\""+cameraName+"\","+"\"date\":"+"\""+date+"\""
        +",\"objectKey\":"+"\""+objectKey+"\"}";
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.post('/api/deleteImage', infoJson, options)
                   .map( (response: Response) => {
                    return response.json();
                });
    }

    public deleteImageBefore(cameraName:string, date:string){
        let infoJson:string;
        infoJson="{\"cameraName\":\""+cameraName+"\","+"\"date\":"+"\""+date+"\""+"\"}";
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.post('/api/deleteImageBefore', infoJson, options)
                   .map( (response: Response) => {
                    return response.json();
                });
    }
}