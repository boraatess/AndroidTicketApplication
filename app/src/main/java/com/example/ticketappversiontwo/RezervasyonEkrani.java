package com.example.ticketappversiontwo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class RezervasyonEkrani extends AppCompatActivity
{
    TextView textView,textView1;
    String RezervasyonKod;

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
            Intent intent = new Intent(RezervasyonEkrani.this,MainActivity.class);
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezervasyon_ekrani);

        textView = findViewById(R.id.textView19);
        textView1 = findViewById(R.id.textView20);


        Random rnd = new Random();

        int x = rnd.nextInt(99999999 - 999999 + 1) + 999999 ;

        textView1.setText("Rezervasyon Kodunuz : " + x);

        RezervasyonKod = textView1.getText().toString();


    }

    public  void SaveCode(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Rezervasyon Özetiniz");
        builder.setMessage(RezervasyonKod + "'dir. " );

        AlertDialog.Builder builder1 = builder.setPositiveButton("Kodu Kaydet", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                Intent intent = new Intent(RezervasyonEkrani.this,MyProfile.class);

                intent.putExtra("code",RezervasyonKod);

                startActivity(intent);

            }
        });

        builder.setNegativeButton("HAYIR", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Intent intent = new Intent(RezervasyonEkrani.this,AnaSayfa.class);
                startActivity(intent);

            }

        });

        builder1.show();
    }
}
