package com.example.onlineshop;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    List<ModelClass> productList;

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    Adapter adapter;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.settings){
            Toast.makeText(DashboardActivity.this,"You clicked settings",Toast.LENGTH_LONG).show();
        }
        else if (id==R.id.logout) {
            Toast.makeText(DashboardActivity.this,"You clicked logout",Toast.LENGTH_LONG).show();
        }
        else if (id==R.id.about) {
            Toast.makeText(DashboardActivity.this,"You clicked About",Toast.LENGTH_LONG).show();
        }
        else if (id==R.id.share) {
            Toast.makeText(DashboardActivity.this,"You clicked Share",Toast.LENGTH_LONG).show();
        }
        else {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);

        initData();
        initRecylerView();

        drawerLayout=findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.nav_view);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        navigationView.bringToFront();
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_nav,R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.home);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }

    private void initData() {
        productList=new ArrayList<>();
        productList.add(new ModelClass(R.drawable.mango,"Mango","KSh 50","Its a very delicious fruit,It increases the body immunity and protection against diseases"));
        productList.add(new ModelClass(R.drawable.banana,"Banana","KSh 20","Its a very delicious fruit,It increases the body immunity and protection against diseases"));
        productList.add(new ModelClass(R.drawable.pineapple,"Pineapple","KSh 300","Its a very delicious fruit,It increases the body immunity and protection against diseases"));
        productList.add(new ModelClass(R.drawable.passion,"Passion Fruit","KSh 500","Its a very delicious fruit,It increases the body immunity and protection against diseases"));
        productList.add(new ModelClass(R.drawable.ovacado,"Ovacado","KSh 60","Its a very delicious fruit,It increases the body immunity and protection against diseases"));
        productList.add(new ModelClass(R.drawable.mango,"Mango","KSh 50","Its a very delicious fruit,It increases the body immunity and protection against diseases"));
        productList.add(new ModelClass(R.drawable.banana,"Banana","KSh 20","Its a very delicious fruit,It increases the body immunity and protection against diseases"));
        productList.add(new ModelClass(R.drawable.pineapple,"Pineapple","KSh 300","Its a very delicious fruit,It increases the body immunity and protection against diseases"));
        productList.add(new ModelClass(R.drawable.passion,"Passion Fruit","KSh 500","Its a very delicious fruit,It increases the body immunity and protection against diseases"));
        productList.add(new ModelClass(R.drawable.ovacado,"Ovacado","KSh 60","Its a very delicious fruit,It increases the body immunity and protection against diseases"));
    }

    private void initRecylerView() {
        recyclerView=findViewById(R.id.recycler);
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter=new Adapter(productList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id=menuItem.getItemId();
        if(id==R.id.home){
            Toast.makeText(DashboardActivity.this,"You clicked home",Toast.LENGTH_LONG).show();
        }
        else if (id==R.id.logout) {
            Toast.makeText(DashboardActivity.this,"You clicked logout",Toast.LENGTH_LONG).show();
        }
        else if (id==R.id.about) {
            Toast.makeText(DashboardActivity.this,"You clicked About",Toast.LENGTH_LONG).show();
        }
        else if (id==R.id.share) {
            Toast.makeText(DashboardActivity.this,"You clicked Share",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(DashboardActivity.this,"You clicked Settings",Toast.LENGTH_LONG).show();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}