package com.appetizers.app.serverapp;

/**
 * Created by Alon on 22-May-18.
 */

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * This class receives the information from the server
 */
public class ServerTask extends AsyncTask<Void,String,Void> {
    /**
     * the ip address of the server
     */
    String ip;
    /**
     * the port on which the program runs on the server
     */
    int port;
    /**
     * the activity to send the data to
     */
    Main2Activity activity;
    /**
     * the data received from the server
     */
    String line;

    /**
     * This constructs a new {@link ServerTask}
     * @param ip the ip address of the server
     * @param port the port on which the program runs on the server
     * @param activity the activity to send the data to
     */
    public ServerTask(String ip, int port, Main2Activity activity) {
        this.ip = ip;
        this.port = port;
        this.activity = activity;
    }

    /**
     * this creates the connection to the server and receives information from it
     * @param voids
     * @return null
     */
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            Socket socket=new Socket(ip,port);
            BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            line=reader.readLine();
            while (line!=null&&!line.equals("Bye"))
            {
                publishProgress(line);
                line=reader.readLine();
                Thread.sleep((long) 0.05);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * this method sends the data to the {@link Main2Activity} activity
     * @param values
     */
    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        activity.useData(values[0]);
    }
}

