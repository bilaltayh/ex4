package com.example.bilalt.bilal;

public class MessageOBJ {


    public String message;
    public boolean color;
    public int num ;
    public String reminderText;
    public String date;

    public MessageOBJ(int num, String date, String reminderText, String message) {
        super();
        this.date = date;
        this.reminderText = reminderText;
        this.num = num;
        this.color = num%2==0;
        this.message = message;
        }

}
