import { Clubb } from './Clubb';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ClubserService {

  private thisForUrlC="http://localhost:8080/api/manager/sports/points"
  constructor(private HttpClient:HttpClient) { }

  private thisForUrlCWins="http://localhost:8080/api/manager/sports/wins"

  private thisForUrlGenerate="http://localhost:8080/api/manager/sports/generate"

  private thisForUrlGoal="http://localhost:8080/api/manager/sports/goals"

  getListOfClub():Observable<Clubb[]>{
    return this.HttpClient.get<Clubb[]>(`${this.thisForUrlC}`);
  }

  getListOfClubForWin():Observable<Clubb[]>{
    return this.HttpClient.get<Clubb[]>(`${this.thisForUrlCWins}`);
  }

  getListOfClubForGenerate():Observable<Clubb[]>{
    return this.HttpClient.get<Clubb[]>(`${this.thisForUrlGenerate}`);
  }

  getListOfClubForGoal():Observable<Clubb[]>{
    return this.HttpClient.get<Clubb[]>(`${this.thisForUrlGoal}`);
  }


}
