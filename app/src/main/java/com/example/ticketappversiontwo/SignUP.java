package com.example.ticketappversiontwo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUP extends AppCompatActivity
{
    EditText editText,editText1,editText2,editText3,editText4;

    String name,surname,phone,mail,password;

    FirebaseAuth firebaseAuth ;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editText = findViewById(R.id.editText3);
        editText1 = findViewById(R.id.editText4);
        editText2 = findViewById(R.id.editText5);

        editText3 = findViewById(R.id.editText6);

        editText4 = findViewById(R.id.editText7);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

    }

    public void SignUp(View view)
    {

        name = editText.getText().toString();
        surname = editText1.getText().toString();
        mail = editText2.getText().toString();
        phone = editText3.getText().toString();
        password = editText4.getText().toString();

       if (name.matches("") && surname.matches("") && phone.matches("")
               && mail.matches("") && password.matches(""))
       {
           Toast.makeText(this,"Lütfen boş bırakılan yerleri doldurunuz",Toast.LENGTH_SHORT).show();

       } else {

           firebaseAuth.createUserWithEmailAndPassword(mail,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
               @Override
               public void onSuccess(AuthResult authResult) {
                   Toast.makeText(SignUP.this,"HOŞGELDİNİZ SAYIN " + name + "" + surname
                           + "" + "üyelik kaydınız başarıyla oluşturulmuştur",Toast.LENGTH_SHORT).show();
               }
           }).addOnFailureListener(new OnFailureListener() {
               @Override
               public void onFailure(@NonNull Exception e) {
                   Toast.makeText(SignUP.this,e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
               }
           });

           AlertDialog.Builder builder = new AlertDialog.Builder(this);
           builder.setTitle("Hesap Bilgileriniz");
           builder.setMessage("HOŞGELDİNİZ SAYIN;"+ " " + name + " " + surname + " " + "üyelik kaydınız başarıyla oluşturulmuştur."
           + " " + "E Mail Adresiniz :" + mail + "" + "Telefon Numaranız " + phone + " " + "Şireniz :" + password);

           AlertDialog.Builder builder1 = builder.setPositiveButton("Giriş Ekranı", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialogInterface, int i) {
                   Intent intent = new Intent(SignUP.this,MainActivity.class);
                   startActivity(intent);
               }
           });
           builder1.show();

       }

    }
}
