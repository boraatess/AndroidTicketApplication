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

public class BiletListesi extends AppCompatActivity
{
    TextView textView,textView1,textView2,textView3,textView4,textView5,textView6;
    String sefer1,sefer2,sefer3,sefer4,date1,date2,sehir1,sehir2;
    String sefer ;

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
            Intent intent = new Intent(BiletListesi.this,MainActivity.class);
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
        setContentView(R.layout.activity_bilet_listesi);

        textView = findViewById(R.id.textView12);
        textView1 = findViewById(R.id.textView13);
        textView2 = findViewById(R.id.textView14);
        textView3 = findViewById(R.id.textView15);
        textView4 = findViewById(R.id.textView16);
        textView5 = findViewById(R.id.textView17);

        Random rand = new Random();

        // Obtain a number between [0 - 49].

        int x = rand.nextInt(24);
        int y = rand.nextInt(60);

        int a = rand.nextInt(24);
        int b = rand.nextInt(60);

        int c = rand.nextInt(24);
        int d = rand.nextInt(60);

        int z = rand.nextInt(24);
        int t = rand.nextInt(60);

        textView2.setText("KALKIŞ SAATİ :" + "" + x + ":" + y + " "+"KOLTUK: 2+1" + " " + " "+ "Bilet Tutarı: 100 TL");

        textView3.setText("KALKIŞ SAATİ :" + "" + a + ":" + b + " "+"KOLTUK: 2+2" + " " + " "+ "Bilet Tutarı: 100 TL");

        textView4.setText("KALKIŞ SAATİ :" + "" + c + ":" + d + " "+ "KOLTUK: 2+2" + " " + " "+ "Bilet Tutarı: 100 TL");

        textView5.setText("KALKIŞ SAATİ :" + "" + z + ":" + t + " "+ "KOLTUK: 2+1" + " " + " "+ "Bilet Tutarı: 100 TL");

        Intent intent = getIntent();

        date1 = intent.getStringExtra("departureDate");
        date2 = intent.getStringExtra("arrivalDate");

        sehir1 = intent.getStringExtra("departurePoint");
        sehir2 = intent.getStringExtra("arrivalPoint");

        if (date2 != null)
        {
            if (date2.matches(""))
            {
                textView.setText("Gidiş Tarihiz :" + date1 + " " +
                        "Kalkış Noktası :" + " " + sehir1 + " " + "/"
                        + "Varış Noktası :" + sehir2);

            } else {

                textView.setText("Gidiş Tarihiz :" + date1 + " " +
                        "Kalkış Noktası :" + " " + sehir1 +
                        " " + "/" + "Varış Noktası" + " " + sehir2);
                textView1.setText("Dönüş Tarihiniz : " + date2 + " " +
                        "Kalkış Noktası :" + " " + sehir1 + " " + "/"+
                        "Varış Noktası" + " " + sehir2);

            }
        }

    }

    public void SEC1(View view)
    {
        sefer1 = textView2.getText().toString();

        sefer = sefer1;
        AlertDialog(sefer);

    }

    public void SEC2(View view)
    {
        sefer2 = textView3.getText().toString();

        sefer = sefer2 ;
        AlertDialog(sefer);

    }

    public void SEC3(View view)
    {
        sefer3 = textView4.getText().toString();

        sefer = sefer3;
        AlertDialog(sefer);
    }

    public void SEC4(View view)
    {
        sefer4 = textView5.getText().toString();

        sefer = sefer4;
        AlertDialog(sefer);

    }

    public void AlertDialog(String sefer)
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Seyahat Özetiniz");
        builder.setMessage(sefer);

        AlertDialog.Builder builder1 = builder.setPositiveButton("Satın AL", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                Intent intent = new Intent(BiletListesi.this,SatinAlma.class);
                startActivity(intent);

            }
        });

        builder.setNegativeButton("Rezervasyon", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {

                Intent intent = new Intent(BiletListesi.this,RezervasyonEkrani.class);
                startActivity(intent);
            }

        });

        builder1.show();

    }
}
