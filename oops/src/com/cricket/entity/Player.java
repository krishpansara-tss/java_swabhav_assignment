package com.cricket.entity;

public class Player {
    private static int nextId = 0;
    private int id;
    private String name;
    private int matches;
    private int runs;
    private int wickets;

    public Player(){
        this.name = "Unknown";
        this.id = ++nextId;
        this.runs = 0;
        this.wickets = 0;
        this.matches = 0;
    }

    public Player(String name, int match, int run, int wicket){
        this.name = name;
        this.id = ++nextId;
        this.runs = run;
        this.wickets = wicket;
        this.matches = match;
    }

    public void setId(int id){ this.id = id; }
    public void setName(String name){ this.name = name; }
    public void setWickets(int wickets){
        this.wickets = wickets;
    }
    public void setMatches(int matches) {
        this.matches = matches;
    }
    public void setRuns(int runs) {
        this.runs = runs;
    }


    public int getId(){ return this.id; }
    public String getName(){ return this.name; }
    public int getRuns(){ return this.runs; }
    public int getMatches(){ return this.matches; }
    public int getWickets(){ return this.wickets; }

    public void displayPlayer(){
        System.out.println("~~~~~Player Info~~~~~\n");
        System.out.println("Player id: "+ this.getId());
        System.out.println("Player Name: "+ this.getName());
        System.out.println("Taken Wickets: "+ this.getWickets());
        System.out.println("Total Runs: "+ this.getRuns());
        System.out.println("Match Played: "+ this.getMatches());
    }

    public double calculateAverage(){
        return (double) getRuns() / getMatches();
    }

}
