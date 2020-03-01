package com.example.ticketappversiontwo;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class AnaSayfa extends AppCompatActivity
{
    Calendar calendar;
    DatePickerDialog datePickerDialog;
    Spinner spn,spn1;
    Switch aSwitch;

    Button button,button1;

     EditText editText,editText1;
     String departure,arrival,sehir1,sehir2;

    private ArrayAdapter<String> dataAdapterForsehir;

    String[] sehirler = {"ankara ","izmir","istanbul","bursa","eskişehir", "aydın","muğla","adana","edirne","tekirdağ",
            "antalya","konya","denizli","diyarbakır","balıkesir", "çanakkale","düzce","giresun","ısparta","kocaeli"};


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();

        menuInflater.inflate(R.menu.options_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if (item.getItemId() == R.id.sign_out)
        {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);

        }
        else if (item.getItemId() == R.id.my_profile)
        {
            Intent intent = new Intent(this,MyProfile.class);
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_sayfa);

        calendar = Calendar.getInstance();

        editText = findViewById(R.id.editText8);
        editText1 = findViewById(R.id.editText9);

        button = findViewById(R.id.button4);
        button1 = findViewById(R.id.button5);

        button1.setEnabled(false);
        editText1.setEnabled(false);

        aSwitch = findViewById(R.id.switch1);
        spn = findViewById(R.id.spinner);
        spn1 = findViewById(R.id.spinner2);

        dataAdapterForsehir= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sehirler);

        dataAdapterForsehir.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spn.setAdapter(dataAdapterForsehir);
        spn1.setAdapter(dataAdapterForsehir);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked)
                {
                    buttonView.setText("Gidiş Dönüş");
                    button1.setEnabled(true);
                    editText1.setEnabled(true);
                }
                else {
                    button1.setEnabled(false);
                    editText1.setEnabled(false);
                    buttonView.setText("Tek Yön");
                }
            }
        });

    }

    public void Contiune(View view)
    {
        departure = editText.getText().toString();
        arrival = editText1.getText().toString();

        sehir1 = spn.getSelectedItem().toString();
        sehir2 = spn1.getSelectedItem().toString();

        if (departure.matches("") && arrival.matches(""))
        {
            Toast.makeText(this,"Lütfen Gerekli Alanları Doldurunuz ",Toast.LENGTH_SHORT).show();
        }

        else {

            Intent intent = new Intent(this, BiletListesi.class);

            intent.putExtra("departureDate",departure);
            intent.putExtra("arrivalDate",arrival);

            intent.putExtra("departurePoint",sehir1);
            intent.putExtra("arrivalPoint",sehir2);

            startActivity(intent);
        }
    }

    public void showDatePickerDialog(View v)
    {

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
            {
                year += 120;
                month += 1;
                editText.setText(dayOfMonth + "/" + month + "/" + year);
            }
        }, day,month,year);
        datePickerDialog.show();

    }

    public void showToDatePickerDialog(View v)
    {

        calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
            {
                year += 120;
                month += 1;
                editText1.setText(dayOfMonth + "/" + month + "/" + year);
            }
        }, day,month,year);
        datePickerDialog.show();
    }


}
