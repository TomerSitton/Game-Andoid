package com.appetizers.app.serverapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * The activity handling the connection to the server
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * The "connect to server" button
     */
    Button btnGo;
    /**
     * The field to insert the IP to
     */
    EditText editIP;

    /**
     * The first method that runs when the activity is created.
     * initializes the button and the textField
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGo = findViewById(R.id.btn_go);
        editIP = findViewById(R.id.edit_ip);

        btnGo.setOnClickListener(this);
    }

    /**
     * runs when the button is clicked.
     * when the button is clicked, start the second activity
     * @param v
     */
    @Override
    public void onClick(View v) {
        Intent in = new Intent(this,Main2Activity.class);
        in.putExtra("ip",editIP.getText().toString());
        startActivity(in);
    }
}
