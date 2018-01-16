package com.app.adsdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();

    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Test Admob id : ca-app-pub-3940256099942544/6300978111
        MobileAds.initialize(this, "ca-app-pub-3940256099942544/6300978111");

        // Interstitial Ad
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        interstitialAd.loadAd(new AdRequest.Builder().build());

        Button btnshowInterStitialAd = findViewById(R.id.btn_show_interstitial_ad);
        btnshowInterStitialAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (interstitialAd.isLoaded()) {
                    interstitialAd.show();
                } else {
                    Log.d(TAG, "The interstitial wasn't loaded yet.");
                }
            }
        });

        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.d(TAG, "Interstitial Ad loaded!");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.

                Log.d(TAG, "Interstitial Ad failed : "+ errorCode);
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                Log.d(TAG, "Interstitial Ad Opened!");
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
                Log.d(TAG, "Interstitial Ad User left application!");
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the user is about to return
                // to the app after tapping on an ad.
                Log.d(TAG, "Interstitial Ad closed!");
            }
        });

        // Banner Ad
        AdView adView = findViewById(R.id.ad_view);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        adView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.d(TAG, "Ad loaded!");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.

                Log.d(TAG, "Ad failed : "+ errorCode);
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                Log.d(TAG, "Ad Opened!");
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
                Log.d(TAG, "Ad User left application!");
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the user is about to return
                // to the app after tapping on an ad.
                Log.d(TAG, "Ad closed!");
            }
        });
    }
}