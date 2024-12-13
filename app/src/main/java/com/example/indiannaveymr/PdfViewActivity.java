package com.example.indiannaveymr;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.indiannaveymr.databinding.ActivityPdfViewBinding;
import com.github.pdfviewer.PDFView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class PdfViewActivity extends AppCompatActivity {

   // PDFView pdfView;
   // TextView chapterName;

   ActivityPdfViewBinding binding;

    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPdfViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        AdRequest adRequest = new AdRequest.Builder().build();
        binding.adsview.loadAd(adRequest);


        loadInterstitial();


        int position = getIntent().getIntExtra("position",0);
        String chapter = getIntent().getStringExtra("name");
        binding.chapterNames.setText(chapter);

        if (position==0){
            binding.pdfView.fromAsset("PDF3.pdf").load();

        } else if (position==1) {
            binding.pdfView.fromAsset("PDF2.pdf").load();
            binding.chapterNames.setText(chapter);
        }
        else if (position==2) {
            binding.pdfView.fromAsset("PDF2.pdf").load();
            binding.chapterNames.setText(chapter);
        }


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (mInterstitialAd != null ){

                    mInterstitialAd.show(PdfViewActivity.this);
                }

            }
        },2000);


    }

    private void loadInterstitial() {

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {

            }
        });


        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;

                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error

                        mInterstitialAd = null;
                    }
                });
    }
}