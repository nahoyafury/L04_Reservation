 package sg.edu.rp.c346.id21040742.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    EditText name;
    EditText number;
    EditText pax;
    RadioGroup area;
    Button confirm;
    Button reset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.dp);
        tp = findViewById(R.id.tp);
        name = findViewById(R.id.inputName);
        number = findViewById(R.id.inputNumber);
        pax = findViewById(R.id.inputPax);
        confirm = findViewById(R.id.btnConfirm);
        reset = findViewById(R.id.btnReset);
        area = findViewById(R.id.area);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedRadioId = area.getCheckedRadioButtonId();
                int day = dp.getDayOfMonth();
                int month = dp.getMonth()+1;
                int year = dp.getYear();
                int hour = tp.getCurrentHour();
                int minute = tp.getCurrentMinute();
                String nameString="Name: "+name.getText().toString();
                String time = String.format("Select timing is %d:%d", hour,minute);
                String date = String.format("Selected date is %d/%d/%d",day,month,year);
                String paxstring = "No of Pax: "+ pax.getText().toString();
                String numberstring = "Mobile Number: " + number.getText().toString();


                if (name.getText().length() != 0 && number.getText().length() != 0 && pax.getText().length() != 0 ) {
                    if (checkedRadioId == R.id.smoke) {
                        Toast.makeText(MainActivity.this, nameString+"\n"+paxstring+"\n"+numberstring+"\n"+time+"\n"+"Table area: Smoking",Toast.LENGTH_SHORT).show();
                }
                    else {
                    Toast.makeText(MainActivity.this, nameString+"\n"+paxstring+"\n"+numberstring+"\n"+time+"\n"+"Table area: Non-Smoking",Toast.LENGTH_SHORT).show();
                }

                }
                else {
                    Toast.makeText(MainActivity.this, "Please fill up the empty fields", Toast.LENGTH_SHORT).show();
                }

        };

        }

        );


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                number.setText("");
                pax.setText("");
                tp.setCurrentHour(19);
                tp.setIs24HourView(true);
                dp.updateDate(2020,5,1);

            }

    });



}}




