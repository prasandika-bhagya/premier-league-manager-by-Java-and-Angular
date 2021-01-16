package com.example.W1790272.service;

//importing - package
import com.example.W1790272.model.FootballClub;
import com.example.W1790272.model.SportsClub;

//importing - java pack
import java.io.IOException;

public interface LeagueManager {


    //adding football club to the system
    void footBallClubAddingToTheSystem(FootballClub sportsClub);

    //deleting foot ball club
    void footBallClubDeletingFromTheSystem(String deleteClub);

    //displaying information table
    void displayingPremierLeagueTableInTheDisplay();

    //adding statistics to the system
    void addingStatisticsToTheDataBase(String nameOfTheClubOne, String nameOfTheClubTwo, int scoreOfFirstTeam, int scoreOfSecondTeam, String dateOfTheMatch);

    //saving data to the file - club
    void saveStatisticsDataToTheTextFile() throws IOException;

    //saving data to the file -match
    void saveStatisticsOfMatchDataToTheTextFile() throws IOException;

    //loading data from the file
    void loadStatisticsDataFromTheTextFilePreSaved() throws IOException,ClassNotFoundException;

    //loading data from the file - matches
    void loadStatisticsDataFromTheTextFilePreSavedForMatch() throws IOException,ClassNotFoundException;
}
