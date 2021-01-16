package com.example.W1790272.api;

//importing - package  from project
import com.example.W1790272.model.FootballClub;

//importing - package  from project
import com.example.W1790272.model.Match;

//importing - package  from project
import com.example.W1790272.service.PremierLeagueManager;

//importing - package  - springboot
import org.springframework.web.bind.annotation.*;

//importing - package
import org.springframework.web.bind.annotation.RequestMapping;

//importing - package
import org.springframework.web.bind.annotation.RestController;

//importing - package
import java.util.List;

// requesting mapping api manager - mapping
@RequestMapping("/api/manager")

// rest controller - assign
@RestController
// class assign
public class PremierLeagueManagerController {

    PremierLeagueManager objectForApi = new PremierLeagueManager();

    // requesting mapping api manager - mapping sports
    @GetMapping("/sports/wins")

    // get list by wins
    public  List<FootballClub> getListOfAddedSportsClubsForTheListSortWithWins(){
        //return list
        return PremierLeagueManager.getListOfAddedSportsClubsForTheListSortWithWins();
    }

    // requesting mapping api manager - mapping points
    @GetMapping("/sports/points")
    public  List<FootballClub> getListOfAddedSportsClubsForTheListSortWithPoints(){
        //return list
        return PremierLeagueManager.getListOfAddedSportsClubsForTheListSortWithPoints();
    }

    // requesting mapping api manager - mapping goals
    @GetMapping("/sports/goals")

    // get list by goals
    public  List<FootballClub> getListOfAddedSportsClubsForTheListSortWithGoals(){
        //return list
        return PremierLeagueManager.getListOfAddedSportsClubsForTheListSortWithGoals();
    }

    // requesting mapping api manager - mapping matches
    @GetMapping("/sports/match")

    // get list by matches
    public  List<Match>  getListOfAddedMatchesToTheSystem(){
        //return list
        return PremierLeagueManager.getListOfAddedMatchesToTheSystem();
    }

    // requesting mapping api manager - mapping generate
    @GetMapping("/sports/generate")
    public  List<FootballClub>  getGenerateAutoMatchDateAndScoreAndNameByButtonForWeb(){
        //return list
        objectForApi.generateAutoMatchDateAndScoreAndNameByButton();
        //return list
       return PremierLeagueManager.listOfAddedSportsClubsForTheList;
    }

    // requesting mapping api manager - mapping search
    @GetMapping("/sports/search/{dateOfTheMatchForSearchOfWeb}")
    //return list
    // get list by search
    public List<Match> getSearchForWebSearch(@PathVariable("dateOfTheMatchForSearchOfWeb") String dateOfTheMatchForSearchOfWeb){

        //return list
        return PremierLeagueManager.searchByGettingDateOfMatch(dateOfTheMatchForSearchOfWeb);
    }


}
