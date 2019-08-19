package com.example.lostfoundapp.Activities.pojoUsers;

import java.io.Serializable;

public class CitiesPojo implements Serializable {

    private String cities;
    private String states;

    public String getCities() {
        return cities;
    }

    public void setCities(String cities) {
        this.cities = cities;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }

}
