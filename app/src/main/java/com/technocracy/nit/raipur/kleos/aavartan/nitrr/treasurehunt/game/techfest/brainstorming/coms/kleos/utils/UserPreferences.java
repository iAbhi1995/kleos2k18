package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.R;

public class UserPreferences {
    private Context ct;

    public UserPreferences(Context ct){
        this.ct = ct;
    }

    public String getUsername() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ct);
        return preferences.getString("username", "");
    }

    public void setUsername(String username) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ct);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("username", username);
        editor.apply();
    }

    public String getName() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ct);
        return preferences.getString("name", "");
    }

    public void setName(String name) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ct);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("name", name);
        editor.apply();
    }

    public String getLevel() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ct);
        return preferences.getString("level", "0");
    }

    public void setLevel(String level) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ct);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("level", level);
        editor.apply();
    }

    public String getPassword() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ct);
        return preferences.getString("password", "");
    }

    public void setPassword(String password) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ct);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("password", password);
        editor.apply();
    }

    public void clearPrefs() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ct);
        SharedPreferences.Editor editor = prefs.edit();

        boolean b = editor.clear().commit();
        editor.apply();
    }
    public void saveProfileImage(Uri uri){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ct);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("ProfileImageUri",uri.toString());
        editor.apply();
    }
    public Uri getProfileImage(){
        Uri defaultImageUri = Uri.parse("android.resource://com.technocracy.nitraipur.kleos2k18/"+ R.drawable.profilesample);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ct);
        return Uri.parse(preferences.getString("ProfileImageUri", defaultImageUri.toString()));
    }
}
