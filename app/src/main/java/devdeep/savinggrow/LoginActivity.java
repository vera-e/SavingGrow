package devdeep.savinggrow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements LoginDialog.LoginDialogListener{
    private TextView textViewUsername;
    private TextView textViewPassword;
    private Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textViewUsername = (TextView) findViewById(R.id.tv_username);
        textViewPassword = (TextView) findViewById(R.id.tv_password);
        button = (Button) findViewById(R.id.btn_log);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
    }

    public void openDialog(){
        LoginDialog loginDialog = new LoginDialog();
        loginDialog.show(getSupportFragmentManager(),"login dialog");
    }

    @Override
    public void appleTexts(String username, String password) {
        textViewUsername.setText(username);
        textViewPassword.setText(password);
    }
}
