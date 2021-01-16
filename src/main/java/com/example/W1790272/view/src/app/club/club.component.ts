import { ClubserService } from './clubser.service';
import { Clubb } from './Clubb';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-club',
  templateUrl: './club.component.html',
  styleUrls: ['./club.component.css']
})
export class ClubComponent implements OnInit {

  clubList:Clubb[];

  constructor(private ClubserService:ClubserService) { }

  ngOnInit(): void {
    this.ClubserService.getListOfClub().subscribe(data=>{
      this.clubList=data;
      console.log(this.clubList)
    })
  }


  sortByWin(): void {
    this.ClubserService.getListOfClubForWin().subscribe(data=>{
      this.clubList=data;
      console.log(this.clubList)
    })
  }

  sortByGenerate(): void {
    this.ClubserService.getListOfClubForGenerate().subscribe(data=>{
      this.clubList=data;
      console.log(this.clubList)
    })
  }

  sortByGoals(): void {
    this.ClubserService.getListOfClubForGoal().subscribe(data=>{
      this.clubList=data;
      console.log(this.clubList)
    })
  }




}
