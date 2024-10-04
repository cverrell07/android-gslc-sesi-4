package com.example.layouting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText mainNameTxt;
    private EditText mainNimTxt;
    private Spinner mainRoleSpinner;
    private Button mainRegisterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main);

        mainNameTxt = findViewById(R.id.mainNameTxt);
        mainNimTxt = findViewById(R.id.mainNimTxt);
        mainRoleSpinner = findViewById(R.id.mainRoleSpinner);
        mainRegisterBtn = findViewById(R.id.mainRegisterBtn);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.role_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mainRoleSpinner.setAdapter(adapter);

        mainRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mainNameTxt.getText().toString().trim();
                String nim = mainNimTxt.getText().toString().trim();
                String role = mainRoleSpinner.getSelectedItem().toString();

                if (name.isEmpty() || nim.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                intent.putExtra("userName", name);
                intent.putExtra("userNIM", nim);
                intent.putExtra("userRole", role);
                startActivity(intent);
                finish();
            }
        });
    }
}