package jugar.mcm.edu.ph;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import jugar.mcm.edu.ph.R;
import jugar.mcm.edu.ph.SecActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String myUsername = "Hernan";
        final String myPassword = "1234";

        final EditText callUsername = findViewById(R.id.userName);
        final EditText callPassword = findViewById(R.id.passWord);
        final Button callLogin = findViewById(R.id.login);

        callUsername.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        callUsername.setText("");
                    }
                }
        );

        callPassword.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        callPassword.setText("");
                    }
                }
        );
        callLogin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String typePassword = String.valueOf(callPassword.getText());
                        String typeUsername = String.valueOf(callUsername.getText());

                        if(typePassword.equals(myPassword) && typeUsername.equalsIgnoreCase(myUsername)) {
                            Intent intent1 = new Intent(MainActivity.this, SecActivity.class);
                            startActivity(intent1);

                        } else if(typePassword != myPassword || typeUsername != myUsername) {
                            Toast.makeText(MainActivity.this,
                                    "Incorrect username or password",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}