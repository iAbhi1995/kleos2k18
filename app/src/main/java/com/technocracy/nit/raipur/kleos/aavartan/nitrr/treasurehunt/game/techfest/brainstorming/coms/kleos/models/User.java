package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User extends Message{

    @SerializedName("username")
    @Expose
    public String username;

    @SerializedName("passwod")
    @Expose
    public String password;

    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("first_name")
    @Expose
    public String firstName;
    @SerializedName("last_name")
    @Expose
    public String lastName;
    @SerializedName("college")
    @Expose
    public String college;
    @SerializedName("level")
    @Expose
    public String level;

    @SerializedName("key")
    @Expose
    public String key;

    @SerializedName("otp")
    @Expose
    public int otp;

    @SerializedName("non_field_errors")
    @Expose
    public String error;


    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getKey(){ return key; }

    public void setKey(String key){ this.key = key; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }


}