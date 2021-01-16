import { MatchSerService } from './match-ser.service';
import { Matchh } from './Matchh';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-match',
  templateUrl: './match.component.html',
  styleUrls: ['./match.component.css']
})
export class MatchComponent implements OnInit {

matchList:Matchh[];
matchSearch:String;
  constructor(private MatchSerService:MatchSerService) { }

  ngOnInit(): void {
    this.MatchSerService.getListOfMatch().subscribe(data=>{

      this.matchList=data;
      console.log(this.matchList);

    })
  }


  ngOnSearchMatch(): void {


    this.MatchSerService.getMatchByDate(this.matchSearch).subscribe(data=>{

    this.matchList=data;
      console.log(this.matchList);

    })

   console.log(this.matchSearch);
  }



}
