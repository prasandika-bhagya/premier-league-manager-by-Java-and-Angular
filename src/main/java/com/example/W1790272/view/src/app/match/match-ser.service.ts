import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Matchh } from './Matchh';

@Injectable({
  providedIn: 'root'
})

export class MatchSerService {

  private thisForUrl="http://localhost:8080/api/manager/sports/match"
  constructor(private HttpClient:HttpClient) { }

  getListOfMatch():Observable<Matchh[]>{
    return this.HttpClient.get<Matchh[]>(`${this.thisForUrl}`);
  }

 getMatchByDate(dateOfTheMatchForSearchOfWeb):Observable<Matchh[]>{
  return this.HttpClient.get<Matchh[]>("http://localhost:8080/api/manager/sports/search/"+dateOfTheMatchForSearchOfWeb)
}
}
