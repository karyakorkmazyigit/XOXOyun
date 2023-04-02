package com.example.xoxoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.xoxoyunu.R;
import com.example.xoxoyunu.databinding.ActivityOyuncuEkle2Binding;




public class OyuncuEkle extends AppCompatActivity {
    private ActivityOyuncuEkle2Binding oyuncuEkle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyuncu_ekle2);

        EditText oyuncuFn=findViewById(R.id.oyuncu_Fn);
        EditText oyuncuSN=findViewById(R.id.oyuncu_SN);
        Button oyunaBaslaBtn=findViewById(R.id.oyunaBaslaBtn);


       oyunaBaslaBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               String getoyuncuFn= oyuncuFn.getText().toString();
               String getoyuncuSN= oyuncuSN.getText().toString();

               if(getoyuncuFn.isEmpty()||getoyuncuSN.isEmpty()){
                   Toast.makeText(OyuncuEkle.this, "Lütfen bir isim girin", Toast.LENGTH_SHORT).show();
               }else{
                   Intent intent = new Intent(OyuncuEkle.this,MainActivity.class);
                   intent.putExtra("oyuncuFn",getoyuncuFn);
                   intent.putExtra("oyuncuSN",getoyuncuSN);
                   startActivity(intent);
               }
           }
       });
    }


}