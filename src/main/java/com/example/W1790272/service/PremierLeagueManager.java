package com.example.W1790272.service;

//importing - package
import com.example.W1790272.model.FootballClub;
//importing - package
import com.example.W1790272.model.Match;

//importing - package
import com.example.W1790272.model.SportsClub;

//importing - java springboot
import org.springframework.stereotype.Component;

//importing - java springboot
import org.springframework.web.bind.annotation.RestController;

//importing - java pack
import java.io.*;

//importing - java pack
import java.text.DateFormat;
//importing - java pack

import java.text.ParseException;
//importing - java pack
import java.text.SimpleDateFormat;

//importing - java pack
import java.time.LocalDate;
//importing - java pack
import java.util.*;

//component of spring
@Component

//Rest Controller of spring
@RestController
public class PremierLeagueManager implements LeagueManager {

    //assigning variables for the class

    //assign strings for value passes to the gui - labels
    public static String randomScoreGeneratingForMatchCOne;

    //assign strings for value passes to the gui - labels
    public static String randomScoreGeneratingForMatchCTwo;

    //assign strings for value passes to the gui - labels
    public static String randomNameGeneratingForMatchCOne;

    //assign strings for value passes to the gui - labels
    public static String randomNameGeneratingForMatchCTwo;

    //getting no of wins
    private int countOfWin;

    //getting no of draws
    private int countOfDraws;

    //getting no of points
    private int countOfPoints;

    //getting no of defeats
    private int countOfDefeats;

    //variable for saving text file
    File statisticsFileSaving=new File("statisticsFile.txt");

    //variable for saving text file
    File statisticsForMatchFileSaving=new File("statisticsFileForMatch.txt");

    //list for the data gaining by the user inputs
    public static List<FootballClub> listOfAddedSportsClubsForTheList = new ArrayList<>();

    //Alternative list for the data gaining by the user inputs
    public static List<Match> listOfAddedMatchesToTheSystem = new ArrayList<>();

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //adding club to the system - overriding
    @Override

    //add club to the system bu user command
    public void footBallClubAddingToTheSystem(FootballClub sportsClub) {

        //add club to the system bu user command
        //checking of availability of a club
        if (listOfAddedSportsClubsForTheList.contains(sportsClub)) {

            //message to the user about error of adding club
            System.out.println("Sorry. This club is already added to the system.Try again with a different name.");

        } else {
            //adding to the list
            listOfAddedSportsClubsForTheList.add(sportsClub);

            //added clum message to the user
            System.out.println("\n----------Added to the club----------");
        }
}


// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //deleting football club - overriding
    @Override

    //deleting existing club
    public void footBallClubDeletingFromTheSystem(String deleteClub) {

        //for  loop
        for (SportsClub sportsClub : listOfAddedSportsClubsForTheList) {

            //checking user input and existing clubs in the list
            if (sportsClub.getNameOfSportsClub().equals(deleteClub)) {

                //removing club
                listOfAddedSportsClubsForTheList.remove(sportsClub);

                //printing club removing massage
                System.out.println("----------"+deleteClub + " club is removed----------");

                //breaking the process
                break;
            }
        }
    }

    // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //displaying table to the user about statistics - override
    @Override

    //displaying table to the user about statistics
    public void displayingPremierLeagueTableInTheDisplay() {

        //reverse order
        listOfAddedSportsClubsForTheList.sort(Collections.reverseOrder());

        //creating the table

        //aligning the table

        //this part is referred and learnt from the site https://www.tutorialspoint.com/java-program-to-format-strings-into-table
        String alignOfTheTable = "%-15s|%-14s|%-6s|%-6s|%-6s|%-14s|%-14s|%-15s|%-6s|%n";
        //creating the table
        System.out.format("--------------------------------------------------------------------------------------------------------- %n");
        //table headings
        System.out.format("Club Name      |Played Matches|Wins  |Draws |Lost  |Goals Scored  |Goals Received|Goal Difference|Points|%n");
        //ending table
        System.out.format("--------------------------------------------------------------------------------------------------------- %n");

        for(SportsClub sportsClub:listOfAddedSportsClubsForTheList){

            System.out.format(alignOfTheTable,
                    sportsClub.getNameOfSportsClub(), //sports club name
                    ((FootballClub)sportsClub).getNumberOfMatchesWhichPlayed(), //matches
                    ((FootballClub) sportsClub).getCountedNumberOfWins(), //wins
                    ((FootballClub) sportsClub).getCountedNumberOfDraws(), //draws
                    ((FootballClub) sportsClub).getCountedNumberOfDefeats(), //defeats
                    ((FootballClub) sportsClub).getNumberOfTheGoalsScored(), //scored goals
                    ((FootballClub) sportsClub).getGoalCountReceived(), //recieved goals
                    ((FootballClub) sportsClub).getNumberOfGoalDifferenceRecorded(), //differ of goals
                    ((FootballClub) sportsClub).getNumberOfPointsAchieved()); //points
        }
        //closing the table
        System.out.format("---------------------------------------------------------------------------------------------------------");
    }


    // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    @Override
    public void addingStatisticsToTheDataBase(String nameOfTheClubOne, String nameOfTheClubTwo, int scoreOfFirstTeam, int scoreOfSecondTeam, String dateOfTheMatch) {
        //club one of playing matches
        //assign null
        FootballClub playingClubOneInTheMatch = null;

        //club two of playing matches
        //assign null
        FootballClub playingClubTwoInTheMatch =  null;

        //boolean false for one
        boolean playingClubOneNoted = false;

        //boolean false for two
        boolean playingClubTwoNoted = false;


        //for loop for list
        for (SportsClub footballClubForOne : listOfAddedSportsClubsForTheList) {

            //if condition to check equals
            if (footballClubForOne.getNameOfSportsClub().equals(nameOfTheClubOne)) {

                //passing true
                playingClubOneInTheMatch = (FootballClub) footballClubForOne;
                //true
                playingClubOneNoted = true;
                //end for loop
            }
            // exit for loop
        }
        //for loop for club two
        for (SportsClub footballClubForTwo : listOfAddedSportsClubsForTheList){

            //check equals of club two
            if(footballClubForTwo.getNameOfSportsClub().equals(nameOfTheClubTwo)) {
                //passing true for club two
                playingClubTwoInTheMatch = (FootballClub) footballClubForTwo;
                //true
                playingClubTwoNoted=true;
            }
            //exit for loop for club two
        }

        //if condition check
        if (playingClubOneNoted==true && playingClubTwoNoted==true) {
            //using try catch
            try {
                //assigning values by getters and setters to the match details
                //+1 for match details
                playingClubOneInTheMatch.setNumberOfMatchesWhichPlayed(playingClubOneInTheMatch.getNumberOfMatchesWhichPlayed() + 1);

                //+1 for match details
                playingClubTwoInTheMatch.setNumberOfMatchesWhichPlayed(playingClubTwoInTheMatch.getNumberOfMatchesWhichPlayed() + 1);

                //adding score - one
                playingClubOneInTheMatch.setNumberOfTheGoalsScored(playingClubOneInTheMatch.getNumberOfTheGoalsScored() + scoreOfFirstTeam);

                //adding score - two
                playingClubTwoInTheMatch.setNumberOfTheGoalsScored(playingClubTwoInTheMatch.getNumberOfTheGoalsScored() + scoreOfSecondTeam);

                //adding score - one
                playingClubOneInTheMatch.setGoalCountReceived(playingClubOneInTheMatch.getGoalCountReceived() + scoreOfSecondTeam);

                //adding score - two
                playingClubTwoInTheMatch.setGoalCountReceived(playingClubTwoInTheMatch.getGoalCountReceived() + scoreOfFirstTeam);

                //if condition for logic
                if (scoreOfFirstTeam > scoreOfSecondTeam) {
                    // if C1>C2

                    //points adding - 3
                    playingClubOneInTheMatch.setNumberOfPointsAchieved(playingClubOneInTheMatch.getNumberOfPointsAchieved() + 3);

                    //wins - 1
                    playingClubOneInTheMatch.setCountedNumberOfWins(playingClubOneInTheMatch.getCountedNumberOfWins() + 1);

                    //defeats add - 1
                    playingClubTwoInTheMatch.setCountedNumberOfDefeats(playingClubTwoInTheMatch.getCountedNumberOfDefeats() + 1);

                    //setting
                    playingClubOneInTheMatch.setNumberOfGoalDifferenceRecorded(playingClubOneInTheMatch.getNumberOfGoalDifferenceRecorded() + (scoreOfFirstTeam-scoreOfSecondTeam));

                    //setting
                    playingClubTwoInTheMatch.setNumberOfGoalDifferenceRecorded(playingClubTwoInTheMatch.getNumberOfGoalDifferenceRecorded() + (scoreOfFirstTeam-scoreOfSecondTeam));

                    //if condition
                } else if (scoreOfFirstTeam < scoreOfSecondTeam) {

                    //points by +3
                    playingClubTwoInTheMatch.setNumberOfPointsAchieved(playingClubTwoInTheMatch.getNumberOfPointsAchieved() + 3);

                    //points - 1
                    playingClubTwoInTheMatch.setCountedNumberOfWins(playingClubTwoInTheMatch.getCountedNumberOfWins() + 1);

                    //defeats - 1
                    playingClubOneInTheMatch.setCountedNumberOfDefeats(playingClubOneInTheMatch.getCountedNumberOfDefeats() + 1);

                    //setting
                    playingClubOneInTheMatch.setNumberOfGoalDifferenceRecorded(playingClubOneInTheMatch.getNumberOfGoalDifferenceRecorded() + (scoreOfSecondTeam-scoreOfFirstTeam));

                    //setting
                    playingClubTwoInTheMatch.setNumberOfGoalDifferenceRecorded(playingClubTwoInTheMatch.getNumberOfGoalDifferenceRecorded() + (scoreOfSecondTeam-scoreOfFirstTeam));

                    //if condtion for draws
                    //if C1==C2
                } else if (scoreOfFirstTeam == scoreOfSecondTeam) {

                    //adding 1 - point
                    playingClubOneInTheMatch.setNumberOfPointsAchieved(playingClubOneInTheMatch.getNumberOfPointsAchieved() + 1);

                    //adding 1 - point
                    playingClubTwoInTheMatch.setNumberOfPointsAchieved(playingClubTwoInTheMatch.getNumberOfPointsAchieved() + 1);

                    //adding 1 - draw
                    playingClubOneInTheMatch.setCountedNumberOfDraws(playingClubOneInTheMatch.getCountedNumberOfDraws() + 1);

                    //adding 1 - draw
                    playingClubTwoInTheMatch.setCountedNumberOfDraws(playingClubTwoInTheMatch.getCountedNumberOfDraws() + 1);
                }
                //exit loop
            }catch (Exception e) { }
            //catching
            //adding to the list
            listOfAddedMatchesToTheSystem.add(new Match(nameOfTheClubOne, nameOfTheClubTwo, dateOfTheMatch, scoreOfFirstTeam, scoreOfSecondTeam));
        }
    }

    // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //saving statistics to a text file - override
    @Override
    //saving statistics to a text file
    public void saveStatisticsDataToTheTextFile() throws IOException {

        //saving statistics to the file
        FileOutputStream statisticsSavingToATextFile = new FileOutputStream(statisticsFileSaving);

        //saving statistics to the file - creating new object
        ObjectOutputStream statisticsSavingObject = new ObjectOutputStream(statisticsSavingToATextFile);

        //for loop for saving
        for (SportsClub textFileOfStatisticsSavings : listOfAddedSportsClubsForTheList) {
            //writeobject statement
            statisticsSavingObject.writeObject(textFileOfStatisticsSavings);
        }
        //closing tags
        statisticsSavingObject.close();
        //closing tags
        statisticsSavingToATextFile.close();


    }

    // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //saving statistics of match to a text file - override
    @Override
    //saving statistics of match to a text file
    public void saveStatisticsOfMatchDataToTheTextFile() throws IOException {

        //creating a file
        FileOutputStream statisticsSavingForMatchToATextFile = new FileOutputStream(statisticsForMatchFileSaving);
        //new object
        ObjectOutputStream statisticsSavingObjectForMatch = new ObjectOutputStream(statisticsSavingForMatchToATextFile);

        //for loop
        for (Match textFileOfMatchStatisticsSavings : listOfAddedMatchesToTheSystem) {
            statisticsSavingObjectForMatch.writeObject(textFileOfMatchStatisticsSavings);
        }
        //closing tags
        statisticsSavingObjectForMatch.close();
        //closing tags
        statisticsSavingForMatchToATextFile.close();
}


    // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    //loading data from the text file - override
    @Override
    //loading data from the text file
    public void loadStatisticsDataFromTheTextFilePreSaved() throws IOException, ClassNotFoundException {

        try {
            //file
            FileInputStream statisticsLoadingFromATextFile = new FileInputStream(statisticsFileSaving);
            ObjectInputStream statisticsLoadingObject = new ObjectInputStream(statisticsLoadingFromATextFile);

            //for loop
            for (; ; ) {
                try {

                    FootballClub loadStatisticsToTheSystem = (FootballClub) statisticsLoadingObject.readObject();
                    listOfAddedSportsClubsForTheList.add(loadStatisticsToTheSystem);
                } catch (EOFException e) {
                    //breaking loop
                    break;
                }
            }
            //closing tags
            statisticsLoadingFromATextFile.close();
            statisticsLoadingObject.close();

        }catch (IOException ioException) {
            ioException.printStackTrace();
            return;
        }catch (ClassNotFoundException classNotFoundException){

            //class not found message
            System.out.println("Sorry. Class not found");
            return;
        }

    }

    // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //loading data from the text file - temporery array - override
    @Override
    //loading data from the text file - temporery array
    public void loadStatisticsDataFromTheTextFilePreSavedForMatch() throws IOException, ClassNotFoundException {


        try {
            //file
            FileInputStream statisticsLoadingFromATextFileForMatch = new FileInputStream(statisticsForMatchFileSaving);
            ObjectInputStream statisticsLoadingObjectForMatch = new ObjectInputStream(statisticsLoadingFromATextFileForMatch);

            //for loop
            for (; ; ) {
                try {

                    Match loadStatisticsToTheSystemForMatch = (Match) statisticsLoadingObjectForMatch.readObject();
                    listOfAddedMatchesToTheSystem.add(loadStatisticsToTheSystemForMatch);
                } catch (EOFException e) {
                    //breaking loop
                    break;
                }
            }
            //closing tags
            statisticsLoadingFromATextFileForMatch.close();
            statisticsLoadingObjectForMatch.close();

        }catch (IOException ioException) {
            ioException.printStackTrace();
            return;

        }catch (ClassNotFoundException classNotFoundException){

            //class not found message
            System.out.println("Sorry. Class not found");

            //retuning value
            return;
        }
    }



    // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    private static LocalDate generatingRandomYearForProgramme(int startingYearForTheProgramme, int endYearForTheProgramme){
        //generating day from giving range (1 to 28)
        int dayForTheSystemOfPlm = generatingRandomNumberForDateOfTheProgrammeByMathRandom(1, 28);

        //generating moth from given range (1 to 12)
        int monthForTheSystemOfPlm = generatingRandomNumberForDateOfTheProgrammeByMathRandom(1, 12);

        //generating year from the given range
        int yearForTheSystemOfPlm = generatingRandomNumberForDateOfTheProgrammeByMathRandom(startingYearForTheProgramme, endYearForTheProgramme);

        //returning year,month and the date
        return LocalDate.of(yearForTheSystemOfPlm, monthForTheSystemOfPlm, dayForTheSystemOfPlm);
    }


    // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    //generating random date
    private static int generatingRandomNumberForDateOfTheProgrammeByMathRandom(int startingNumberForDateOfTheSystem, int endingNumberForDateOfTheSystem) {

        //using math.random
        //returning value
        return startingNumberForDateOfTheSystem + (int) Math.round(Math.random() * (endingNumberForDateOfTheSystem - startingNumberForDateOfTheSystem));
    }


    // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //calling functions - method for all random generaters
    public void generateAutoMatchDateAndScoreAndNameByButton(){

        //creating object in the random class
        Random randomClassNameForProgramme = new Random();

        //getting club one name random from the list
        int randomIndexForTheClubOne= randomClassNameForProgramme.nextInt(listOfAddedSportsClubsForTheList.size());

        //getting club one name random from the list - club list
        String clubOneNameGetAsRandom = listOfAddedSportsClubsForTheList.get(randomIndexForTheClubOne).getNameOfSportsClub();

        //getting club two name random from the list
        int randomIndexForTheClubTwo= randomClassNameForProgramme.nextInt(listOfAddedSportsClubsForTheList.size());

        //getting club two name random from the list - club list
        String clubTwoNameGetAsRandom = listOfAddedSportsClubsForTheList.get(randomIndexForTheClubTwo).getNameOfSportsClub();

        //assigning max and min range for random score
        int maximumNumberForRangeOfMatch=20, minimumNumberForRangeOfMatch=1;

        //random number generating for club one
        int randomScoreGeneratingForMatchForClubOne = (int) (Math.random() * (maximumNumberForRangeOfMatch - minimumNumberForRangeOfMatch + 1) + minimumNumberForRangeOfMatch);

        //random number generating for club two
        int randomScoreGeneratingForMatchForClubTwo = (int) (Math.random() * (maximumNumberForRangeOfMatch - minimumNumberForRangeOfMatch + 1) + minimumNumberForRangeOfMatch);

        //random date generating - from 2015 to 2030
        LocalDate randomDateForProgramme = generatingRandomYearForProgramme(2015, 2030);

        //converting to the string value
        String  stringOfRandomDateForProgramme=String.valueOf(randomDateForProgramme);


        //passing values to the gui -extra lable
        randomScoreGeneratingForMatchCOne=String.valueOf(randomScoreGeneratingForMatchForClubOne);

        //passing values to the gui -extra lable
        randomScoreGeneratingForMatchCTwo=String.valueOf(randomScoreGeneratingForMatchForClubTwo);

        //passing values to the gui -extra lable
        randomNameGeneratingForMatchCOne=String.valueOf(clubOneNameGetAsRandom);

        //passing values to the gui -extra lable
        randomNameGeneratingForMatchCTwo=String.valueOf(clubTwoNameGetAsRandom);

        //if condition
        if (clubOneNameGetAsRandom==clubTwoNameGetAsRandom){

            //running method again
            generateAutoMatchDateAndScoreAndNameByButton();
        }
        else{
            //adding details to the list
            this.addingStatisticsToTheDataBase(clubOneNameGetAsRandom,clubTwoNameGetAsRandom,randomScoreGeneratingForMatchForClubOne,randomScoreGeneratingForMatchForClubTwo,stringOfRandomDateForProgramme);

        }

    }


    // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    //searching club by name
    public void clubDetailsSearchByName(String userInputNameOfTheConsole){
        if (listOfAddedSportsClubsForTheList.isEmpty()){
            //message for club not found error
            System.out.println("Sorry. No clubs found. Create a club first");
        }

        else{
            //for loop activate
            for(SportsClub sportsClubForThis:listOfAddedSportsClubsForTheList){
                //if condition
                if (sportsClubForThis.getNameOfSportsClub().equals(userInputNameOfTheConsole)){
                    //showing details
                    System.out.println("Your search results :\n");
                    //club name
                    System.out.println("Club Name : "+sportsClubForThis.getNameOfSportsClub());
                    //club location
                    System.out.println("Club Location : "+sportsClubForThis.getLocationOfSportsClub());
                    System.out.println("\n");

                    //breaking

                }
            }
        }
    }

    // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    //search match by data
    public static List<Match>  searchByGettingDateOfMatch(String dateForTheMatch) {

        //Alternative list for the data gaining by the user inputs
        List<Match> allMatchesGainListOfAddedMatchesToTheSystem = new ArrayList<>();

        //for loop
        for (Match match2 : listOfAddedMatchesToTheSystem) {

            //checking condition by if
            if(match2.getDateForTheMatch().equals(dateForTheMatch)){
                //adding
                allMatchesGainListOfAddedMatchesToTheSystem.add(match2);
            }
        }
        //return statement
        return allMatchesGainListOfAddedMatchesToTheSystem;
    }

    // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    //for springboot data gaining

    //sorted according to the wins
    public static List<FootballClub> getListOfAddedSportsClubsForTheListSortWithWins(){
        //collection . sort is used in here
       Collections.sort(listOfAddedSportsClubsForTheList, new Comparator<FootballClub>() {
           //overriding method
            @Override
            //comparing
            public int compare(FootballClub objectOneForFootBallClub, FootballClub objectTwoForFootBallClub) {
                //returning values
                return  objectTwoForFootBallClub.getCountedNumberOfWins()-objectOneForFootBallClub.getCountedNumberOfWins();
                //returned values
            }
        });
       //returning list
        return listOfAddedSportsClubsForTheList;
    }

    // -----------------

    //sorted according to the points
    public static List<FootballClub> getListOfAddedSportsClubsForTheListSortWithPoints(){
        //collection . sort is used in here
        Collections.sort(listOfAddedSportsClubsForTheList, new Comparator<FootballClub>() {
            //overriding method- points
            @Override
            //comparing - points
            public int compare(FootballClub objectOneForFootBallClubPoints, FootballClub objectTwoForFootBallClubPoints) {
                //returning values- points
                return  objectTwoForFootBallClubPoints.getNumberOfPointsAchieved()-objectOneForFootBallClubPoints.getNumberOfPointsAchieved();
                //returned values- points
            }
        });
        //returning list- points
        return listOfAddedSportsClubsForTheList;
    }

    // -----------------

    //sorted according to the goals (gets)
    public static List<FootballClub> getListOfAddedSportsClubsForTheListSortWithGoals(){
        //collection . sort is used in here
        Collections.sort(listOfAddedSportsClubsForTheList, new Comparator<FootballClub>() {
            //overriding method- goals (gets)
            @Override
            //comparing - goals (gets)
            public int compare(FootballClub objectOneForFootBallClubGoal, FootballClub objectTwoForFootBallClubGoal) {
                //returning values- goals (gets)
                return  objectTwoForFootBallClubGoal.getNumberOfTheGoalsScored()-objectOneForFootBallClubGoal.getNumberOfTheGoalsScored();
                //returned values- goals (gets)
            }
        });
        //returning list- goals (gets)
        return listOfAddedSportsClubsForTheList;
    }

    // -----------------

    //getting match list according to the date
    public static List<Match>  getListOfAddedMatchesToTheSystem(){
        //return list
        //sorting according to the ascending order
        //comparator method
        Collections.sort(listOfAddedMatchesToTheSystem, new Comparator<Match>() {
            //date format y-m-d
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            //comparing method
            public int compare(Match firstMatchInput, Match secondMatchInput) {
                //try catch
                try {
                    //return date
                    //comparing
                    return dateFormat.parse(firstMatchInput.getDateForTheMatch()).compareTo(dateFormat.parse(secondMatchInput.getDateForTheMatch()));
               //catch - exceptions
                } catch (ParseException e) {

                    //throw - argument
                    throw new IllegalArgumentException(e);
                    //end of try catch
                }
            }
        });
        //returning the list of matches
        return listOfAddedMatchesToTheSystem;
    }
    // -----------------





























}
