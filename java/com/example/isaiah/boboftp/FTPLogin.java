package com.example.isaiah.boboftp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class FTPLogin extends ActionBarActivity {
    public String hello = "hello";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ftplogin);

        final EditText addressTxt = (EditText) findViewById(R.id.address);
        final EditText usernameTxt = (EditText) findViewById(R.id.username);
        final EditText passwordTxt = (EditText) findViewById(R.id.password);
        final EditText portTxt = (EditText) findViewById(R.id.port);
        final Button loginBtn = (Button) findViewById(R.id.btnLogin);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String address = addressTxt.getText().toString();
                String username = usernameTxt.getText().toString();
                String password = passwordTxt.getText().toString();
                String port = portTxt.getText().toString();

                Intent i = new Intent(FTPLogin.this, FTPMain.class);
                i.putExtra("address",address);
                i.putExtra("username", username);
                i.putExtra("password", password);
                i.putExtra("port", port);
                startActivity(i);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ftplogin, menu);
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
