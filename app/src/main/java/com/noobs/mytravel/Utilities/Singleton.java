package com.noobs.mytravel.Utilities;

import android.content.Context;
import android.database.SQLException;
import android.util.Log;

import com.noobs.mytravel.Models.City;
import com.noobs.mytravel.Models.Country;
import com.noobs.mytravel.Models.Sight;

import java.io.IOException;
import java.util.ArrayList;

public class Singleton {

    private static volatile Singleton instance;
    private Country selectedCountry;
    private City selectedCity;
    private Sight selectedSight;


    private Singleton() {
        if (instance != null) {
            throw new RuntimeException("Please use get instance to get the single instance of the class");
        }
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }

    public void setSelectedCountry(Country selectedCountry) {
        this.selectedCountry = selectedCountry;
    }

    public Country getSelectedCountry() {
        return selectedCountry;
    }

    public static void setInstance(Singleton instance) {
        Singleton.instance = instance;
    }

    public City getSelectedCity() {
        return selectedCity;
    }

    public void setSelectedCity(City selectedCity) {
        this.selectedCity = selectedCity;
    }

    public Sight getSelectedSight() {
        return selectedSight;
    }

    public void setSelectedSight(Sight selectedSight) {
        this.selectedSight = selectedSight;
    }

    public ArrayList<Country> getCountries(Context context) {
        ArrayList<Country> countries = new ArrayList<>();

        DataBaseHelper myDbHelperer;
        myDbHelperer = new DataBaseHelper(context);


        try {
            myDbHelperer.createDataBase();
        } catch (IOException ioe) {

            throw new Error("Unable to create database");

        }

        //// Opening Database the Instance that creates and accessing Menu Data
        try {
            myDbHelperer.openDataBase();
            countries = myDbHelperer.getCountries();

        } catch (SQLException sqle) {

            throw sqle;
        }

        //// Closing the Database to prevent memory Leakage
        try {
            myDbHelperer.close();
        } catch (Exception e) {
            Log.e("DATABASE STATE", "NOT_CLOSED");
        }

        return countries;
    }

    public ArrayList<City> getCities(Context context) {

        if (selectedCountry == null) {
            return null;
        }

        ArrayList<City> countries = new ArrayList<>();

        DataBaseHelper myDbHelperer;
        myDbHelperer = new DataBaseHelper(context);


        try {
            myDbHelperer.createDataBase();
        } catch (IOException ioe) {

            throw new Error("Unable to create database");

        }

        //// Opening Database the Instance that creates and accessing Menu Data
        try {
            myDbHelperer.openDataBase();
            countries = myDbHelperer.getCitiesForCountry(selectedCountry.getId());

        } catch (SQLException sqle) {

            throw sqle;
        }

        //// Closing the Database to prevent memory Leakage
        try {
            myDbHelperer.close();
        } catch (Exception e) {
            Log.e("DATABASE STATE", "NOT_CLOSED");
        }

        return countries;
    }

    public ArrayList<Sight> getSights(Context context) {

        if (selectedCity == null) {
            return null;
        }

        ArrayList<Sight> countries = new ArrayList<>();

        DataBaseHelper myDbHelperer;
        myDbHelperer = new DataBaseHelper(context);


        try {
            myDbHelperer.createDataBase();
        } catch (IOException ioe) {

            throw new Error("Unable to create database");

        }

        //// Opening Database the Instance that creates and accessing Menu Data
        try {
            myDbHelperer.openDataBase();
            countries = myDbHelperer.getSightsForCity(selectedCity.getId());

        } catch (SQLException sqle) {

            throw sqle;
        }

        //// Closing the Database to prevent memory Leakage
        try {
            myDbHelperer.close();
        } catch (Exception e) {
            Log.e("DATABASE STATE", "NOT_CLOSED");
        }

        return countries;
    }
}
