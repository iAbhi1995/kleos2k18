package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.activities;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mursaat.extendedtextview.AnimatedGradientTextView;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.R;

import java.util.Random;

public class question6_dialer extends Activity  implements View.OnClickListener{
    private static Random rno=new Random();
    private TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10;
    private Button B1,B2,B3,B4,B5,B6,B7,B8,B9,B10;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)  {
        Typeface cav = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/caviardreams.ttf");

        AnimatedGradientTextView textView = findViewById(R.id.kleos);textView.setTypeface(cav);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qn6);
        tv1 = findViewById(R.id.tv1);tv1.setTypeface(cav);
        B1 = findViewById(R.id.B1);B1.setTypeface(cav);
        tv2 = findViewById(R.id.tv2);tv2.setTypeface(cav);
        B2 = findViewById(R.id.B2);B2.setTypeface(cav);
        tv3 = findViewById(R.id.tv3);tv3.setTypeface(cav);
        B3 = findViewById(R.id.B3);B3.setTypeface(cav);
        tv4 = findViewById(R.id.tv4);tv4.setTypeface(cav);
        B4 = findViewById(R.id.B4);B5.setTypeface(cav);
        tv5 = findViewById(R.id.tv5);tv5.setTypeface(cav);
        B5 = findViewById(R.id.B5);B5.setTypeface(cav);
        tv6 = findViewById(R.id.tv6);tv6.setTypeface(cav);
        B6 = findViewById(R.id.B6);B6.setTypeface(cav);
        tv7 = findViewById(R.id.tv7);tv7.setTypeface(cav);
        B7 = findViewById(R.id.B7);B7.setTypeface(cav);
        tv8 = findViewById(R.id.tv8);tv8.setTypeface(cav);
        B8 = findViewById(R.id.B8);B8.setTypeface(cav);
        tv9 = findViewById(R.id.tv9);tv9.setTypeface(cav);
        B9 = findViewById(R.id.B9);B9.setTypeface(cav);
        tv10 = findViewById(R.id.tv10);tv10.setTypeface(cav);
        B10 = findViewById(R.id.B10);B10.setTypeface(cav);
        B1.setOnClickListener(this);
        B2.setOnClickListener(this);
        B3.setOnClickListener(this);
        B4.setOnClickListener(this);
        B5.setOnClickListener(this);
        B6.setOnClickListener(this);
        B7.setOnClickListener(this);
        B8.setOnClickListener(this);
        B9.setOnClickListener(this);
        B10.setOnClickListener(this);

    }
        public void onClick(View v) {

            int random=rno.nextInt(50)+1;
            B1.setText(""+random);
            tv1.setText(String.valueOf(random+8));
            random=rno.nextInt(50)+1;
            B2.setText(""+random);
            tv2.setText(String.valueOf(random+3));
            random=rno.nextInt(50)+1;
            B3.setText(""+random);
            tv3.setText(String.valueOf(random+4));
            random=rno.nextInt(50)+1;
            B4.setText(""+random);
            tv4.setText(String.valueOf(random+9));
            random=rno.nextInt(50)+1;
            B5.setText(""+random);
            tv5.setText(String.valueOf(random+0));
            random=rno.nextInt(50)+1;
            B6.setText(""+random);
            tv6.setText(String.valueOf(random+4));
            random=rno.nextInt(50)+1;
            B7.setText(""+random);
            tv7.setText(String.valueOf(random+3));
            random=rno.nextInt(50)+1;
            B8.setText(""+random);
            tv8.setText(String.valueOf(random+0));
            random=rno.nextInt(50)+1;
            B9.setText(""+random);
            tv9.setText(String.valueOf(random+2));
            random=rno.nextInt(50)+1;
            B10.setText(""+random);
            tv10.setText(String.valueOf(random+7));




        }


    public void exit(View view) {
        finish();
    }
}


