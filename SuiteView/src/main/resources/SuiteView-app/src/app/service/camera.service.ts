import {Http, Response} from "@angular/http";
import "rxjs/Rx";
import { Injectable} from "@angular/core";
import { Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
@Injectable()
export class CameraService{
    constructor(private http: Http) {}

    public addCamera(cameraJson:string){
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.post('/api/addCamera', cameraJson, options)
                   .map( (response: Response) => {
                    return response.json();
                });
    }
    public getAllCamera(){
        return this.http.get('/api/getAllCamera').map( (response: Response) => {
            return response.json();
        });
    }
}