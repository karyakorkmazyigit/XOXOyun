package com.example.xoxoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.xoxoyunu.R;
import com.example.xoxoyunu.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding oyun;
    private final List<int[]> ihtimaller = new ArrayList<>();
    private int[] karePozisyonlari = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int siradakiOyuncu = 1;
    private int toplamdaSecilenKare = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        oyun = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(oyun.getRoot());




        ihtimaller.add(new int[] {0,1,2});
        ihtimaller.add(new int[] {3,4,5});
        ihtimaller.add(new int[] {6,7,8});
        ihtimaller.add(new int[] {0,3,6});
        ihtimaller.add(new int[] {1,4,7});
        ihtimaller.add(new int[] {2,5,8});
        ihtimaller.add(new int[] {2,4,6});
        ihtimaller.add(new int[] {0,4,8});

        String getoyuncuFn= getIntent().getStringExtra("oyuncuFn");
        String getoyuncuSN= getIntent().getStringExtra("oyuncuSN");

        oyun.oyuncuFn.setText(getoyuncuFn);
        oyun.oyuncuSN.setText(getoyuncuSN);

        oyun.kare1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (egerKareSecilebilirse(0)){
                    performAction((ImageView) view,0);
                }
            }
        });

        oyun.kare2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (egerKareSecilebilirse(1)){
                    performAction((ImageView) view,1);
                }
            }
        });
        oyun.kare3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (egerKareSecilebilirse(2)){
                    performAction((ImageView) view,2);
                }
            }
        });
        oyun.kare4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (egerKareSecilebilirse(3)){
                    performAction((ImageView) view,3);
                }
            }
        });
        oyun.kare5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (egerKareSecilebilirse(4)){
                    performAction((ImageView) view,4);
                }
            }
        });
        oyun.kare6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (egerKareSecilebilirse(5)){
                    performAction((ImageView) view,5);
                }
            }
        });
        oyun.kare7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (egerKareSecilebilirse(6)){
                    performAction((ImageView) view,6);
                }
            }
        });
        oyun.kare8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (egerKareSecilebilirse(7)){
                    performAction((ImageView) view,7);
                }
            }
        });
        oyun.kare9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (egerKareSecilebilirse(8)){
                    performAction((ImageView) view,8);
                }
            }
        });
    }
    private void performAction(ImageView imageView,int secilmisKarePozisyonu){
        karePozisyonlari[secilmisKarePozisyonu]=siradakiOyuncu;

        if(siradakiOyuncu==1){
            imageView.setImageResource(R.drawable.oo);
            if(sonuclariKontrolEt()){
                Sonuc sonuc= new Sonuc(MainActivity.this, oyun.oyuncuFn.getText().toString()+" kazandı.",
                        MainActivity.this);
                sonuc.setCancelable(false);
                sonuc.show();
            } else if (toplamdaSecilenKare == 9) {
                Sonuc sonuc= new Sonuc(MainActivity.this, "Berabere.",MainActivity.this);
                sonuc.setCancelable(false);
                sonuc.show();
            }
            else {
                siradakiOyuncuyuDegistir(2);
                toplamdaSecilenKare++;
            }}
        else{
                imageView.setImageResource(R.drawable.xx);
                if(sonuclariKontrolEt()){
                    Sonuc sonuc= new Sonuc(MainActivity.this, oyun.oyuncuSN.getText().toString()+" kazandı.",
                            MainActivity.this);
                    sonuc.setCancelable(false);
                    sonuc.show();
                } else if (toplamdaSecilenKare == 9) {
                    Sonuc sonuc= new Sonuc(MainActivity.this, "Berabere.",MainActivity.this);
                    sonuc.setCancelable(false);
                    sonuc.show();
                }
                else {
                    siradakiOyuncuyuDegistir(1);
                    toplamdaSecilenKare++;
                }

            }

        }


    private void siradakiOyuncuyuDegistir(int sirasiOlanOyuncu){
        siradakiOyuncu = sirasiOlanOyuncu;
        if (siradakiOyuncu==1){
            oyun.oyuncuFnLayout.setBackgroundResource(android.R.drawable.alert_dark_frame);
            oyun.oyuncuSNLayout.setBackgroundResource(android.R.drawable.alert_light_frame);
        }
        else {
            oyun.oyuncuSNLayout.setBackgroundResource(android.R.drawable.alert_dark_frame);
            oyun.oyuncuFnLayout.setBackgroundResource(android.R.drawable.alert_light_frame);

        }
    }
    private boolean sonuclariKontrolEt(){
        boolean response=false;
        for (int i=0;i<ihtimaller.size();i++){
            final int[] ihtimal=ihtimaller.get(i);

            if(karePozisyonlari[ihtimal[0]]==siradakiOyuncu && karePozisyonlari[ihtimal[1]]==siradakiOyuncu&&
            karePozisyonlari[ihtimal[2]]==siradakiOyuncu){
                response=true;
            }
        }
        return response;

    }
    private boolean egerKareSecilebilirse(int karePozisyonu){
        boolean response=false;
        if(karePozisyonlari[karePozisyonu]==0){
            response=true;
        }
        return response;
    }

    public void maciTekrarOyna(){
        karePozisyonlari = new int[] {0,0,0,0,0,0,0,0,0};
        siradakiOyuncu = 1;
        toplamdaSecilenKare = 1;

        oyun.kare1.setImageResource(R.drawable.transparentbg);
        oyun.kare2.setImageResource(R.drawable.transparentbg);
        oyun.kare3.setImageResource(R.drawable.transparentbg);
        oyun.kare4.setImageResource(R.drawable.transparentbg);
        oyun.kare5.setImageResource(R.drawable.transparentbg);
        oyun.kare6.setImageResource(R.drawable.transparentbg);
        oyun.kare7.setImageResource(R.drawable.transparentbg);
        oyun.kare8.setImageResource(R.drawable.transparentbg);
        oyun.kare9.setImageResource(R.drawable.transparentbg);

    }

    }
