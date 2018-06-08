package com.appetizers.app.serverapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView detalies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        detalies=findViewById(R.id.txt_details);

        String ip=getIntent().getStringExtra("ip");
        ServerTask server=new ServerTask(ip,2212,this);
        server.execute();
    }
    public void useData(String data){
        String text = "";
        if (data.contains("player")){
            String [] datas = data.split("\t");
            for (String txt : datas){
                text = text + txt + "\n";
            }
        }
        else
            text = "the winner is player number "+data;


        detalies.setText(text);
    }
}
