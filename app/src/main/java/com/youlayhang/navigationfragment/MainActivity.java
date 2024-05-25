package com.youlayhang.navigationfragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.nav);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                final int menuId = menuItem.getItemId();
                int menuId = menuItem.getItemId();
                if(menuId == R.id.message_menu){
                    drawerLayout.closeDrawer(GravityCompat.START);
                    fragmentContent(new MessageFragment());
                    Toast.makeText(MainActivity.this,"Message",Toast.LENGTH_LONG).show();
                } else if (menuId == R.id.Explor_menu) {
                    fragmentContent(new ExplorFragment());
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(MainActivity.this,"Explor",Toast.LENGTH_LONG).show();
                } else if(menuId == R.id.Comment_menu){
                    drawerLayout.closeDrawer(GravityCompat.START);
                    fragmentContent(new CommentFragment());
                    Toast.makeText(MainActivity.this,"Comment",Toast.LENGTH_LONG).show();
                } else if (menuId == R.id.Share_menu) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    fragmentContent(new ShareFragment());
                    Toast.makeText(MainActivity.this,"Share",Toast.LENGTH_LONG).show();
                } else if (menuId == R.id.Send_menu){
                    drawerLayout.closeDrawer(GravityCompat.START);
                    fragmentContent(new SendFragment());
                    Toast.makeText(MainActivity.this,"Send",Toast.LENGTH_LONG).show();
                }

                return true;
            }
        });
    }

    private void fragmentContent(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}