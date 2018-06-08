package com.appetizers.app.serverapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnGo;
    EditText editIP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGo = findViewById(R.id.btn_go);
        editIP = findViewById(R.id.edit_ip);

        btnGo.setOnClickListener(this);
    }

    @Override

    public void onClick(View v) {
        Intent in = new Intent(this,Main2Activity.class);
        in.putExtra("ip",editIP.getText().toString());
        startActivity(in);
    }
}
