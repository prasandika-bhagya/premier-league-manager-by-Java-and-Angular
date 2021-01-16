package com.example.W1790272.model;
//SportsClub class


//importing - java pack
import java.io.Serializable;

//importing - java pack
import java.util.Objects;

public class SportsClub implements Serializable {

    //assigning variables for name and location of the club
    //name var
    private String nameOfSportsClub;
    //location var
    private String locationOfSportsClub;

    //constructor of the SportsClub class
    public SportsClub(String nameOfSportsClub, String locationOfSportsClub) {
        //constructor of the current class - name
        this.nameOfSportsClub = nameOfSportsClub;
        //constructor of the current class - location
        this.locationOfSportsClub = locationOfSportsClub;
        //end of constructor
    }

    //getters and setters - name
    public String getNameOfSportsClub() {
        //return
        return nameOfSportsClub;
    }

    //set name
    public void setNameOfSportsClub(String nameOfSportsClub) {
        this.nameOfSportsClub = nameOfSportsClub;
    }

    //getters and setters - location
    public String getLocationOfSportsClub() {
        //return
        return locationOfSportsClub;
    }

    //set
    public void setLocationOfSportsClub(String locationOfSportsClub) {
        this.locationOfSportsClub = locationOfSportsClub;
    }
    //end of get set


    //equals of the  SportsClub class
    @Override
    //equals
    public boolean equals(Object objChecking) {
        //if condition
        //checking
        if (this == objChecking)
            //return true
            return true;

        //checking
        if (objChecking == null || getClass() != objChecking.getClass())
            //return false
            return false;

        //checking
        SportsClub that = (SportsClub) objChecking;
        //return
        return Objects.equals(nameOfSportsClub, that.nameOfSportsClub) &&
                Objects.equals(locationOfSportsClub, that.locationOfSportsClub);
    }

    //hashcode of the SportsClub class
    @Override
    //hashcode of the current club
    public int hashCode() {
        //returning
        return Objects.hash(nameOfSportsClub, locationOfSportsClub);
        //return
    }
}
