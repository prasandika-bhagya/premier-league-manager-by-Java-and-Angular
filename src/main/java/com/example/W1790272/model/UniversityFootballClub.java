package com.example.W1790272.model;
//UniversityFootballClub class

//importing - java pack
import java.io.Serializable;
//importing - java pack
import java.util.Objects;

public class UniversityFootballClub extends FootballClub implements Serializable {

    //creating variables for the UniversityFootballClub
    private String nameOfTheUniversity;

    //constructor of the UniversityFootballClub

    public UniversityFootballClub(String nameOfSportsClub, String locationOfSportsClub, int countedNumberOfWins, int countedNumberOfDraws, int countedNumberOfDefeats, int numberOfTheGoalsScored, int goalCountReceived, int numberOfGoalDifferenceRecorded, int numberOfPointsAchieved, int numberOfMatchesWhichPlayed, String takingDate, String nameOfTheUniversity) {
        //superclass extracting
        super(nameOfSportsClub, locationOfSportsClub, countedNumberOfWins, countedNumberOfDraws, countedNumberOfDefeats, numberOfTheGoalsScored, goalCountReceived, numberOfGoalDifferenceRecorded, numberOfPointsAchieved, numberOfMatchesWhichPlayed, takingDate);
        this.nameOfTheUniversity = nameOfTheUniversity;
    }

    //getters and setters of the university name
    public String getNameOfTheUniversity() {
       //return value
        return nameOfTheUniversity;
    }

    //set
    public void setNameOfTheUniversity(String nameOfTheUniversity) {
        this.nameOfTheUniversity = nameOfTheUniversity;
    }

    //equals of the UniversityFootballClub
    @Override
    //equals
    public boolean equals(Object objForUni) {
        //checking by if
        if (this == objForUni)
            //return true
            return true;

        //checking
        if (objForUni == null || getClass() != objForUni.getClass()) return false;
        if (!super.equals(objForUni)) return false;
        UniversityFootballClub that = (UniversityFootballClub) objForUni;

        //retunr object equals
        return Objects.equals(nameOfTheUniversity, that.nameOfTheUniversity);
    }

    //hashcode of the UniversityFootballClub
    @Override
    public int hashCode() {
       //return of hashCode
        return Objects.hash(super.hashCode(), nameOfTheUniversity);
    }
}
