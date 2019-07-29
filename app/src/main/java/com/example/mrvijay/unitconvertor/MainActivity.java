package com.example.mrvijay.unitconvertor;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String selection;

    boolean check=true;


    ImageView bgapp, clover;

    Animation frombottom;
    TextView weight,temp,length,time,title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_nav);


        title=findViewById(R.id.textView6);
        weight=findViewById(R.id.weight);
        temp=findViewById(R.id.temperature);
        time=findViewById(R.id.time);
        length=findViewById(R.id.length);
        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);

        bgapp=findViewById(R.id.bgapp);
        clover=findViewById(R.id.clove);




        title.animate().alpha(0).setDuration(1800).setStartDelay(600);
        bgapp.animate().translationY(-1450).setDuration(1300).setStartDelay(1000);

        clover.animate().alpha(1).setDuration(1000).setStartDelay(1800);
        weight.startAnimation(frombottom);
        time.startAnimation(frombottom);
        length.startAnimation(frombottom);
        temp.startAnimation(frombottom);

        weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection="weight";
                check=true;
                Intent i=new Intent(MainActivity.this,second.class);
                i.putExtra("mainUnit",selection);
                startActivity(i);

            }
        });
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection="time";
                check=true;
                Intent i=new Intent(MainActivity.this,second.class);
                i.putExtra("mainUnit",selection);
                startActivity(i);

            }
        });
        length.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection="length";
                check=true;
                Intent i=new Intent(MainActivity.this,second.class);
                i.putExtra("mainUnit",selection);
                startActivity(i);

            }
        });
        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection="temperature";
                check=true;
                Intent i=new Intent(MainActivity.this,second.class);
                i.putExtra("mainUnit",selection);
                startActivity(i);

            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.about,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String title=item.getTitle().toString();

        if (title.equals("exit"))
        {
            finishAndRemoveTask();

        }

        return  true;
    }

    @Override
    public void onBackPressed() {

        if (check)
        {
            Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show();
            check=false;
        }
        else {
            super.onBackPressed();
        }
    }
}


