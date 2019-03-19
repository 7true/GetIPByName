package tk.alltrue.getipbyname;

import android.app.Activity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText mHostEditText;
    private TextView mInfoTextView;
    private Button mIpButton;
    private Button mNetworkInfoButton;
    private ListView mListView;
    Fragment fragment;
    private FragmentActivity myContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHostEditText = findViewById(R.id.editTextHost);
        mInfoTextView = findViewById(R.id.textViewInfo);
        mListView = findViewById(R.id.listViewResult);
        mIpButton = findViewById(R.id.buttonIP);
        mNetworkInfoButton = findViewById(R.id.buttonNetworkInfo);

        FragmentManager fragmentManager = myContext.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        NetWorkInfoFragment myFragment = new NetWorkInfoFragment();
        fragmentTransaction.add(R.id.myfragment, myFragment);
        fragmentTransaction.commit();
        mIpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mInfoTextView.setText("Waiting...");
                new GetIPTask().execute();
            }
        });

        mNetworkInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment newFragment;
                newFragment = new NetWorkInfoFragment();
                ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();

                List<String> listNetworkInfo = new ArrayList<String>();
                for (int i = 0; i < networkInfo.length; i++) {
                    listNetworkInfo.add(networkInfo[i].toString());
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                        MainActivity.this, android.R.layout.simple_list_item_1,
                        listNetworkInfo);

                mListView.setAdapter(adapter);

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
                if (!isOnline()) {
                    mInfoTextView.setText("You are offline");
                    return;
                }
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

            if (!isOnline()) {
                MainActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        Toast.makeText(MainActivity.this, "You are offline, please turn on your network", Toast.LENGTH_SHORT).show();
                    }
                });
                return;
            }
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

    public boolean isOnline() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        } else {
            return false;
        }
    }
}
