package com.appetizers.app.serverapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * The second activity.
 * shows the client the health of each player
 */
public class Main2Activity extends AppCompatActivity {
    /**
     * the text which will show the health
     */
    TextView details;

    /**
     * runs when the activity is created.
     * runs the {@link ServerTask#execute(Object[])}.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        details =findViewById(R.id.txt_details);

        String ip=getIntent().getStringExtra("ip");
        ServerTask server=new ServerTask(ip,2212,this);
        server.execute();
    }

    /**
     * sets the data to the details {@link TextView}
     * @param data - the data received from the server
     */
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


        details.setText(text);
    }
}
