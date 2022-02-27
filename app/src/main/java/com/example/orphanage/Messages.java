package com.example.orphanage;

public class Messages {
    String Name,Message;

    public Messages(String name, String message) {
        Name = name;
        Message = message;
    }
    public Messages(){

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
