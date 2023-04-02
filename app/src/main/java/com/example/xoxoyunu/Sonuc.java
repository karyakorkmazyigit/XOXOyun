package com.example.xoxoyunu;

import androidx.annotation.NonNull;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.xoxoyunu.R;

public class Sonuc extends Dialog {

    private final String mesaj;
    private final MainActivity mainActivity;

    public Sonuc(@NonNull MainActivity context, String mesaj, MainActivity mainActivity) {
        super(context);
        this.mesaj=mesaj;
        this.mainActivity=mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);

        TextView mesajText=findViewById(R.id.mesajText);
        Button tekrarOynabtn=findViewById(R.id.tekrarOynabtn);

        mesajText.setText(mesaj);
        tekrarOynabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.maciTekrarOyna();
                dismiss();
            }
        });
    }
}