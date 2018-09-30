package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.activities;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;


import com.mursaat.extendedtextview.AnimatedGradientTextView;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.R;
import com.viven.imagezoom.ImageZoomHelper;

import static maes.tech.intentanim.CustomIntent.customType;

public class StoryLineActivity extends AppCompatActivity {

    ImageZoomHelper imageZoomHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_line);
        customType(this, "fadein-to-fadeout");

        imageZoomHelper = new ImageZoomHelper(this);
        Typeface cav = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/caviardreams.ttf");
        AnimatedGradientTextView textView = findViewById(R.id.kleos);textView.setTypeface(cav);

        ImageZoomHelper.setViewZoomable(findViewById(R.id.storyline));

        TextView content = (TextView)findViewById(R.id.content);content.setTypeface(cav);
        TextView t1 = (TextView)findViewById(R.id.t1);t1.setTypeface(cav);
        TextView t2 = (TextView)findViewById(R.id.t2);t2.setTypeface(cav);
        TextView t3 = (TextView)findViewById(R.id.t3);t3.setTypeface(cav);
        TextView t4 = (TextView)findViewById(R.id.t4);t4.setTypeface(cav);
        TextView t5 = (TextView)findViewById(R.id.t5);t5.setTypeface(cav);
        TextView t6 = (TextView)findViewById(R.id.t6);t6.setTypeface(cav);
        TextView t7 = (TextView)findViewById(R.id.t7);t7.setTypeface(cav);
        TextView t8 = (TextView)findViewById(R.id.t8);t8.setTypeface(cav);
        TextView t9 = (TextView)findViewById(R.id.t9);t9.setTypeface(cav);
    }
    public void exit(View view){
        finish();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return imageZoomHelper.onDispatchTouchEvent(ev) || super.dispatchTouchEvent(ev);
    }
}
