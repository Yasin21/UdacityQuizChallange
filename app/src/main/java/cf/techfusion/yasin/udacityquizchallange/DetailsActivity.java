package cf.techfusion.yasin.udacityquizchallange;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private TextView username;
    private TextView email;
    private TextView about;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        username = (TextView) findViewById(R.id.username_text);
        email = (TextView) findViewById(R.id.email_text);
        about = (TextView) findViewById(R.id.about_text);

        Intent i = getIntent();
        if(i.hasExtra("username") && i.hasExtra("email") && i.hasExtra("about")) {
            username.setText(i.getStringExtra("username"));
            email.setText(i.getStringExtra("email"));
            about.setText(i.getStringExtra("about"));
        }
    }
}
