package com.example.masayuki.twotouchmail;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.telephony.SmsManager;
import android.app.AlertDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSend = (Button) this.findViewById(R.id.button);
        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //EditText editText = (EditText) this.findViewById(R.id.editText);
        RadioGroup rgMailTo = (RadioGroup) findViewById(R.id.rg_mailTo);
        int checkedId = rgMailTo.getCheckedRadioButtonId();
        String mailTo = ((RadioButton) findViewById(checkedId)).getText().toString();

        Resources res = getResources();
        Uri uri = null;
        switch (mailTo) {
            case "ドコモ":
                uri = Uri.parse("mailto:" + res.getString(R.string.mail_to_docomo).toString());
                break;
            case "Yahoo":
                uri = Uri.parse("mailto:" + res.getString(R.string.mail_to_yahoo).toString());
                break;
            case "Gmail":
                uri = Uri.parse("mailto:" + res.getString(R.string.mail_to_yahoo).toString());
                break;
            case "悠太":
                uri = Uri.parse("sms:" + res.getString(R.string.mail_to_yuta).toString());

                /*if (editText.getText().toString().equals(""))
                {
                    AlertDialog.Builder alert = new AlertDialog.Builder(this);
                    alert.setTitle(res.getString(R.string.error_title_msg).toString());
                    alert.setMessage(res.getString(R.string.not_input_msg).toString());
                    alert.setIcon(R.drawable.error);
                    alert.setPositiveButton("OK", null);
                    alert.show();
                }*/
                /*else
                {
                    SmsManager smsManager = SmsManager.getDefault();

                    String destinationAddress = res.getString(R.string.mail_to_yuta).toString();
                    String scAddress = null;
                    String text = editText.getText().toString();
                    smsManager.sendTextMessage(destinationAddress, scAddress, text, null, null);
                }*/
                break;
        }

        //if (mailTo.equals(res.getString(R.string.docomo).toString()) || mailTo.equals(res.getString(R.string.yahoo).toString()) || mailTo.equals(res.getString(R.string.gmail).toString())) {
            Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
            intent.putExtra(Intent.EXTRA_SUBJECT, "");
            intent.putExtra(Intent.EXTRA_TEXT, "");
            startActivity(intent);
        //}
    }
}