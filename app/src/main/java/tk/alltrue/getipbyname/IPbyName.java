package tk.alltrue.getipbyname;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class IPbyName extends Fragment {
    private TextView mInfoTextView;
    private ListView mListView;
    private EditText mHostEditText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View ipView = inflater.inflate(R.layout.fragmentip, container, false);
        //View mainView = inflater.inflate(R.layout.activity_main, container, false);
        //mListView = (ListView) ipView.findViewById(R.id.listViewNetworkInfo);

        //EditText mHostEditText = (EditText)  getActivity().findViewById(R.id.editTextHost);


        Button mBtst = (Button) ipView.findViewById(R.id.buttonIPtest);
        mBtst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView mTextView =  ((TextView) (getActivity()).findViewById(R.id.textViewInfo));
                mTextView.setText("Waiting...");
            }
        });
      // mTextView.setText("Waiting...");
       //new GetIPTask().execute();
        return ipView;
    }

    @Override

    /*
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
                        getActivity(), android.R.layout.simple_list_item_1,
                        hostList);

                mListView.setAdapter(adapter);
            }
            super.onPostExecute(result);
        }

        private void getIP() {
            String host = mHostEditText.getText().toString();

            if (!isOnline()) {
                getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        Toast.makeText(getActivity(), "You are offline, please turn on your network", Toast.LENGTH_SHORT).show();
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
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        } else {
            return false;
        }
    }*/
}