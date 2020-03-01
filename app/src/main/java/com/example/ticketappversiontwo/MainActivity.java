package com.example.ticketappversiontwo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity
{
    EditText editText,editText1;
    String username,userpassword;
    FirebaseAuth firebaseAuth;

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar2);
        progressBar.setVisibility(View.INVISIBLE);

        editText = findViewById(R.id.editText);
        editText1 = findViewById(R.id.editText2);

        firebaseAuth = FirebaseAuth.getInstance();

    }

    public void GirisYap(View view)
    {

      username = editText.getText().toString();
      userpassword = editText1.getText().toString();

        if (username.matches("") && userpassword.matches(""))
        {
            Toast.makeText(MainActivity.this,"Lütfen Hesap Bilgilerinizi Giriniz",Toast.LENGTH_SHORT).show();
        }
        else {

            /*
            firebaseAuth.signInWithEmailAndPassword(username, userpassword).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Intent intent = new Intent(MainActivity.this, AnaSayfa.class);
                    startActivity(intent);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
            });       */

            progressBar.setVisibility(View.VISIBLE);

            Intent intent = new Intent(MainActivity.this, AnaSayfa.class);
            startActivity(intent);

        }

    }

    public void KayıtOL(View view)
    {
        Intent intent = new Intent(MainActivity.this,SignUP.class);
        startActivity(intent);

    }


}
