package com.siny.sinyvib;

import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private int rgId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
/*
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
        RadioGroup rg1 = (RadioGroup) findViewById(R.id.radioGroup1);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rgId = checkedId;

                switch (checkedId) {
                    case R.id.radio0:
                        break;
                    case R.id.radio1:
                        break;
                    case R.id.radio2:
                        break;
                }
            }
        });

        Button btnVibrator = (Button) findViewById(R.id.btnVibrator);
        Button btnStop = (Button) findViewById(R.id.btnStop);

        View.OnClickListener btnVibratorListener;
        btnVibratorListener = (new View.OnClickListener() {
            public void onClick(View v) {
                Vibrator vibe = (Vibrator) getSystemService(VIBRATOR_SERVICE);

                switch (rgId) {
                    case R.id.radio0: //1초
                        vibe.vibrate(1000);
                        break;
                    case R.id.radio1: //5초
                        vibe.vibrate(5000);
                        break;
                    case R.id.radio2: //10초
                        vibe.vibrate(10000);
                        break;
                    case R.id.radio3: { //패턴1
                        long[] pattern1 = new long[]{0,50,30,10,100};
                        vibe.vibrate(pattern1, 0);
                        break;
                    }
                    case R.id.radio4: {//패턴2
                        long[] pattern1 = new long[]{0,10,0,10};
                        vibe.vibrate(pattern1, 0);
                        break;
                    }
                    case R.id.radio5: {//패턴3
                        long[] pattern2 = new long[]{0,50,10,10};
                        vibe.vibrate(pattern2, 0);
                        break;
                    }
                    case R.id.radio6: {//패턴4
                        long[] pattern2 = new long[]{0,10,0,20,0,30,0,40,0,50,0,60,70,0,80,0,90,0,100};
                        vibe.vibrate(pattern2, 0);
                        break;
                    }
                    case R.id.radio7: {//패턴5
                        long[] pattern2 = new long[]{0,200,0,10};
                        vibe.vibrate(pattern2, 0);
                        break;
                    }
                    case R.id.radio8: {//패턴6
                        long[] pattern2 = new long[]{0,300,10,20};
                        vibe.vibrate(pattern2, 0);
                        break;
                    }
                    case R.id.radio9: {//패턴7
                        long[] pattern2 = new long[]{0,3000,10,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
                        vibe.vibrate(pattern2, 0);
                        break;
                    }
                } //end of case

            } //end of onClick
        });
        btnVibrator.setOnClickListener(btnVibratorListener);

        View.OnClickListener btnStopListener;
        btnStopListener = (new View.OnClickListener() {
            public void onClick(View v) {
                Vibrator vibe = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vibe.cancel();
            }
        });
        btnStop.setOnClickListener(btnStopListener);

        rgId = R.id.radio0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
