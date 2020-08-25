package com.example.sherybutt;

public class User_Selection {
    String user_date;
    String user_time;
    String user_id;
    String user_slot;


    public User_Selection() {
    }

    public User_Selection(String user_date, String user_time, String user_id,String user_slot ) {
        this.user_date = user_date;
        this.user_time = user_time;
        this.user_id = user_id;
        this.user_slot=user_slot;
    }

    public String getUser_slot() {
        return user_slot;
    }

    public void setUser_slot(String user_slot) {
        this.user_slot = user_slot;
    }

    public String getUser_date()
    {
        return user_date;
    }

    public String getUser_time()
    {
        return user_time;
    }

    public String getUser_id()
    {
        return user_id;
    }


}
