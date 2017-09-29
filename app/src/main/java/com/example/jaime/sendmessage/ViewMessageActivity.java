package com.example.jaime.sendmessage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.jaime.sendmessage.SendMessageActivity.MESSAGE_KEY;
import static com.example.jaime.sendmessage.SendMessageActivity.USER_KEY;

/**
 * Clase que recibe datos de otra Activity y lo muestra por pantalla.
 */
public class ViewMessageActivity extends AppCompatActivity {
    private TextView txvViewUser;
    private TextView txvViewMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_message);

        txvViewUser = (TextView) findViewById(R.id.txv_viewUser);
        txvViewMessage = (TextView) findViewById(R.id.txv_viewMessage);
    }


    @Override
    protected void onStart() {
        super.onStart();
        String user = getIntent().getStringExtra(USER_KEY);

        txvViewUser.setText("El ususario " + user + " a escrito el siguiente mensaje:");
        txvViewMessage.setText(getIntent().getStringExtra(MESSAGE_KEY));
    }
}
