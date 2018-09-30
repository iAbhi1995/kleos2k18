package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.github.florent37.viewtooltip.ViewTooltip;
import com.mursaat.extendedtextview.AnimatedGradientTextView;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.R;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.models.User;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.restapi.ApiBase;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.restapi.ApiEndpoints;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.utils.UserPreferences;
import com.wang.avi.AVLoadingIndicatorView;

import java.io.File;

import am.appwise.components.ni.NoInternetDialog;
import de.hdodenhof.circleimageview.CircleImageView;
import es.dmoral.toasty.Toasty;
import io.github.mthli.slice.Slice;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static maes.tech.intentanim.CustomIntent.customType;

public class ProfileSetupActivity extends AppCompatActivity {
    Button submit;
    EditText firstname, lastname, college, email;
    UserPreferences userPreferences;
    AVLoadingIndicatorView indicatorView;
    CircleImageView circleImageView;
    ApiEndpoints apiBase;
    Typeface cav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_setup);
        customType(this, "fadein-to-fadeout");

        userPreferences = new UserPreferences(this);
        cav = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/caviardreams.ttf");

        AnimatedGradientTextView textView = findViewById(R.id.kleos);textView.setTypeface(cav);

        firstname = (EditText) findViewById(R.id.firstName);firstname.setTypeface(cav);
        lastname = (EditText) findViewById(R.id.lastName);lastname.setTypeface(cav);
        college = (EditText)findViewById(R.id.college);college.setTypeface(cav);
        email = (EditText) findViewById(R.id.email);email.setTypeface(cav);
        circleImageView = (CircleImageView)findViewById(R.id.drawerImg);

        indicatorView = (AVLoadingIndicatorView)findViewById(R.id.avi);
        indicatorView.hide();

        submit = (Button)findViewById(R.id.submit);submit.setTypeface(cav);
        Slice slice = new Slice(submit);
        slice.setRadius(8f);
        slice.setColor(Color.parseColor("#00BB84"));


    }



    public void showViewTooltip(View v, String message){
        ViewTooltip.on(v)
                .align(ViewTooltip.ALIGN.CENTER)
                .position(ViewTooltip.Position.TOP)
                .text(message)
                .textTypeFace(cav)
                .textColor(Color.WHITE)
                .color(Color.parseColor("#00BB84"))
                .padding(2,2,2,2)
                .corner(15)
                .arrowWidth(15)
                .arrowHeight(15)
                .distanceWithView(0)
                .show();
    }
    public void submit(View v){

        if(!String.valueOf(firstname.getText()).equals("") && !String.valueOf(lastname.getText()).equals("") && !String.valueOf(email.getText()).equals("") ){
            YoYo.with(Techniques.FadeOut).duration(500).playOn(v);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            indicatorView.show();
                            v.setVisibility(View.INVISIBLE);
                        }
                    }, 500);

                }
            });
            String username = userPreferences.getUsername();
            apiBase = ApiBase.getClient().create(ApiEndpoints.class);
            Call<User> call = apiBase.fillDetails(username,
                    firstname.getText().toString(),
                    lastname.getText().toString(),
                    email.getText().toString(),
                    college.getText().toString());
            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                    if(response.isSuccessful()){
                    if(String.valueOf(response.body().message).equals("User Created Succesfully")){
                        userPreferences.setName(firstname.getText().toString().concat(" "+ lastname.getText().toString()));
                        userPreferences.setLevel("0");
                        Intent i = new Intent(ProfileSetupActivity.this, HomeActivity.class);
                        startActivity(i);
                        finish();
                    }}else{
                        v.setVisibility(View.VISIBLE);
                        YoYo.with(Techniques.FadeIn).duration(500).playOn(v);
                        Toasty.error(ProfileSetupActivity.this, "Some Thing Went Wrong", Toast.LENGTH_SHORT, true).show();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                    v.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.FadeIn).duration(500).playOn(v);
                    NoInternetDialog noInternetDialog = new NoInternetDialog.Builder(ProfileSetupActivity.this).build();
                }
            });

        }
        else{
            YoYo.with(Techniques.Shake).duration(500).playOn(v);
            showViewTooltip(firstname, "This field can't be empty");
            showViewTooltip(lastname, "This field can't be empty");
            showViewTooltip(email, "This field can't be empty");
        }

    }


}
