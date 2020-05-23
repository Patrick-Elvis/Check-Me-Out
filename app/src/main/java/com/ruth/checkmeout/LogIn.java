package com.ruth.checkmeout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LogIn extends AppCompatActivity {
    private Context context;
    private ActionBarDrawerToggle t;

    @BindView(R.id.activity_main) DrawerLayout dl;
    @BindView(R.id.navigation) NavigationView nv;
    @BindView(R.id.link_signup)
    TextView link_signup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        ButterKnife.bind(this);
        t=new ActionBarDrawerToggle(this,dl,R.string.Open,R.string.Close);
        t.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(t);
        t.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //signup
        link_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LogIn.this,SignUp.class);
                startActivity(intent);
            }
        });
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                switch (id){

                    case R.id.about:
                        Toast.makeText(LogIn.this, "About",Toast.LENGTH_SHORT).show();break;
                    case R.id.expenses:
                        Toast.makeText(LogIn.this, "Expenses",Toast.LENGTH_SHORT).show();break;
                    case R.id.shop:
                        Toast.makeText(LogIn.this, "Shop",Toast.LENGTH_SHORT).show();break;

                    case R.id.account:
                        Toast.makeText(LogIn.this, "My Account",Toast.LENGTH_SHORT).show();break;

                    case  R.id.home:
                        Toast.makeText(LogIn.this, "Home",Toast.LENGTH_SHORT).show();break;

                    default:
                        return true;
                }
                return true;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                dl.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
