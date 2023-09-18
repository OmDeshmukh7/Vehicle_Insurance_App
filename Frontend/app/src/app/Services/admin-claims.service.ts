import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminClaimsService {

  constructor(private httpClient: HttpClient) {
  }
  getAllClaims(): Observable<any> {
    return this.httpClient.get('http://localhost:8080/Claims/',{responseType:'json'});
}
}
