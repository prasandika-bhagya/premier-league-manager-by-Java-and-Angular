package com.example.W1790272.model;
//Match class

//importing - java pac
import java.io.Serializable;

//class match
public class Match implements Serializable {

    private static final long serialVersionUID = 1L;

    //club one name
    private String clubOneNameForTheMatchTable;

    //club two name
    private String clubTwoNameForTheMatchTable;

    //club one score
    private int scoreOfTheClubOneForTheMatchTable;

    //club two score
    private int scoreOfTheClubTwoForTheMatchTable;

    //date of the club
    private String dateForTheMatch;


    //match constructor
    public Match(String clubOneNameForTheMatchTable, String clubTwoNameForTheMatchTable,String dateForTheMatch, int scoreOfTheClubOneForTheMatchTable, int scoreOfTheClubTwoForTheMatchTable) {

        //club one name - match class
        this.clubOneNameForTheMatchTable = clubOneNameForTheMatchTable;

        //club two name - match class
        this.clubTwoNameForTheMatchTable = clubTwoNameForTheMatchTable;

        //club one score - match class
        this.scoreOfTheClubOneForTheMatchTable = scoreOfTheClubOneForTheMatchTable;

        //club two score - match class
        this.scoreOfTheClubTwoForTheMatchTable = scoreOfTheClubTwoForTheMatchTable;

        //match date
        this.dateForTheMatch = dateForTheMatch;
    }



    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    //getters and setters of clu one name
    public String getClubOneNameForTheMatchTable() {
        return clubOneNameForTheMatchTable;
    }

    //set
    public void setClubOneNameForTheMatchTable(String clubOneNameForTheMatchTable) {
        this.clubOneNameForTheMatchTable = clubOneNameForTheMatchTable;
    }

    //getters and setters of club two name
    public String getClubTwoNameForTheMatchTable() {
        return clubTwoNameForTheMatchTable;
    }

    //set
    public void setClubTwoNameForTheMatchTable(String clubTwoNameForTheMatchTable) {
        this.clubTwoNameForTheMatchTable = clubTwoNameForTheMatchTable;
    }

    //getters and setters of clu one score
    public int getScoreOfTheClubOneForTheMatchTable() {
        return scoreOfTheClubOneForTheMatchTable;
    }

    //set
    public void setScoreOfTheClubOneForTheMatchTable(int scoreOfTheClubOneForTheMatchTable) {
        this.scoreOfTheClubOneForTheMatchTable = scoreOfTheClubOneForTheMatchTable;
    }

    //getters and setters of clu two score
    public int getScoreOfTheClubTwoForTheMatchTable() {
        return scoreOfTheClubTwoForTheMatchTable;
    }

    //set
    public void setScoreOfTheClubTwoForTheMatchTable(int scoreOfTheClubTwoForTheMatchTable) {
        this.scoreOfTheClubTwoForTheMatchTable = scoreOfTheClubTwoForTheMatchTable;
    }

    //getters and setters of match date
    public String getDateForTheMatch() {
        return dateForTheMatch;
    }

    //set
    public void setDateForTheMatch(String dateForTheMatch) {
        this.dateForTheMatch = dateForTheMatch;
    }
}
