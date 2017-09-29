package com.example.jaime.sendmessage;

import android.content.Intent;
import android.os.Message;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.jaime.sendmessage.pojo.Mensaje;

/**
 * Clase que envía datos a otra Activity.
 */
public class SendMessageActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String DATA_KEY = "datakey";
    public static final String MESSAGE_KEY = "messagekey";

    private EditText edtUser;
    private EditText edtMessage;
    private Button btnOk;
    private ViewGroup layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        edtUser = (EditText) findViewById(R.id.edt_user);
        edtMessage = (EditText) findViewById(R.id.edt_message);
        layout = (ConstraintLayout) findViewById(R.id.layout_sendMessage);

        btnOk = (Button) findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(this);
    }


    private boolean checkData() {
        boolean result = true;

        if (TextUtils.isEmpty(edtUser.getText().toString()))
            result = false;

        if (TextUtils.isEmpty(edtMessage.getText().toString()))
            result = false;

        return result;
    }


    @Override
    public void onClick(View view) {
        boolean dataOk = checkData();

        if (dataOk) {
            Intent intent = new Intent(this, ViewMessageActivity.class);
            Bundle bundle = new Bundle();
            Mensaje mensaje = new Mensaje(edtUser.getText().toString(), edtMessage.getText().toString());

            bundle.putParcelable(MESSAGE_KEY, mensaje);
            intent.putExtra(DATA_KEY, bundle);
            startActivity(intent);
        } else
            Snackbar.make(layout, "Hay datos sin añadir", Snackbar.LENGTH_SHORT).show();
    }
}
