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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSend = (Button) this.findViewById(R.id.button);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup rgMailTo = (RadioGroup) findViewById(R.id.rg_mailTo);
                int checkedId = rgMailTo.getCheckedRadioButtonId();
                String mailTo = ((RadioButton) findViewById(checkedId)).getText().toString();
                //int intMailTo = ((RadioButton) findViewById(checkedId)).getId();

                Log.d("mailTo:", mailTo);
                Log.d("checkedId:", "checkedId:" + checkedId);

                //EditText edit01 = (EditText) findViewById(R.id.editText);
                //String title = edit01.getText().toString();

                Resources res = getResources();
                Uri uri = null;
                switch (mailTo)
                {
                    case "ドコモ":
                        uri = Uri.parse("mailto:" + res.getString(R.string.mail_to_docomo).toString());
                        break;
                    case "Yahoo":
                        uri = Uri.parse("mailto:" + res.getString(R.string.mail_to_yahoo).toString());
                        break;
                    case "Gmail":
                        uri = Uri.parse("mailto:" + res.getString(R.string.mail_to_yahoo).toString());
                        break;
                }

                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra(Intent.EXTRA_SUBJECT, "");
                intent.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(intent);

            }
        });
    }
}
