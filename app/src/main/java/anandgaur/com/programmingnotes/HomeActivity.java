package anandgaur.com.programmingnotes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Button btnCplus,btnJava,btnAndroid,btnJavaScript,btnPHP,btnPython,btnSQL,btnNodeJs,btnMongoDb;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnCplus=(Button)findViewById(R.id.btnCplus);
        btnJava=(Button)findViewById(R.id.btnJava);
        btnAndroid=(Button)findViewById(R.id.btnAndroid);
        btnJavaScript=(Button)findViewById(R.id.btnJavaScript);
        btnPHP=(Button)findViewById(R.id.btnPHP);
        btnPython=(Button)findViewById(R.id.btnPython);
        btnSQL=(Button)findViewById(R.id.btnSQL);
        btnNodeJs=(Button)findViewById(R.id.btnNodeJs);
        btnMongoDb=(Button)findViewById(R.id.btnMongoDb);


        btnCplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), CplusActivity.class));

            }
        });

        btnJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), JavaActivity.class));

            }
        });

        btnAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), AndroidActivity.class));

            }
        });

        btnJavaScript.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), JavaScriptActivity.class));

            }
        });
        btnPHP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), PHPActivity.class));

            }
        });
        btnPython.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), PythonActivity.class));

            }
        });

        btnSQL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), SQLActivity.class));

            }
        });
        btnNodeJs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), NodeJsActivity.class));

            }
        });
        btnMongoDb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), MongoDbActivity.class));

            }
        });


        // initialize the AdMob app
        MobileAds.initialize(this, getString(R.string.admob_app_id));
        mAdView = (AdView) findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);


        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
            }

        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=anandgaur.com.programmingnotes"));
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        }
        else if (id == R.id.nav_about) {
            startActivity(new Intent(getApplicationContext(), AboutActivity.class));

        }else if (id == R.id.nav_share) {

            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBodyText = "Programming Notes  is Awesome App! \nYou Can Learn Top Programming Language In one App, Programming notes are explain by Theory and practical both . Easy To Understand Programming very Easily  and lots of features. \n https://play.google.com/store/apps/details?id=anandgaur.com.programmingnotes \n I am sure you'll love it.";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Programming Notes");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
            startActivity(Intent.createChooser(sharingIntent, "Share Via "));

        } else if (id == R.id.nav_rate) {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=anandgaur.com.programmingnotes"));
            startActivity(i);
        } else if (id == R.id.nav_lectApp) {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=anandgaur.com.lecturerassistants"));
            startActivity(i);

        } else if (id == R.id.nav_fb) {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/tutorialsaddas"));
            startActivity(i);

        }
        else if (id == R.id.nav_instagram) {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/tutorials_adda_and_technology"));
            startActivity(i);

        }
        else if (id == R.id.nav_blog) {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://tutorialsaddas.blogspot.in"));
            startActivity(i);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
}
