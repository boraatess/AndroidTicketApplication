package com.example.ticketappversiontwo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MyProfile extends AppCompatActivity
{
    String myRezervasyonKod,ticketCode;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

         sharedPreferences = MyProfile.this.getSharedPreferences("com.example.ticketappversiontwo", Context.MODE_PRIVATE);

        Intent intent = getIntent();

        myRezervasyonKod = intent.getStringExtra("code");

        sharedPreferences.edit().putString("Reservation",myRezervasyonKod).apply();
       // ticketCode = intent.getStringExtra("ticketCode");

        ListView listView = findViewById(R.id.ListView);

        ArrayList<String> Reservations = new ArrayList<String>();

        Reservations.add(myRezervasyonKod);
        // Reservations.add(ticketCode);

        sharedPreferences.edit().putString("Reservation",myRezervasyonKod).apply();

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,Reservations);

        listView.setAdapter(arrayAdapter);

    }

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
            Intent intent = new Intent(MyProfile.this,MainActivity.class);
            startActivity(intent);

        }
        else if (item.getItemId() == R.id.my_profile)
        {
            Intent intent = new Intent(this,MyProfile.class);
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }

}
