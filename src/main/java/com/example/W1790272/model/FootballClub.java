package com.example.W1790272.model;
//FootballClub class


//importing - java pack
import java.io.Serializable;
//importing - java pack
import java.util.Objects;

//class FootballClub
public class FootballClub extends SportsClub implements Comparable<FootballClub>,Serializable {

    //variables of the FootballClub
    private static final long serialVersionUID=1L;

    //goal count
    private int goalCountReceived;

    //point count
    private int numberOfPointsAchieved;

    //scored goals
    private int numberOfTheGoalsScored;

    //played matches
    private int numberOfMatchesWhichPlayed;

    //wins
    private int countedNumberOfWins;

    //defeats
    private int countedNumberOfDefeats;

    //draws
    private int countedNumberOfDraws;

    //differances
    private int numberOfGoalDifferenceRecorded;

    //date
    private String takingDate;


    //constructor of the FootballClub
    public FootballClub(String nameOfSportsClub, String locationOfSportsClub,int countedNumberOfWins, int countedNumberOfDraws, int countedNumberOfDefeats, int numberOfTheGoalsScored, int goalCountReceived, int numberOfGoalDifferenceRecorded,  int numberOfPointsAchieved, int numberOfMatchesWhichPlayed,String takingDate) {

        //super class
        super(nameOfSportsClub, locationOfSportsClub);

        //goal count
        this.goalCountReceived = goalCountReceived;

        //points archived
        this.numberOfPointsAchieved = numberOfPointsAchieved;

        //scored goals
        this.numberOfTheGoalsScored = numberOfTheGoalsScored;

        //matches played
        this.numberOfMatchesWhichPlayed = numberOfMatchesWhichPlayed;

        //wins - number
        this.countedNumberOfWins = countedNumberOfWins;

        //defeats - number
        this.countedNumberOfDefeats = countedNumberOfDefeats;

        //draws - number
        this.countedNumberOfDraws = countedNumberOfDraws;

        //goals differ - number
        this.numberOfGoalDifferenceRecorded = numberOfGoalDifferenceRecorded;

        //date - Year , month  , day
        this.takingDate = takingDate;
    }

    //get serial version
    public static long getSerialVersionUID() {
        //return value- football club
        return serialVersionUID;
    }

    //getters and setters  of goal count received
    public int getGoalCountReceived() {
        //return value- football club
        return goalCountReceived;
    }

    //set
    public void setGoalCountReceived(int goalCountReceived) {
      //assign value - football club
        this.goalCountReceived = goalCountReceived;
    }

    //getters and setters of points
    public int getNumberOfPointsAchieved() {
        //return value- football club
        return numberOfPointsAchieved;
    }

    //set
    public void setNumberOfPointsAchieved(int numberOfPointsAchieved) {
        this.numberOfPointsAchieved = numberOfPointsAchieved;
    }

    //getters and setters of scored goals
    public int getNumberOfTheGoalsScored() {
        //return value- football club
        return numberOfTheGoalsScored;
    }

    //set
    public void setNumberOfTheGoalsScored(int numberOfTheGoalsScored) {
        //assign values - football club
        this.numberOfTheGoalsScored = numberOfTheGoalsScored;
    }

    //getters and setters of match played
    public int getNumberOfMatchesWhichPlayed() {
        //return value - football club
        return numberOfMatchesWhichPlayed;
    }

    //set
    public void setNumberOfMatchesWhichPlayed(int numberOfMatchesWhichPlayed) {
        //assign values - football club
        this.numberOfMatchesWhichPlayed = numberOfMatchesWhichPlayed;
    }

    //getters and setters pf winnings
    public int getCountedNumberOfWins() {
        //return value - football club
        return countedNumberOfWins;
    }

    //set
    public void setCountedNumberOfWins(int countedNumberOfWins) {
        //assign values - football club
        this.countedNumberOfWins = countedNumberOfWins;
    }

    //getters and setters of defeats
    public int getCountedNumberOfDefeats() {
        //return value - football club
        return countedNumberOfDefeats;
    }

    //set
    public void setCountedNumberOfDefeats(int countedNumberOfDefeats) {
        //assign values - football club
        this.countedNumberOfDefeats = countedNumberOfDefeats;
    }

    //getters and setters of draws
    public int getCountedNumberOfDraws() {
        //return value - football club
        return countedNumberOfDraws;
    }

    //set
    public void setCountedNumberOfDraws(int countedNumberOfDraws) {
        //assign values - football club
        this.countedNumberOfDraws = countedNumberOfDraws;
    }

    //getters and setters of goal differ
    public int getNumberOfGoalDifferenceRecorded() {
        //return value - football club
        return numberOfGoalDifferenceRecorded;
    }

    //set
    public void setNumberOfGoalDifferenceRecorded(int numberOfGoalDifferenceRecorded) {
        //assign values - football club
        this.numberOfGoalDifferenceRecorded = numberOfGoalDifferenceRecorded;
    }

    //getters and setters of dates
    public String getTakingDate() {
        //return value - football club
        return takingDate;
    }

    //set
    public void setTakingDate(String takingDate) {
        //assign values - football club
        this.takingDate = takingDate;
    }


    //equals of the class FootballClub
    @Override
    //equals
    public boolean equals(Object objectForFbClub) {
        if (this == objectForFbClub)
            //return true
            return true;
        //if condition
        if (objectForFbClub == null || getClass() != objectForFbClub.getClass())
            //return false
            return false;
        //if condition
        if (!super.equals(objectForFbClub))
            //return false
            return false;
            //returning
        FootballClub that = (FootballClub) objectForFbClub;
        //no of goals
        return goalCountReceived == that.goalCountReceived &&

                //number of points
                numberOfPointsAchieved == that.numberOfPointsAchieved &&

                //no of goals
                numberOfTheGoalsScored == that.numberOfTheGoalsScored &&

                //no of matches
                numberOfMatchesWhichPlayed == that.numberOfMatchesWhichPlayed &&

                //no of wins
                countedNumberOfWins == that.countedNumberOfWins &&

                //no of defeats
                countedNumberOfDefeats == that.countedNumberOfDefeats &&

                //no of draws
                countedNumberOfDraws == that.countedNumberOfDraws &&

                //goal differences
                numberOfGoalDifferenceRecorded == that.numberOfGoalDifferenceRecorded &&

               //equals for date
                Objects.equals(takingDate, that.takingDate);
    }

    //hashcode of the class FootballClub
    @Override
    public int hashCode() {
        //hashcode
        return Objects.hash(super.hashCode(), goalCountReceived, numberOfPointsAchieved, numberOfTheGoalsScored, numberOfMatchesWhichPlayed, countedNumberOfWins, countedNumberOfDefeats, countedNumberOfDraws, numberOfGoalDifferenceRecorded, takingDate);
    }
    //end of hashcode


    //comparto function
    @Override
    public int compareTo(FootballClub footballClub) {

        //checking by if condition
        if(this.numberOfPointsAchieved==footballClub.numberOfPointsAchieved){
            if(this.numberOfTheGoalsScored>footballClub.numberOfTheGoalsScored){
                //return +1
                return +1;
            }else{

                //return -1
                return -1;
            }
        }else{
            if(this.numberOfPointsAchieved>footballClub.numberOfPointsAchieved){

                //returning +1
                return +1;
            }else {

                //returning -1
                return -1;
            }
        }
    }





}
