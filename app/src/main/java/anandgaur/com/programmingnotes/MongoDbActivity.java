package anandgaur.com.programmingnotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MongoDbActivity extends AppCompatActivity {

    public PDFView pdfView;
    public float zoomValue=1;

    InterstitialAd mInterstitialAd;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mongo_db);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);

        pdfView=(PDFView)findViewById(R.id.pdfView);
        pdfView.fromAsset("MongoDBNotes.pdf").defaultPage(1)
                .spacing(10).load();

        // initialize the AdMob app
        MobileAds.initialize(this, getString(R.string.admob_app_id));
        mAdView = (AdView) findViewById(R.id.adView);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_mongo_db));

        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);

        // Load ads into Interstitial Ads
        mInterstitialAd.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
            }

        });

        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitial();
            }
        });
    }

    public void nextPage(View view)
    {
        pdfView.jumpTo(pdfView.getCurrentPage()+1,true);
    }

    public void prevPage(View view)
    {
        pdfView.jumpTo(pdfView.getCurrentPage()-1,true);
    }

    public void zoomIn(View view)
    {
        ++zoomValue;
        pdfView.zoomTo(zoomValue);
        pdfView.loadPages();

    }
    public void zoomOut(View view)
    {
        if (zoomValue!=1) {
            --zoomValue;
            pdfView.zoomTo(zoomValue);
            pdfView.loadPages();
        }
    }

    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }
    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
