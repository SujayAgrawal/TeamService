package com.sujay.TeamService.model;

public class Team {

    private String name;
    private int experienceInYears;

    public Team() {
    }

    public Team(String name, int experienceInYears) {
        this.name = name;
        this.experienceInYears = experienceInYears;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperienceInYears() {
        return experienceInYears;
    }

    public void setExperienceInYears(int experienceInYears) {
        this.experienceInYears = experienceInYears;
    }
}
