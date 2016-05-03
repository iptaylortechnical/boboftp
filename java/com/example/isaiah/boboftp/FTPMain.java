package com.example.isaiah.boboftp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.commons.net.ftp.FTPClient;
import org.w3c.dom.Text;

import java.io.IOException;


public class FTPMain extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        TextView viewMain = (TextView) findViewById(R.id.listView);

        TextView add = (TextView) findViewById(R.id.addressView);
        TextView usr = (TextView) findViewById(R.id.usernameView);
        TextView pword = (TextView) findViewById(R.id.passwordView);
        TextView portv = (TextView) findViewById(R.id.portView);

        Bundle b = getIntent().getExtras();

        String address = b.getString("address");
        String username = b.getString("username");
        String password = b.getString("password");
        String port = b.getString("port");

        try {
            go(address, username, password, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void go(String address, String username, String password, String port) throws IOException {
        FTPClient client = new FTPClient();
        TextView viewMain = (TextView) findViewById(R.id.listView);
//        client.setDefaultPort(Integer.parseInt(port));
        client.connect(address);
//        client.login(username, password);
//        String list = client.listDirectories().toString();

//        viewMain.setText(list);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_temp, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
