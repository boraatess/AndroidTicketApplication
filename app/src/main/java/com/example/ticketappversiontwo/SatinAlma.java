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

public class SatinAlma extends AppCompatActivity
{
    TextView textView;

    String ticketCode;
    int x;
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
            Intent intent = new Intent(SatinAlma.this,MainActivity.class);
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
        setContentView(R.layout.activity_satin_alma);

        textView = findViewById(R.id.textView21);

        Random rnd = new Random();

        x = rnd.nextInt(99999999 - 999999 + 1) + 999999 ;

    }

    public void BuyTicket(View view)
    {

        textView.setText("Satın alınan bilet kodu :" + x );

        ticketCode = textView.getText().toString();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Satın Alım Özetiniz");
        builder.setMessage("Satın alım işleminiz başarıyla gerçekleşmiştir. " + ticketCode );

        AlertDialog.Builder builder1 = builder.setPositiveButton("Giriş Ekranı", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                Intent intent = new Intent(SatinAlma.this,AnaSayfa.class);
               // intent.putExtra("ticketCode",ticketCode);
                startActivity(intent);

            }
        });

        builder1.show();

    }


}
