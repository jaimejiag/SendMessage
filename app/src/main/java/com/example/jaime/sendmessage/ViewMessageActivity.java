package com.example.jaime.sendmessage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.jaime.sendmessage.pojo.Mensaje;

import static com.example.jaime.sendmessage.SendMessageActivity.DATA_KEY;
import static com.example.jaime.sendmessage.SendMessageActivity.MESSAGE_KEY;

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
        Bundle bundle = getIntent().getBundleExtra(DATA_KEY);
        Mensaje mensaje = bundle.getParcelable(MESSAGE_KEY);

        txvViewUser.setText("El ususario " + mensaje.getUser() + " a escrito el siguiente mensaje:");
        txvViewMessage.setText(mensaje.getMessage());
    }
}
