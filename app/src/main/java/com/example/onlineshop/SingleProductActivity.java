package com.example.onlineshop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SingleProductActivity extends AppCompatActivity {

    ImageView image;
    TextView name;
    TextView description;
    TextView amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_single_product);

        image=findViewById(R.id.image);
        name=findViewById(R.id.name);
        amount=findViewById(R.id.amount);
        description=findViewById(R.id.description);

        Intent intent =getIntent();
        String productName=intent.getExtras().getString("name");
        int productImage=intent.getExtras().getInt("image");
        String ProductAmount=intent.getExtras().getString("amount");
        String ProductDescription=intent.getExtras().getString("description");

        image.setImageResource(productImage);
        name.setText(productName);
        amount.setText(ProductAmount);
        description.setText(ProductDescription);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}