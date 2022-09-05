package com.example.firstprog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    EditText etContact;
    TextView tvHome;

    public static String TAG = HomeActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        etContact = findViewById(R.id.etContact);
        tvHome = findViewById(R.id.tvHome);

        /*String name = getIntent().getExtras().getString("nkey");
        tvHome.setText("hello "+name);*/
    }

    public void handleClicks(View viewClicked) {

        //get the data to be sent
        String contactData = etContact.getText().toString();
        //send the data to the parent activity
        Intent dIntent = new Intent();
        dIntent.putExtra("con",contactData);
        setResult(RESULT_OK,dIntent); //smell-headsup to inform the parent activity
        //close this activity
        finish();

    }
}




