import {Http, Response} from "@angular/http";
import "rxjs/Rx";
import { Injectable} from "@angular/core";
import { Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
@Injectable()
export class ThreadService{
    constructor(private http: Http) {}

    public createThread(subject:string, content:string){
        let infoJson:string;
        infoJson="{\"subject\":\""+subject+"\","+"\"comment\":"+"\""+content+"\"}"
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.post('/api/createThread', infoJson, options)
                   .map( (response: Response) => {
                    return response.json();
                });
    }
    public getUserThreads(){
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.post('/api/getUserThread', options)
                   .map( (response: Response) => {
                    return response.json();
                });
    }
    public getThreadComment(threadKey:string){
        let infoJson:string;
        infoJson="{\"threadkey\":\""+threadKey+"\"}";
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.post('/api/getThreadComment',infoJson, options)
                   .map( (response: Response) => {
                    return response.json();
                });
    }
    public addThreadComment(threadKey:string,comment:string){
        let infoJson:string;
        infoJson="{\"threadkey\":\""+threadKey+"\","+"\"comment\":"+"\""+comment+"\"}"
        console.log(infoJson);
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.post('/api/createComment',infoJson, options)
                   .map( (response: Response) => {
                    return response.json();
                });
    }

}