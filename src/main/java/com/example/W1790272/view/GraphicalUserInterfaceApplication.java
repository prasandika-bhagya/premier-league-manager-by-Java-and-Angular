package com.example.W1790272.view;
//GraphicalUserInterfaceApplication class

//importing - package
import com.example.W1790272.ConsoleApplication;
//importing - package
import com.example.W1790272.model.Match;
//importing - package
import com.example.W1790272.model.SportsClub;
//importing - package
import com.example.W1790272.service.PremierLeagueManager;

//importing - java pac
import javafx.application.Application;
//importing - java pac
import javafx.collections.FXCollections;
//importing - java pac
import javafx.collections.ObservableList;
//importing - java pac
import javafx.scene.Scene;
//importing - java pac
import javafx.scene.control.*;

//importing - java pac
import javafx.scene.control.cell.PropertyValueFactory;
//importing - java pac
import javafx.scene.image.Image;
//importing - java pac
import javafx.scene.image.ImageView;
//importing - java pac
import javafx.scene.layout.Pane;

//importing - java pac
import javafx.scene.text.Font;
//importing - java pac
import javafx.scene.text.FontWeight;
//importing - java pac
import javafx.stage.Stage;

import java.util.List;

public class GraphicalUserInterfaceApplication extends Application {
    //object of gui
    PremierLeagueManager objectForGui = new PremierLeagueManager();

    //list for gui
    List<Match> matchForGui;

    //table view of gui - match
    TableView<Match> tableOfTheMatchDetails;

    //table view of gui - club
    TableView<SportsClub> tableOfTheClubDetails;

    //gui method
    public static void main(String[] args) {
        launch(args);
    }

    //overriding
    @Override
    public void start(Stage primaryStageOfThePlSystem){

        //----------------------------------------Main window---------------------------------------------------------//
        //creating new pane for the main window
        Pane paneForMainWindowOfPl = new Pane();
        //assigning image to the background
        Image loadingPageMainImage = new Image("file:main.png");
        //image view
        ImageView loadingPageDisplayingBgImage = new ImageView(loadingPageMainImage);
        //setting size of the main stage
        primaryStageOfThePlSystem.setScene(new Scene(paneForMainWindowOfPl, 950, 700));
        //setting name of the main window as "plm"
        primaryStageOfThePlSystem.setTitle("premier league manager");

        //----------------------search button--------------------------//
        //button of showing search
        Button mainMenuButtonForSearch = new Button("SEARCH");

        //placing button in the main window
        //x-axis
        mainMenuButtonForSearch.setLayoutX(350);
        //y-axis
        mainMenuButtonForSearch.setLayoutY(340);

        //setting length and width of the button - search
        //length
        mainMenuButtonForSearch.setPrefWidth(270);
        //width
        mainMenuButtonForSearch.setPrefHeight(50);

        //design of the menu button - search
        mainMenuButtonForSearch.setStyle("-fx-background-radius: 11; -fx-border-radius: 10;-fx-border-color:#6f7678 #9998a7 ;-fx-border-width: 9;-fx-font-weight: bold;");


        //----------------------list and sort button for club--------------------------//


        //button of showing sorting
        Button mainMenuButtonForSort = new Button("CLUB LIST");

        //placing button in the main window
        //x-axis
        mainMenuButtonForSort.setLayoutX(350);
        //y-axis
        mainMenuButtonForSort.setLayoutY(250);

        //setting length and width of the button - sort
        //length
        mainMenuButtonForSort.setPrefWidth(270);
        //width
        mainMenuButtonForSort.setPrefHeight(50);

        //design of the menu button - sort
        mainMenuButtonForSort.setStyle("-fx-background-radius: 11; -fx-border-radius: 10;-fx-border-color:#6f7678  #9998a7 ;-fx-border-width: 9;-fx-font-weight: bold;");

        //----------------------list and sort button for match--------------------------//


        //button of showing sort match list
        Button mainMenuButtonForSortOfTheMatchList = new Button("MATCH LIST");

        //placing sort match list in the main window
        //x-axis
        mainMenuButtonForSortOfTheMatchList.setLayoutX(350);
        //y-axis
        mainMenuButtonForSortOfTheMatchList.setLayoutY(430);

        //setting length and width of the button - sort match list
        //length
        mainMenuButtonForSortOfTheMatchList.setPrefWidth(270);
        //width
        mainMenuButtonForSortOfTheMatchList.setPrefHeight(50);

        //design of the menu button - sort match list
        mainMenuButtonForSortOfTheMatchList.setStyle("-fx-background-radius: 11; -fx-border-radius: 10;-fx-border-color:#6f7678  #9998a7 ;-fx-border-width: 9;-fx-font-weight: bold;");


        //event action button for math list--------------------------------------------------------------------------------
        mainMenuButtonForSortOfTheMatchList.setOnAction(eventA5 -> {
            //stage of the list window - matches list
            Stage stageOfTheListWindowMatches = new Stage();

            //pane of the list window - matches list
            Pane paneOfTheListWindowMatchesDisplay = new Pane();

            //assigning image to the background - matches list
            Image loadingPageListImageOfMatches = new Image("file:mtchlist.png");

            //image view of the list window - matches list
            ImageView loadingPageDisplayingBgImageOfMatches = new ImageView(loadingPageListImageOfMatches);

            //setting size of the list stage - matches list
            stageOfTheListWindowMatches.setScene(new Scene(paneOfTheListWindowMatchesDisplay, 950, 700));

            //setting name of the list window as "premier league manager - - matches list"
            stageOfTheListWindowMatches.setTitle("premier league manager - Match List");



            //table view of the data-premier league table match list--------------------------------------------------------------------------------------------------

            //table view for the premier league match list - column of club one name
            TableColumn<Match, String> columnDataForTheTableOfViewOfMatchList01 = new TableColumn<>("Club One");//member id
            //set width to 90
            columnDataForTheTableOfViewOfMatchList01.setMinWidth(150);
            //getting name of club 1
            columnDataForTheTableOfViewOfMatchList01.setCellValueFactory(new PropertyValueFactory<>("clubOneNameForTheMatchTable"));

            //table view for the premier league match list - column of club two name
            TableColumn<Match, String> columnDataForTheTableOfViewOfMatchList02 = new TableColumn<>("Club Two");//member id
            //set width to 90
            columnDataForTheTableOfViewOfMatchList02.setMinWidth(150);
            //getting name of club 2
            columnDataForTheTableOfViewOfMatchList02.setCellValueFactory(new PropertyValueFactory<>("clubTwoNameForTheMatchTable"));

            //table view for the premier league match list - column of club one score
            TableColumn<Match, String> columnDataForTheTableOfViewOfMatchList01Score = new TableColumn<>("Club One Score");//member id
            //set width to 90
            columnDataForTheTableOfViewOfMatchList01Score.setMinWidth(150);
            //getting score of club 1 of club
            columnDataForTheTableOfViewOfMatchList01Score.setCellValueFactory(new PropertyValueFactory<>("scoreOfTheClubOneForTheMatchTable"));

            //table view for the premier league match list - column of club two score
            TableColumn<Match, String> columnDataForTheTableOfViewOfMatchList02Score = new TableColumn<>("Club Two Score");//member id
            //set width to 90
            columnDataForTheTableOfViewOfMatchList02Score.setMinWidth(150);
            //getting score of club 2 of club
            columnDataForTheTableOfViewOfMatchList02Score.setCellValueFactory(new PropertyValueFactory<>("scoreOfTheClubTwoForTheMatchTable"));

            //table view for the premier league match list - column of match date
            TableColumn<Match, String> columnDataForTheTableOfViewOfMatchListDate = new TableColumn<>("Date");//member id
            //set width to 90
            columnDataForTheTableOfViewOfMatchListDate.setMinWidth(230);
            //getting date of match
            columnDataForTheTableOfViewOfMatchListDate.setCellValueFactory(new PropertyValueFactory<>("dateForTheMatch"));

            //table setting to the list of table -match details
            tableOfTheMatchDetails = new TableView<>();
            //table view of plm - match
            tableOfTheMatchDetails.setItems(addMatchesToTheTableViewOfPlm());


            //importing details and assigning them
            tableOfTheMatchDetails.getColumns().addAll(columnDataForTheTableOfViewOfMatchList01,columnDataForTheTableOfViewOfMatchList01Score,columnDataForTheTableOfViewOfMatchList02,columnDataForTheTableOfViewOfMatchList02Score,columnDataForTheTableOfViewOfMatchListDate);
            tableOfTheMatchDetails.setLayoutX(65);
            tableOfTheMatchDetails.setLayoutY(180);

            //sorting according to the date
            columnDataForTheTableOfViewOfMatchListDate.setSortType(TableColumn.SortType.ASCENDING);
            tableOfTheMatchDetails.getSortOrder().add(columnDataForTheTableOfViewOfMatchListDate);



            Button backButtonRedirectToTheMainWindowSecond = new Button("\uD83E\uDC78");

            //setting button place fo window
            backButtonRedirectToTheMainWindowSecond.setLayoutX(5);
            backButtonRedirectToTheMainWindowSecond.setLayoutY(5);


            //pre defined length and width
            backButtonRedirectToTheMainWindowSecond.setPrefWidth(60);
            backButtonRedirectToTheMainWindowSecond.setPrefHeight(60);
            backButtonRedirectToTheMainWindowSecond.setStyle("-fx-background-radius: 50; -fx-border-radius: 50;-fx-border-color: #226594    ;-fx-border-width: 5;-fx-font-weight: bold;");

            backButtonRedirectToTheMainWindowSecond.setOnAction(eventE1 -> {
                Stage goToMainStage = (Stage) backButtonRedirectToTheMainWindowSecond.getScene().getWindow();

                //closing this window
                goToMainStage.close();

                //showing primary stage
                primaryStageOfThePlSystem.show();
            });



            //adding table to the pane
            paneOfTheListWindowMatchesDisplay.getChildren().addAll(loadingPageDisplayingBgImageOfMatches);

            //adding image
            paneOfTheListWindowMatchesDisplay.getChildren().addAll(tableOfTheMatchDetails);

            //help
            paneOfTheListWindowMatchesDisplay.getChildren().addAll(backButtonRedirectToTheMainWindowSecond);


            //setting resizable off
            stageOfTheListWindowMatches.setResizable(false);
            //showing window - match list
            stageOfTheListWindowMatches.show();
            //closing main window - match list
            primaryStageOfThePlSystem.close();



        });





        //----------------------help button--------------------------//

        //button of help
        Button mainMenuButtonForHelpView = new Button("?");

        //placing button in the main window
        //x-axis
        mainMenuButtonForHelpView.setLayoutX(867);
        //y-axis
        mainMenuButtonForHelpView.setLayoutY(622);

        //setting length and width of the button - help
        //length
        mainMenuButtonForHelpView.setPrefWidth(50);
        //width
        mainMenuButtonForHelpView.setPrefHeight(50);

        //design of the menu button - help
        mainMenuButtonForHelpView.setStyle("-fx-background-radius: 50; -fx-border-radius: 50;-fx-border-color: #226594  ;-fx-border-width: 5;-fx-font-weight: bold; -fx-font:30px \"Times New Roman\";");


        //help button
        mainMenuButtonForHelpView.setOnAction(eventH1 -> {
            //stage of the Help window
            Stage stageOfTheHelpWindow = new Stage();

            //pane of the Help window
            Pane paneOfTheHelpWindow = new Pane();

            //assigning image to the background - Help
            Image loadingPageHelpImage = new Image("file:help.png");

            //image view of the Help window
            ImageView loadingPageDisplayingBgImageOfHelpWindow = new ImageView(loadingPageHelpImage);

            //setting size of the Help stage
            stageOfTheHelpWindow.setScene(new Scene(paneOfTheHelpWindow, 700, 500));

            //setting name of the Help window as "premier league manager - Help"
            stageOfTheHelpWindow.setTitle("premier league manager - Help");


            Label labelForHelpOfPlm = new Label("This section shows all the added clubs to the premier league management system. You can sort \nthe list according to the Wins, Points, and Goals by given buttons.\n\n\n\n\n\n\nYou can search for matches played on a certain day by this section. Type in the search box and \npress the search button to display results.\n\n\n\n\nAll the played matches between clubs are shown in this section. Dates are sorted according to \nthe ascending order.");
            labelForHelpOfPlm.setFont(Font.font("Helvetica", FontWeight.BOLD, 15));

            labelForHelpOfPlm.setLayoutY(120);
            labelForHelpOfPlm.setLayoutX(26);

            //help view - resizable off
            stageOfTheHelpWindow.setResizable(false);

            //showing window - help
            stageOfTheHelpWindow.show();

            paneOfTheHelpWindow.getChildren().addAll(loadingPageDisplayingBgImageOfHelpWindow);
            //adding  label to help
            paneOfTheHelpWindow.getChildren().addAll(labelForHelpOfPlm);



        });


        //----------------------------------------------------actions for the buttons------------------------------------------------------------------------------------------//

        //list button-action
        mainMenuButtonForSort.setOnAction(eventA1 -> {


            //stage of the list window
            Stage stageOfTheListWindow = new Stage();

            //pane of the list window
            Pane paneOfTheListWindow = new Pane();

            //assigning image to the background
            Image loadingPageListImage = new Image("file:secondWindow.png");

            //image view of the list window
            ImageView loadingPageDisplayingBgImageOfSecondWindow = new ImageView(loadingPageListImage);

            //setting size of the list stage
            stageOfTheListWindow.setScene(new Scene(paneOfTheListWindow, 950, 700));

            //setting name of the list window as "premier league manager - LIST"
            stageOfTheListWindow.setTitle("premier league manager - Club List");


            //table view of the data-premier league table--------------------------------------------------------------------------------------------------

  /*          //table view for the premier league - column of club rank
            TableColumn<SportsClub, String> columnDataForTheTableOfView01 = new TableColumn<>("Rank");//member id
            //set width to 90
            columnDataForTheTableOfView01.setMinWidth(90);
            //getting rank of club
            columnDataForTheTableOfView01.setCellValueFactory(new PropertyValueFactory<>("RankOfTheClub"));*/

            //table view for the premier league - column of club name
            TableColumn<SportsClub, String> columnDataForTheTableOfView2 = new TableColumn<>("Club Name");//member id
            //set width to 90
            columnDataForTheTableOfView2.setMinWidth(90);
            //getting name of club
            columnDataForTheTableOfView2.setCellValueFactory(new PropertyValueFactory<>("NameOfSportsClub"));

            //table view for the premier league - column of club matches played
            TableColumn<SportsClub, String> columnDataForTheTableOfView3 = new TableColumn<>("Matches");//member id
            //set width to 90
            columnDataForTheTableOfView3.setMinWidth(90);
            //getting matches played of club
            columnDataForTheTableOfView3.setCellValueFactory(new PropertyValueFactory<>("NumberOfMatchesWhichPlayed"));

            //table view for the premier league - wins
            TableColumn<SportsClub, String> columnDataForTheTableOfView4 = new TableColumn<>("Wins");//member id
            //set width to 90
            columnDataForTheTableOfView4.setMinWidth(90);
            //getting wins of club
            columnDataForTheTableOfView4.setCellValueFactory(new PropertyValueFactory<>("CountedNumberOfWins"));



            //table view for the premier league - column of club rank
            TableColumn<SportsClub, String> columnDataForTheTableOfView5 = new TableColumn<>("Draws");//member id
            //set width to 90
            columnDataForTheTableOfView5.setMinWidth(90);
            //getting draws of club
            columnDataForTheTableOfView5.setCellValueFactory(new PropertyValueFactory<>("CountedNumberOfDraws"));

            //table view for the premier league - column of club Defeats
            TableColumn<SportsClub, String> columnDataForTheTableOfView6 = new TableColumn<>("Defeats");//member id
            //set width to 90
            columnDataForTheTableOfView6.setMinWidth(90);
            //getting Defeats of club
            columnDataForTheTableOfView6.setCellValueFactory(new PropertyValueFactory<>("CountedNumberOfDefeats"));

            //table view for the premier league - column of club goals scored
            TableColumn<SportsClub, String> columnDataForTheTableOfView7 = new TableColumn<>("G Scored");//member id
            //set width to 90
            columnDataForTheTableOfView7.setMinWidth(90);
            //getting goals of club
            columnDataForTheTableOfView7.setCellValueFactory(new PropertyValueFactory<>("NumberOfTheGoalsScored"));

            //table view for the premier league - goals received
            TableColumn<SportsClub, String> columnDataForTheTableOfView8 = new TableColumn<>("G Received");//member id
            //set width to 90
            columnDataForTheTableOfView8.setMinWidth(90);
            //getting goals received of club
            columnDataForTheTableOfView8.setCellValueFactory(new PropertyValueFactory<>("GoalCountReceived"));

            //table view for the premier league - column of club goals difference
            TableColumn<SportsClub, String> columnDataForTheTableOfView9 = new TableColumn<>("Difference");//member id
            //set width to 90
            columnDataForTheTableOfView9.setMinWidth(90);
            //getting goals difference of club
            columnDataForTheTableOfView9.setCellValueFactory(new PropertyValueFactory<>("NumberOfGoalDifferenceRecorded"));

            //table view for the premier league - points
            TableColumn<SportsClub, String> columnDataForTheTableOfView10 = new TableColumn<>("Points");//member id
            //set width to 90
            columnDataForTheTableOfView10.setMinWidth(90);
            //getting points of club
            columnDataForTheTableOfView10.setCellValueFactory(new PropertyValueFactory<>("numberOfPointsAchieved"));

            //table setting to the list of table
            tableOfTheClubDetails = new TableView<>();
            //table view of plm
            tableOfTheClubDetails.setItems(addClubsToTheTableViewOfPlm());
            //importing details and assigning them
            tableOfTheClubDetails.getColumns().addAll(columnDataForTheTableOfView2, columnDataForTheTableOfView3, columnDataForTheTableOfView4, columnDataForTheTableOfView5,columnDataForTheTableOfView6,columnDataForTheTableOfView7,columnDataForTheTableOfView8,columnDataForTheTableOfView9,columnDataForTheTableOfView10);
            tableOfTheClubDetails.setLayoutX(68);
            tableOfTheClubDetails.setLayoutY(80);

            columnDataForTheTableOfView10.setSortType(TableColumn.SortType.DESCENDING);
            tableOfTheClubDetails.getSortOrder().add(columnDataForTheTableOfView10);


            //----------------------sort list by goals button--------------------------//

            //button of showing placing button in the main window
            Button sortingByGoalsButtonForList = new Button("SORT BY GOALS");

            //placing button in the main window
            //x-axis
            sortingByGoalsButtonForList.setLayoutX(50);
            //y-axis
            sortingByGoalsButtonForList.setLayoutY(628);

            //setting length and width of the button - placing button in the main window
            //length
            sortingByGoalsButtonForList.setPrefWidth(200);
            //width
            sortingByGoalsButtonForList.setPrefHeight(50);

            //design of the menu button - placing button in the main window
            sortingByGoalsButtonForList.setStyle("-fx-background-radius: 11; -fx-border-radius: 10;-fx-border-color:#6f7678 #226594  ;-fx-border-width: 9;-fx-font-weight: bold;");


            sortingByGoalsButtonForList.setOnAction(eventSG -> {

                tableOfTheClubDetails.setItems(addClubsToTheTableViewOfPlm());
                columnDataForTheTableOfView7.setSortType(TableColumn.SortType.DESCENDING);
                tableOfTheClubDetails.getSortOrder().add(columnDataForTheTableOfView7);

            });


            //----------------------sort list by wins button--------------------------//


            //button of showing sorting
            Button soringButtonForListByWins = new Button("SORT BY WINS");

            //placing button in the main window
            //x-axis
            soringButtonForListByWins.setLayoutX(700);
            //y-axis
            soringButtonForListByWins.setLayoutY(628);

            //setting length and width of the button - sort by wins
            //length
            soringButtonForListByWins.setPrefWidth(200);
            //width
            soringButtonForListByWins.setPrefHeight(50);

            //design of the menu button - sort by wins
            soringButtonForListByWins.setStyle("-fx-background-radius: 11; -fx-border-radius: 10;-fx-border-color:#6f7678 #226594  ;-fx-border-width: 9;-fx-font-weight: bold;");

            soringButtonForListByWins.setOnAction(eventSG -> {
                tableOfTheClubDetails.setItems(addClubsToTheTableViewOfPlm());
                columnDataForTheTableOfView4.setSortType(TableColumn.SortType.DESCENDING);
                tableOfTheClubDetails.getSortOrder().add(columnDataForTheTableOfView4);


            });
            //----------------------sort list by points button--------------------------//


            //button of showing sorting
            Button soringButtonForListByPoints = new Button("SORT BY POINTS");

            //placing button in the main window
            //x-axis
            soringButtonForListByPoints.setLayoutX(375);
            //y-axis
            soringButtonForListByPoints.setLayoutY(628);

            //setting length and width of the button - sort by points
            //length
            soringButtonForListByPoints.setPrefWidth(200);
            //width
            soringButtonForListByPoints.setPrefHeight(50);

            //design of the menu button - sort by points
            soringButtonForListByPoints.setStyle("-fx-background-radius: 11; -fx-border-radius: 10;-fx-border-color:#6f7678  #226594   ;-fx-border-width: 9;-fx-font-weight: bold;");

            //action event of the sort by points

            soringButtonForListByPoints.setOnAction(eventSG -> {
                tableOfTheClubDetails.setItems(addClubsToTheTableViewOfPlm());
                columnDataForTheTableOfView10.setSortType(TableColumn.SortType.DESCENDING);
                tableOfTheClubDetails.getSortOrder().add(columnDataForTheTableOfView10);

            });

            //club one name
            Label labelNameOfTheClub01 = new Label("Club 01 Name:");
            //properties of name 01
            labelNameOfTheClub01.setStyle("-fx-font-weight: bold;");
            //x and y axis properties
            labelNameOfTheClub01.setLayoutY(525);
            labelNameOfTheClub01.setLayoutX(55);

            //club two name
            Label labelNameOfTheClub02 = new Label("Club 02 Name:");
            //properties of name 02
            labelNameOfTheClub02.setStyle("-fx-font-weight: bold;");
            //x and y axis properties
            labelNameOfTheClub02.setLayoutY(575);
            labelNameOfTheClub02.setLayoutX(55);

            //club one name - get
            Label gettingNameLabelNameOfTheClub01 = new Label("");
            //properties of name 01
            gettingNameLabelNameOfTheClub01.setStyle("-fx-font-weight: bold;");
            //x and y axis properties
            gettingNameLabelNameOfTheClub01.setLayoutY(525);
            gettingNameLabelNameOfTheClub01.setLayoutX(170);

            //club two name  - get
            Label gettingNameLabelNameOfTheClub02 = new Label("");
            //properties of name 02
            gettingNameLabelNameOfTheClub02.setStyle("-fx-font-weight: bold;");
            //x and y axis properties
            gettingNameLabelNameOfTheClub02.setLayoutY(575);
            gettingNameLabelNameOfTheClub02.setLayoutX(170);

            //score labels--------------------------------------------------

            //club one score
            Label labelScoreOfTheClub01 = new Label("Club 01 Score:");
            //properties of score 01
            labelScoreOfTheClub01.setStyle("-fx-font-weight: bold;");
            //x and y axis properties
            labelScoreOfTheClub01.setLayoutY(525);
            labelScoreOfTheClub01.setLayoutX(700);

            //club two score
            Label labelScoreOfTheClub02 = new Label("Club 02 Score:");
            //properties of score 02
            labelScoreOfTheClub02.setStyle("-fx-font-weight: bold;");
            //x and y axis properties
            labelScoreOfTheClub02.setLayoutY(575);
            labelScoreOfTheClub02.setLayoutX(700);

            //club one score - get
            Label gettingScoreLabelNameOfTheClub01 = new Label("");
            //properties of name 01
            gettingScoreLabelNameOfTheClub01.setStyle("-fx-font-weight: bold;");
            //x and y axis properties
            gettingScoreLabelNameOfTheClub01.setLayoutY(525);
            gettingScoreLabelNameOfTheClub01.setLayoutX(810);

            //club two score  - get
            Label gettingScoreLabelNameOfTheClub02 = new Label("");
            //properties of score 02
            gettingScoreLabelNameOfTheClub02.setStyle("-fx-font-weight: bold;");
            //x and y axis properties
            gettingScoreLabelNameOfTheClub02.setLayoutY(575);
            gettingScoreLabelNameOfTheClub02.setLayoutX(810);

            //----------------------random match generate button--------------------------//

            //button of showing random match
            Button generateButtonForRandomMatch = new Button("RANDOM");

            //placing button in the main window
            //x-axis
            generateButtonForRandomMatch.setLayoutX(431);
            //y-axis
            generateButtonForRandomMatch.setLayoutY(512);

            //setting length and width of the button - random match
            //length
            generateButtonForRandomMatch.setPrefWidth(89);
            //width
            generateButtonForRandomMatch.setPrefHeight(89);

            //design of the menu button - random match
            generateButtonForRandomMatch.setStyle("-fx-background-radius: 80; -fx-border-radius: 80;-fx-border-color:#2b7c82;-fx-border-width: 0;-fx-font-weight: bold;");

            generateButtonForRandomMatch.setOnAction(eventSGGS -> {

                objectForGui.generateAutoMatchDateAndScoreAndNameByButton();
                tableOfTheClubDetails.setItems(addClubsToTheTableViewOfPlm());
                tableOfTheClubDetails.refresh();
                columnDataForTheTableOfView10.setSortType(TableColumn.SortType.DESCENDING);
                tableOfTheClubDetails.getSortOrder().add(columnDataForTheTableOfView10);

                gettingNameLabelNameOfTheClub01.setText(PremierLeagueManager.randomNameGeneratingForMatchCOne);
                gettingNameLabelNameOfTheClub02.setText(PremierLeagueManager.randomNameGeneratingForMatchCTwo);
                gettingScoreLabelNameOfTheClub01.setText(PremierLeagueManager.randomScoreGeneratingForMatchCOne);
                gettingScoreLabelNameOfTheClub02.setText(PremierLeagueManager.randomScoreGeneratingForMatchCTwo);


            });


            //setting resizable off
            stageOfTheListWindow.setResizable(false);
            //showing window - list
            stageOfTheListWindow.show();
            //closing main window
            primaryStageOfThePlSystem.close();
            //adding image to the pain- list


            Button backButtonRedirectToTheMainWindowThird = new Button("\uD83E\uDC78");

            //setting button place fo window
            backButtonRedirectToTheMainWindowThird.setLayoutX(5);
            backButtonRedirectToTheMainWindowThird.setLayoutY(5);


            //pre defined length and width
            backButtonRedirectToTheMainWindowThird.setPrefWidth(60);
            backButtonRedirectToTheMainWindowThird.setPrefHeight(60);
            backButtonRedirectToTheMainWindowThird.setStyle("-fx-background-radius: 50; -fx-border-radius: 50;-fx-border-color: #226594    ;-fx-border-width: 5;-fx-font-weight: bold;");

            backButtonRedirectToTheMainWindowThird.setOnAction(eventE16 -> {
                Stage goToMainStage = (Stage) backButtonRedirectToTheMainWindowThird.getScene().getWindow();

                //closing this window
                goToMainStage.close();

                //showing primary stage
                primaryStageOfThePlSystem.show();
            });


            paneOfTheListWindow.getChildren().addAll(loadingPageDisplayingBgImageOfSecondWindow);
            //adding  button to the pane- sort by goals
            paneOfTheListWindow.getChildren().addAll(sortingByGoalsButtonForList);
            //adding  button to the pane- sort by wins
            paneOfTheListWindow.getChildren().addAll(soringButtonForListByWins);
            //adding random match button to the pane
            paneOfTheListWindow.getChildren().addAll(generateButtonForRandomMatch);


            //adding label to the pane - club 01 name
            paneOfTheListWindow.getChildren().addAll(labelNameOfTheClub01);

            //adding label to the pane - club 02 name
            paneOfTheListWindow.getChildren().addAll(labelNameOfTheClub02);

            //adding label to the pane - get club 01 name
            paneOfTheListWindow.getChildren().addAll(gettingNameLabelNameOfTheClub01);

            //adding label to the pane - get club 02 name
            paneOfTheListWindow.getChildren().addAll(gettingNameLabelNameOfTheClub02);


            //adding label to the pane - club 01 score
            paneOfTheListWindow.getChildren().addAll(labelScoreOfTheClub01);

            //adding label to the pane - club 02 score
            paneOfTheListWindow.getChildren().addAll(labelScoreOfTheClub02);

            //adding label to the pane - get club 01 score
            paneOfTheListWindow.getChildren().addAll(gettingScoreLabelNameOfTheClub01);

            //adding label to the pane - get club 02 score
            paneOfTheListWindow.getChildren().addAll(gettingScoreLabelNameOfTheClub02);


            paneOfTheListWindow.getChildren().addAll(tableOfTheClubDetails);


            //adding date sort button to the pane
            paneOfTheListWindow.getChildren().addAll(soringButtonForListByPoints);

            //help
            paneOfTheListWindow.getChildren().addAll(backButtonRedirectToTheMainWindowThird);


        });

//-------------------------------------------------------------------------------------------------------------------------------
        //Search button action
        mainMenuButtonForSearch.setOnAction(eventA1 -> {

            //stage of the search window
            Stage stageOfTheSearchWindow = new Stage();

            //pane of the search window
            Pane paneOfTheSearchWindow = new Pane();

            //assigning image to the background
            Image loadingPageListImage = new Image("file:Search.png");

            //image view of the search window
            ImageView loadingPageDisplayingBgImageOfThirdWindow = new ImageView(loadingPageListImage);

            //setting size of the search stage
            stageOfTheSearchWindow.setScene(new Scene(paneOfTheSearchWindow, 950, 700));

            //setting name of the search window as "premier league manager - search"
            stageOfTheSearchWindow.setTitle("premier league manager - Search");


            //table view of the search window--------------------------------------------------------------------------------------------------

            //table view of the search window - column of club one name
            TableColumn<Match, String> columnDataForSearchedValuesOfClubOneName = new TableColumn<>("Club One");//member id
            //set width to 225
            columnDataForSearchedValuesOfClubOneName.setMinWidth(225);
            //getting values
            columnDataForSearchedValuesOfClubOneName.setCellValueFactory(new PropertyValueFactory<>("clubOneNameForTheMatchTable"));

            //table view of the search window - column of club one score
            TableColumn<Match, String> columnDataForSearchedValuesOfClubOneScore= new TableColumn<>("Club One Score");//member id
            //set width to 225
            columnDataForSearchedValuesOfClubOneScore.setMinWidth(225);
            //getting values
            columnDataForSearchedValuesOfClubOneScore.setCellValueFactory(new PropertyValueFactory<>("scoreOfTheClubOneForTheMatchTable"));

            //table view of the search window - column of club one name
            TableColumn<Match, String> columnDataForSearchedValuesOfClubTwoName = new TableColumn<>("Club Two");//member id
            //set width to 225
            columnDataForSearchedValuesOfClubTwoName.setMinWidth(225);
            //getting values
            columnDataForSearchedValuesOfClubTwoName.setCellValueFactory(new PropertyValueFactory<>("clubTwoNameForTheMatchTable"));

            //table view of the search window - column of club one score
            TableColumn<Match, String> columnDataForSearchedValuesOfClubTwoScore= new TableColumn<>("Club Two Score");//member id
            //set width to 225
            columnDataForSearchedValuesOfClubTwoScore.setMinWidth(225);
            //getting values
            columnDataForSearchedValuesOfClubTwoScore.setCellValueFactory(new PropertyValueFactory<>("scoreOfTheClubTwoForTheMatchTable"));


            //table setting to the Search of the table
            TableView<Match> tableOfThSearchDetails = new TableView<>();
            //table view of plm

            //   tableOfThSearchDetails.setItems(addMatchesToTheTableViewOfPlmSearch());
            //importing details and assigning them
            tableOfThSearchDetails.getColumns().addAll(columnDataForSearchedValuesOfClubOneName, columnDataForSearchedValuesOfClubOneScore, columnDataForSearchedValuesOfClubTwoName, columnDataForSearchedValuesOfClubTwoScore);
            tableOfThSearchDetails.setLayoutX(28);
            tableOfThSearchDetails.setLayoutY(290);


            //search button for date search
            Button searchButtonForDateSearch = new Button("\uD83D\uDD0D");

            //setting button place fo window
            searchButtonForDateSearch.setLayoutX(646);
            searchButtonForDateSearch.setLayoutY(103);


            //pre defined length and width
            searchButtonForDateSearch.setPrefWidth(69);
            searchButtonForDateSearch.setPrefHeight(69);
            searchButtonForDateSearch.setStyle("-fx-background-radius: 5; -fx-border-radius: 5;-fx-border-color:white ;-fx-border-width: 0;-fx-font-weight: bold;");

            // text fields of search
            TextField textFieldForSearchByDate = new TextField();
            textFieldForSearchByDate.setLayoutY(103);
            textFieldForSearchByDate.setLayoutX(235);

            //properties of text field
            textFieldForSearchByDate.setFont(Font.font("Calibri", FontWeight.BOLD, 26));
            textFieldForSearchByDate.setPrefHeight(69);
            textFieldForSearchByDate.setPrefWidth(393);

            searchButtonForDateSearch.setOnAction(eventE31 -> {
                matchForGui=PremierLeagueManager.searchByGettingDateOfMatch(textFieldForSearchByDate.getText());
                tableOfThSearchDetails.setItems(addMatchesToTheTableViewOfPlmSearch(matchForGui));

            });

            Button backButtonRedirectToTheMainWindow = new Button("\uD83E\uDC78");

            //setting button place fo window
            backButtonRedirectToTheMainWindow.setLayoutX(5);
            backButtonRedirectToTheMainWindow.setLayoutY(5);


            //pre defined length and width
            backButtonRedirectToTheMainWindow.setPrefWidth(60);
            backButtonRedirectToTheMainWindow.setPrefHeight(60);
            backButtonRedirectToTheMainWindow.setStyle("-fx-background-radius: 50; -fx-border-radius: 50;-fx-border-color: #226594    ;-fx-border-width: 5;-fx-font-weight: bold;");

            backButtonRedirectToTheMainWindow.setOnAction(eventE1 -> {
                Stage goToMainStage = (Stage) backButtonRedirectToTheMainWindow.getScene().getWindow();

                //closing this window
                goToMainStage.close();

                //showing primary stage
                primaryStageOfThePlSystem.show();
            });


            //setting resizable off
            stageOfTheSearchWindow.setResizable(false);

            //showing window - Search
            stageOfTheSearchWindow.show();

            //closing main window
            primaryStageOfThePlSystem.close();

            paneOfTheSearchWindow.getChildren().addAll(loadingPageDisplayingBgImageOfThirdWindow);
            //adding textfield

            //search table
            paneOfTheSearchWindow.getChildren().addAll(tableOfThSearchDetails);

            paneOfTheSearchWindow.getChildren().addAll(textFieldForSearchByDate);
            //search button
            paneOfTheSearchWindow.getChildren().addAll(searchButtonForDateSearch);
            //back button
            paneOfTheSearchWindow.getChildren().addAll(backButtonRedirectToTheMainWindow);


        });

        //setting resizable off
        primaryStageOfThePlSystem.setResizable(false);
        //showing window
        primaryStageOfThePlSystem.show();
        //adding image to the pain
        paneForMainWindowOfPl.getChildren().addAll(loadingPageDisplayingBgImage);
        //adding search button to the pane
        paneForMainWindowOfPl.getChildren().addAll(mainMenuButtonForSearch);
        //adding sort button to the pane
        paneForMainWindowOfPl.getChildren().addAll(mainMenuButtonForSort);
        //adding help button to the pane
        paneForMainWindowOfPl.getChildren().addAll(mainMenuButtonForHelpView);
        //button for list and sort of matches
        paneForMainWindowOfPl.getChildren().addAll(mainMenuButtonForSortOfTheMatchList);

        //------------------------------------end of the main window--------------------------------------------------//

    }
    //observable list for club
    public ObservableList<SportsClub> addClubsToTheTableViewOfPlm(){
        //return
        return FXCollections.observableArrayList(ConsoleApplication.controllerSystem.listOfAddedSportsClubsForTheList);
    }
    //observable list for matches
    public ObservableList<Match> addMatchesToTheTableViewOfPlm(){
        //return
        return FXCollections.observableArrayList(PremierLeagueManager.listOfAddedMatchesToTheSystem);
    }

    //observable list for search
    public ObservableList<Match> addMatchesToTheTableViewOfPlmSearch(List<Match> listForSearchInGui){
        //return
        return FXCollections.observableArrayList(listForSearchInGui);
    }
}
