package cf.techfusion.yasin.udacityquizchallange;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity  implements OnClickListener{
    private EditText username;
    private EditText email;
    private EditText about;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.username_input);
        email = (EditText) findViewById(R.id.email_input);
        about = (EditText) findViewById(R.id.about_input);
        nextButton = (Button) findViewById(R.id.next_button);
        nextButton.setOnClickListener(this);


        // ON rotate The State
        if(savedInstanceState != null && savedInstanceState.containsKey("username") && savedInstanceState.containsKey("email") && savedInstanceState.containsKey("about")){
            username.setText(savedInstanceState.getString("username"));
            email.setText(savedInstanceState.getString("email"));
            about.setText(savedInstanceState.getString("about"));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_ac_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        String usernameText = username.getText().toString();
        String emailText = email.getText().toString();
        String aboutText = about.getText().toString();
        outState.putString("username",usernameText);
        outState.putString("email",emailText);
        outState.putString("about",aboutText);
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.user_menu_item){
            Intent i = new Intent(this,DetailsActivity.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this,DetailsActivity.class);
        String usernameText = username.getText().toString();
        String emailText = email.getText().toString();
        String aboutText = about.getText().toString();
        i.putExtra("username",usernameText);
        i.putExtra("email",emailText);
        i.putExtra("about",aboutText);
        startActivity(i);
    }
}
