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
}