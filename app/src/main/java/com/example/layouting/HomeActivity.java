package com.example.layouting;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        String name = intent.getStringExtra("userName");
        String nim = intent.getStringExtra("userNIM");
        String role = intent.getStringExtra("userRole");

        TextView nameTextView = findViewById(R.id.homeNameTV);
        TextView roleTextView = findViewById(R.id.homeRoleTV);
        TextView nimTextView = findViewById(R.id.homeNimTV);

        String displayName = formatDisplayName(name);
        nameTextView.setText(displayName);
        roleTextView.setText(role);
        nimTextView.setText(nim);
    }

    private String formatDisplayName(String fullName) {
        String[] nameParts = fullName.split(" ");
        String displayName;

        if (nameParts.length > 2) {
            displayName = nameParts[0] + " " + nameParts[1] + " " + nameParts[nameParts.length - 1].charAt(0) + ".";
        } else {
            displayName = fullName;
        }

        return displayName;
    }
}