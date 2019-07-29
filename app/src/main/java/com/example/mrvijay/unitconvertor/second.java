package com.example.mrvijay.unitconvertor;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by Mr.vijay on 12-09-2018.
 */

public class second extends AppCompatActivity {

    Spinner sp1;
    Spinner sp2;
    EditText et1;
    EditText et2;
    String sp1content;
    String sp2content;
    double et1content;
    double et2content;
    String selection;
    double result;
    boolean val=true;
    String check;

    second ref=this;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second);

        String weight[]={"kilogram","gram","milligram","pound","tonne"};
        String length[]={"inch","foot","metre","kilometre","centimetre"};
        String temperature[]={"celcius","fahrenheit","kelvin"};
        String time[]={"hour","minute","second","millisecond"};

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);

        sp1=findViewById(R.id.spinner1);
        sp2=findViewById(R.id.spinner2);

        et1=findViewById(R.id.editText1);
        et2=findViewById(R.id.editText2);

      et2.requestFocus();




        Intent i=getIntent();
        selection=i.getExtras().getString("mainUnit");

        ArrayAdapter<String> ar=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);

        if(selection.equalsIgnoreCase("weight"))
        {
            getSupportActionBar().setTitle(selection);
            ar.addAll(weight);
            sp1.setAdapter(ar);
            sp2.setAdapter(ar);

        }
        else if(selection.equalsIgnoreCase("length"))
        {
            getSupportActionBar().setTitle(selection);
            ar.addAll(length);
            sp1.setAdapter(ar);
            sp2.setAdapter(ar);
        }
        else if(selection.equalsIgnoreCase("temperature"))
        {
            getSupportActionBar().setTitle(selection);
            ar.addAll(temperature);
            sp1.setAdapter(ar);
            sp2.setAdapter(ar);
        }
        else if(selection.equalsIgnoreCase("time"))
        {
            getSupportActionBar().setTitle(selection);
            ar.addAll(time);
            sp1.setAdapter(ar);
            sp2.setAdapter(ar);
        }


        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                sp2content=sp2.getSelectedItem().toString();
                try
                {
                    ref.convert();
                }catch (NullPointerException npe){}

                if(et2.getText().toString().length()==0)
                {
                    et1.setText("");
                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sp1content=sp1.getSelectedItem().toString();

                try {
                    ref.convert();
                }catch (NullPointerException npe)
                {}






            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        et2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {



            }

            @Override
            public void afterTextChanged(Editable editable) {


                check=et2.getText().toString();
              try {

                    if (et2.getText().toString().length()!=0 && check.startsWith("-") && selection.equalsIgnoreCase("temperature"))
                    {
                        et2content=Double.parseDouble(et2.getText().toString());


                        ref.convert();
                    }

                  else if( et2.getText().toString().length()!=0 && !selection.startsWith("-"))

                  {
                      et2content=Double.parseDouble(et2.getText().toString());


                      ref.convert();
                  }

                  if(et2.getText().toString().length()==0)
                  {
                      et1.setText("");
                  }

              }catch (NumberFormatException mfe){et1.setText("");}


            }
        });


    }

    public void convert()
    {
        if (et2.getText().toString() != "") {
            if (selection.equalsIgnoreCase("weight")) {


                switch (sp2content) {
                    case "kilogram":
                        switch (sp1content) {
                            case "kilogram":
                                result = et2content;
                                et1.setText(result + "");
                                break;

                            case "gram":
                                result = et2content * 1000;

                                et1.setText(result + "");
                                break;

                            case "milligram":
                                result = et2content *1e+6;
                                et1.setText(result + "");
                                break;
                            case "pound":
                                result = et2content * 2.20462;
                                et1.setText(result + "");
                                break;

                            case "tonne":
                                result = et2content * 0.001;
                                et1.setText(result + "");
                                break;
                        }
                        break;

                    case "gram":
                        switch (sp1content) {
                            case "kilogram":
                                result = et2content * 0.001;
                                et1.setText(result + "");
                                break;

                            case "gram":
                                result = et2content;
                                et1.setText(result + "");
                                break;

                            case "milligram":
                                result = et2content * 1000;
                                et1.setText(result + "");
                                break;

                            case "pound":
                                result = et2content * 0.00220462;
                                et1.setText(result + "");
                                break;

                            case "tonne":
                                result = et2content;
                                et1.setText(result + "");
                                break;
                        }
                        break;

                    case "milligram":
                        switch (sp1content) {
                            case "milligram":
                                result = et2content;
                                et1.setText(result + "");
                                break;

                            case "gram":
                                result = et2content * 0.001;
                                et1.setText(result + "");
                                break;

                            case "kilogram":
                                result = et2content * 1e-6;
                                et1.setText(result + "");
                                break;

                            case "pound":
                                result = et2content * 2.2046e-6;
                                et1.setText(result + "");
                                break;

                            case "tonne":
                                result = et2content * 9.99989739e-10;
                                et1.setText(result + "");
                                break;
                        }
                        break;

                    case "pound":
                        switch (sp1content) {
                            case "pound":
                                result = et2content;
                                et1.setText(result + "");
                                break;

                            case "gram":
                                result = et2content * 453.592;
                                et1.setText(result + "");
                                break;

                            case "kilogram":
                                result = et2content * 0.453592;
                                et1.setText(result + "");
                                break;

                            case "milligram":
                                result = et2content * 453592;
                                et1.setText(result + "");
                                break;

                            case "tonne":
                                result = et2content * 0.000453592;
                                et1.setText(result + "");
                                break;
                        }
                        break;

                    case "tonne":
                        switch (sp1content) {
                            case "tonne":
                                result = et2content;
                                et1.setText(result + "");
                                break;

                            case "kilogram":
                                result = et2content * 1000;
                                et1.setText(result + "");
                                break;

                            case "gram":
                                result = et2content * 1e+6;
                                et1.setText(result + "");
                                break;

                            case "milligram":
                                result = et2content * 1e+9;
                                et1.setText(result + "");
                                break;

                            case "pound":
                                result = et2content * 2204.62;
                                et1.setText(result + "");
                                break;

                        }
                }
            } else if (selection.equalsIgnoreCase("length")) {
                switch (sp2content) {
                    case "foot":
                        switch (sp1content) {
                            case "foot":
                                result = et2content;
                                et1.setText(result + "");
                                break;

                            case "inch":
                                result = et2content * 12;
                                et1.setText(result + "");
                                break;

                            case "centimetre":
                                result = et2content * 30.48;
                                et1.setText(result + "");
                                break;
                            case "metre":
                                result = et2content * 0.3048;
                                et1.setText(result + "");
                                break;

                            case "kilometre":
                                result = et2content * 0.0003048;
                                et1.setText(result + "");
                                break;
                        }
                        break;

                    case "inch":
                        switch (sp1content) {
                            case "inch":
                                result = et2content;
                                et1.setText(result + "");
                                break;

                            case "foot":
                                result = et2content * 0.083333;
                                et1.setText(result + "");
                                break;

                            case "centimetre":
                                result = et2content * 2.54;
                                et1.setText(result + "");
                                break;

                            case "metre":
                                result = et2content * 0.0254;
                                et1.setText(result + "");
                                break;

                            case "kilometre":
                                result = et2content * 2.54e-5;
                                et1.setText(result + "");
                                break;
                        }
                        break;

                    case "centimetre":
                        switch (sp1content) {
                            case "centimetre":
                                result = et2content;
                                et1.setText(result + "");
                                break;

                            case "inch":
                                result = et2content * 0.393701;
                                et1.setText(result + "");
                                break;

                            case "foot":
                                result = et2content * 0.0328084;
                                et1.setText(result + "");
                                break;

                            case "metre":
                                result = et2content * 0.01;
                                et1.setText(result + "");
                                break;

                            case "kilometre":
                                result = et2content * 1e-5;
                                et1.setText(result + "");
                                break;
                        }
                        break;

                    case "metre":
                        switch (sp1content) {
                            case "metre":
                                result = et2content;
                                et1.setText(result + "");
                                break;

                            case "inch":
                                result = et2content * 39.3701;
                                et1.setText(result + "");
                                break;

                            case "kilometre":
                                result = et2content * 0.001;
                                et1.setText(result + "");
                                break;

                            case "foot":
                                result = et2content * 3.28084;
                                et1.setText(result + "");
                                break;

                            case "centimetre":
                                result = et2content * 100;
                                et1.setText(result + "");
                                break;
                        }
                        break;

                    case "kilometre":
                        switch (sp1content) {
                            case "kilometre":
                                result = et2content;
                                et1.setText(result + "");
                                break;

                            case "inch":
                                result = et2content * 39370.1;
                                et1.setText(result + "");
                                break;

                            case "centimetre":
                                result = et2content * 100000;
                                et1.setText(result + "");
                                break;

                            case "foot":
                                result = et2content * 3280.84;
                                et1.setText(result + "");
                                break;

                            case "metre":
                                result = et2content * 1000;
                                et1.setText(result + "");
                                break;

                        }
                }


            } else if (selection.equalsIgnoreCase("temperature")) {

                switch (sp2content) {
                    case "celcius":
                        switch (sp1content) {
                            case "celcius":
                                result = et2content;
                                et1.setText(result + "");
                                break;

                            case "fahrenheit":
                                result = (9*(et2content) / 5) + 32;
                                et1.setText(result + "");
                                break;

                            case "kelvin":
                                result=et2content+273.15;
                                et1.setText(result+"");
                                break;


                        }
                        break;

                    case "fahrenheit":
                        switch (sp1content) {
                            case "fahrenheit":
                                result = et2content;
                                et1.setText(result + "");
                                break;

                            case "celcius":
                                result = 5*(et2content- 32)/9;
                                et1.setText(result + "");
                                break;

                            case "kelvin":
                                result=(et2content + 459.67)*5/9;
                                et1.setText(result+"");
                                break;

                        }
                        break;

                    case "kelvin":
                        switch(sp1content)
                        {
                            case "kelvin":
                                result=et2content;
                                et1.setText(result+"");
                                break;

                            case "celcius":
                                result=et2content-273.15;
                                et1.setText(result+"");
                                break;


                            case "fahrenheit":
                                result=et2content* 9/5 - 459.67;
                                et1.setText(result+"");
                                break;

                        }
                }
            } else if (selection.equalsIgnoreCase("time")) {

                switch(sp2content)
                {
                    case "hour":
                        switch (sp1content)
                        {
                            case "hour":
                                result=et2content;
                                et1.setText(result+"");
                                break;

                            case "minute":
                                result=et2content*60;
                                et1.setText(result+"");
                                break;

                            case "second":
                                result=et2content*3600;
                                et1.setText(result+"");
                                break;

                            case "millisecond":
                                result=et2content*3.6e+6;
                                et1.setText(result+"");
                                break;
                        }
                        break;

                    case "minute":
                        switch (sp1content)
                        {
                            case "minute":
                                result=et2content;
                                et1.setText(result+"");
                                break;

                            case "hour":
                                result=et2content*0.0166667;
                                et1.setText(result+"");
                                break;

                            case "second":
                                result=et2content*60;
                                et1.setText(result+"");
                                break;

                            case "millisecond":
                                result=et2content*60000;
                                et1.setText(result+"");
                                break;
                        }
                        break;

                    case "second":
                        switch (sp1content)
                        {
                            case "second":
                                result=et2content;
                                et1.setText(result+"");
                                break;

                            case "minute":
                                result=et2content*0.0166667;
                                et1.setText(result+"");
                                break;

                            case "hour":
                                result=et2content*0.000277778;
                                et1.setText(result+"");
                                break;

                            case "millisecond":
                                result=et2content*1000;
                                et1.setText(result+"");
                                break;
                        }
                        break;

                    case "millisecond":
                        switch (sp1content)
                        {
                            case "hour":
                                result=et2content*2.7778e-7;
                                et1.setText(result+"");
                                break;

                            case "minute":
                                result=et2content*1.6667e-5;
                                et1.setText(result+"");
                                break;

                            case "second":
                                result=et2content*0.001;
                                et1.setText(result+"");
                                break;

                            case "millisecond":
                                result=et2content;
                                et1.setText(result+"");
                                break;
                        }
                        break;



                }



            }


        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem mt=menu.add(Menu.NONE,1,1,"back");
        mt.setShowAsAction(1);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        finish();
        return true;
    }
}
