package com.example.enigmassiette.sampledata;

public class Note {
    public String restaurantName;
    public String date;
    public String time;
    public String noteDeco;
    public String noteFood;
    public String noteServ;
    public String critique;

    public Note(String restauName, String date, String time, String noteDeco, String noteFood, String noteServ, String critique){
        this.restaurantName = restauName;
        this.date = date;
        this.time = time;
        this.noteDeco = noteDeco;
        this.noteFood = noteFood;
        this.noteServ = noteServ;
        this.critique = critique;
    }
}
