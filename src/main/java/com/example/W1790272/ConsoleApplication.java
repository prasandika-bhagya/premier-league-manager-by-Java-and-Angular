package com.example.W1790272;
//importing packages
import com.example.W1790272.model.FootballClub;
//importing packages
import com.example.W1790272.service.PremierLeagueManager;
//importing packages
import com.example.W1790272.view.GraphicalUserInterfaceApplication;
//importing packages
import javafx.application.Application;
//importing packages
import org.springframework.boot.SpringApplication;
//importing packages
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
//importing packages
import java.text.DateFormat;
//importing packages
import java.text.SimpleDateFormat;
//importing packages
import java.util.Date;
//importing packages
import java.util.Scanner;

@SpringBootApplication
public class ConsoleApplication {

    private static String nameOfClubForConsole;

    //console menu
    public static final PremierLeagueManager controllerSystem = new PremierLeagueManager();


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //loading data from text file
        controllerSystem.loadStatisticsDataFromTheTextFilePreSaved();

        //loading data from text file - 2
        controllerSystem.loadStatisticsDataFromTheTextFilePreSavedForMatch();


        //boolean value for recurring process
        boolean exitFromTheProgramme = true;

        //welcome message to the user
        System.out.println("\nWelcome To The Premier League Championship!");

        //importing live date and time from users local computer
        DateFormat currentDateAndTimeByYourPresentComputer = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        //getting date and time
        Date liveDateShowing = new Date();

        //showing live date and time to the user
        System.out.println("----------- " + currentDateAndTimeByYourPresentComputer.format(liveDateShowing) + "-----------");

        //main menu of the console
        while (exitFromTheProgramme) {

            //user commands
            System.out.println("\nINSTRUCTIONS *\n");

            //user command1
            System.out.println("\nPRESS [1] : Create a new Football club");
            //user command2
            System.out.println("\nPRESS [2] : Delete (Remove) club");
            //user command3
            System.out.println("\nPRESS [3] : Details of a selected club");
            //user command4
            System.out.println("\nPRESS [4] : Premier League Table");
            //user command5
            System.out.println("\nPRESS [5] : Add a played match");
            //user command6
            System.out.println("\nPRESS [6] : Launch GUI in Java FX");
            //user command7
            System.out.println("\nPRESS [7] : Launch GUI in Web (Angular)");
            //user command8
            System.out.println("\nPRESS [8] : Save data to a file");
            //user command9
            System.out.println("\nPRESS [9] : Help");
            //user command10
            System.out.println("\nPRESS [10] : Exit Programme\n");
            //user input
            System.out.print("Please enter your command : ");
            Scanner userInputByNumericCommand = new Scanner(System.in);

            try {
                int gettingInputFromTheUser = userInputByNumericCommand.nextInt();

                //run after getting user input as 01
                if (gettingInputFromTheUser == 1) {
                    footBallClubAddingToTheSystem();

                    //run after getting user input as 02
                } else if (gettingInputFromTheUser == 2) {
                    footBallClubDeletingFromTheSystem();

                    //run after getting user input as 03
                } else if (gettingInputFromTheUser == 3) {
                    clubDetailsSearchByName(nameOfClubForConsole);


                    //run after getting user input as 04
                } else if (gettingInputFromTheUser == 4) {
                    controllerSystem.displayingPremierLeagueTableInTheDisplay();

                    //run after getting user input as 05
                } else if (gettingInputFromTheUser == 5) {
                    addingStatisticsToTheDataBase();

                    //run after getting user input as 06
                } else if (gettingInputFromTheUser == 6) {
                    Application.launch(GraphicalUserInterfaceApplication.class, args);
                    //saving files
                    controllerSystem.saveStatisticsDataToTheTextFile();
                    controllerSystem.saveStatisticsOfMatchDataToTheTextFile();
                    exitFromTheProgramme=false;


                    //run after getting user input as 07
                } else if (gettingInputFromTheUser == 7) {
                    SpringApplication.run(ConsoleApplication.class, args);
                    //saving files
                    controllerSystem.saveStatisticsDataToTheTextFile();
                    controllerSystem.saveStatisticsOfMatchDataToTheTextFile();

                    //run after getting user input as 08
                } else if (gettingInputFromTheUser == 8) {
                    controllerSystem.saveStatisticsDataToTheTextFile();
                    controllerSystem.saveStatisticsOfMatchDataToTheTextFile();

                    //run after getting user input as 09
                } else if (gettingInputFromTheUser == 9) {
                    System.out.println("-Help-\n");
                    System.out.print("1. Please use only 1 / 2 / 3 / 4 / 5 / 6 / 7 / 8 / 9 / 10\n");
                    System.out.print("2. Press 9 to exit from the programme\n");

                    //exit after getting user input as 10
                }else if (gettingInputFromTheUser == 10) {

                    //exiting message
                    System.out.println("Thanks for using Premier League Manager . Have a nice day!");

                    //exiting from the programme
                    exitFromTheProgramme=false;

                } else {
                    //action for a wrong input
                    System.out.print("Sorry. Wrong input. Please enter a number from 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 2.\n");

                }
            } catch (Exception e) {
                System.out.print("Sorry. Wrong input. Please enter a valid input \n");
            }
        }
    }


    // ----------------------------------------------------------------------------------------------------------------------------------------------

    //searching club details
    public static void clubDetailsSearchByName(String nameOfClubForConsole){

        //scanner input
        Scanner userInputForSearch= new Scanner(System.in);
        //club name
        System.out.print("\nPlease enter the club name: ");
        ConsoleApplication.nameOfClubForConsole =userInputForSearch.next();

        controllerSystem.clubDetailsSearchByName(ConsoleApplication.nameOfClubForConsole);

    }

    // ----------------------------------------------------------------------------------------------------------------------------------------------

    //adding club to the system
    private static void footBallClubAddingToTheSystem(){
        //user input for the club adding process
        Scanner userInputForAddClubToTheDatabase = new Scanner(System.in);

        //getting club name
        System.out.print("\nPlease enter the name of the club: ");
        String nameOfSportsClub = userInputForAddClubToTheDatabase.next();

        System.out.println("\nSelect Club Type\n");
        System.out.println("PRESS [1] : School Club");
        System.out.println("PRESS [2] : University Club");


        String userCatogary = userInputForAddClubToTheDatabase.next();

        switch (userCatogary) {

            //case for 01 - select school
            case "1":
                System.out.println("Please Enter School Name: ");
                String userCatogarySchool = userInputForAddClubToTheDatabase.next();
                break;

            //case for 02 - select university
            case "2":
                System.out.println("Please Enter University Name:");
                String userCatogaryUniversity = userInputForAddClubToTheDatabase.next();
                break;

            default:
                //invalid output response
                System.out.println("Invalid Input");

        }


        //getting location
        System.out.print("Please enter the location of the club: ");
        String locationOfSportsClub = userInputForAddClubToTheDatabase.next();



        //assigning null to the sports club
        FootballClub sportsClub=null;

        //giving 0 as the default values
        sportsClub = new FootballClub(nameOfSportsClub,locationOfSportsClub,0,0,0,0,0,0,0,0,"");


        // sportsClub=new FootballClub(nameOfSportsClub,locationOfSportsClub,int goalCountReceived,int numberOfPointsAchieved);
        controllerSystem.footBallClubAddingToTheSystem(sportsClub);

    }

    // ----------------------------------------------------------------------------------------------------------------------------------------------

    //deleting club from the system
    private static void footBallClubDeletingFromTheSystem() {
        //instructions for delete a club
        System.out.println("\nYou can delete a club by entering club name.");

        //requesting club name by the user
        System.out.print("\nPlease enter the club name: ");
        Scanner userInputForDeleteClub = new Scanner(System.in);

        //getting user input
        String deleteClub = userInputForDeleteClub.next();
        controllerSystem.footBallClubDeletingFromTheSystem(deleteClub);
    }

// ----------------------------------------------------------------------------------------------------------------------------------------------

    //adding statistics to the system
    private static void addingStatisticsToTheDataBase(){
        Scanner userInputForAddMatchToTheDatabase = new Scanner(System.in);
        //getting name of the first club

        System.out.print("\nPlease enter the name of First Club : ");
        //requesting next

        String nameOfTheClubOne=userInputForAddMatchToTheDatabase.next();

        //name of the second club
        System.out.print("Please enter the name of Second Club : ");

        //requesting next
        String nameOfTheClubTwo=userInputForAddMatchToTheDatabase.next();

        //requesting score of the fist club by the user
        System.out.print("Please enter the score of the first club : ");

        //requesting next
        int scoreOfFirstTeam=userInputForAddMatchToTheDatabase.nextInt();

        //requesting score of the second club by the user
        System.out.print("Please enter the score of the second club : ");

        //requesting next
        int scoreOfSecondTeam=userInputForAddMatchToTheDatabase.nextInt();

        //requesting data by the user
        System.out.print("Please enter the date in YYYY-MM-DD format : ");

        String dateOfTheMatch=userInputForAddMatchToTheDatabase.next();

        //assigning values got by the user
        controllerSystem.addingStatisticsToTheDataBase(nameOfTheClubOne,nameOfTheClubTwo,scoreOfFirstTeam,scoreOfSecondTeam,dateOfTheMatch);
    }

    // ----------------------------------------------------------------------------------------------------------------------------------------------

}
