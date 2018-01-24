package comblog.wixsite.ayushgemini.sendmessage;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btnSendMessage;
    private EditText edtNumber, edtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSendMessage = (Button)findViewById(R.id.btn_send);
        edtNumber = (EditText)findViewById(R.id.edt_number);
        edtMessage = (EditText)findViewById(R.id.edt_message);
        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String number = String.valueOf(edtNumber.getText());
                String message = String.valueOf(edtMessage.getText());
                if(!isValidNumber(number)){
                    edtNumber.setError("Invalid Number");
                }
                else {
                    if (!isValid(message)) {
                        edtMessage.setError("Invalid Message");
                    }
                    else{
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + number));
                        intent.putExtra("sms_body",message);
                        startActivity(intent);
                    }
                }

            }
        });
    }
    // validating editText
    private boolean isValid(String value) {
        if (value != null && value.length()>0) {
            return true;
        }
        return false;
    }
    // validating Phone Number
    private boolean isValidNumber(String value) {
        if (value != null && value.length()==10) {
            return true;
        }
        return false;
    }
}


