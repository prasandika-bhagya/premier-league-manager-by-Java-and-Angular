package com.example.W1790272.model;
//SchoolFootBallClub class

//importing - java pack
import java.io.Serializable;

//importing - java pack
import java.util.Objects;

public class SchoolFootBallClub extends FootballClub implements Serializable {

    //creating variables for SchoolFootBallClub
    private String nameOfTheSchool;

    //constructor of the SchoolFootBallClub
    public SchoolFootBallClub(String nameOfSportsClub, String locationOfSportsClub, int countedNumberOfWins, int countedNumberOfDraws, int countedNumberOfDefeats, int numberOfTheGoalsScored, int goalCountReceived, int numberOfGoalDifferenceRecorded, int numberOfPointsAchieved, int numberOfMatchesWhichPlayed, String takingDate, String nameOfTheSchool) {
       //super class
        super(nameOfSportsClub, locationOfSportsClub, countedNumberOfWins, countedNumberOfDraws, countedNumberOfDefeats, numberOfTheGoalsScored, goalCountReceived, numberOfGoalDifferenceRecorded, numberOfPointsAchieved, numberOfMatchesWhichPlayed, takingDate);
        this.nameOfTheSchool = nameOfTheSchool;
    }

    //getters and setters for name of the school
    public String getNameOfTheSchool() {
        //return values
        return nameOfTheSchool;
    }

    //set
    public void setNameOfTheSchool(String nameOfTheSchool) {
        this.nameOfTheSchool = nameOfTheSchool;
    }

    @Override
    public boolean equals(Object objForSchool) {
        //check by if
        if (this == objForSchool)
            //return true value
            return true;
        if (objForSchool == null || getClass() != objForSchool.getClass()) return false;
        if (!super.equals(objForSchool))
            //return false value
            return false;
        SchoolFootBallClub that = (SchoolFootBallClub) objForSchool;

       //retuning
        return Objects.equals(nameOfTheSchool, that.nameOfTheSchool);
    }

    //hashcode of the SchoolFootBallClub
    @Override
    //hashcode
    public int hashCode() {
        //returning hashcode
        return Objects.hash(super.hashCode(), nameOfTheSchool);
    }
}
