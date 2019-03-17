package tk.alltrue.getipbyname;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText mHostEditText;
    private TextView mInfoTextView;
    private Button mIpButton;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHostEditText = findViewById(R.id.editTextHost);
        mInfoTextView = findViewById(R.id.textViewInfo);
        mListView = findViewById(R.id.listViewResult);
        mIpButton = (Button) findViewById(R.id.buttonIP);
        mIpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mInfoTextView.setText("Подождите...");
                new GetIPTask().execute();
            }
        });
    }
    private class GetIPTask extends AsyncTask<Void, Void, Void> {
        boolean error = false;
        String error_info = "";
        InetAddress[] inetAddress = null;

        List<String> hostList = new ArrayList<>();

        @Override
        protected Void doInBackground(Void... arg0) {
            getIP();
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            if (error) {
                mInfoTextView.setText("Error: \n" + error_info);
            } else {
                mInfoTextView.setText("Finished, ok");

                ArrayAdapter<String> adapter = new ArrayAdapter<>(
                        MainActivity.this, android.R.layout.simple_list_item_1,
                        hostList);

                mListView.setAdapter(adapter);
            }
            super.onPostExecute(result);
        }

        private void getIP() {
            String host = mHostEditText.getText().toString();

            try {
                inetAddress = InetAddress.getAllByName(host);

                for (InetAddress inetAddres : inetAddress) {
                    hostList.add(inetAddres.getHostName() + "\n"
                            + inetAddres.getHostAddress());
                }

            } catch (UnknownHostException e) {
                e.printStackTrace();
                error = true;
                error_info = e.toString();
            }
        }
    }
}
