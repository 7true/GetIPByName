package tk.alltrue.getipbyname;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Button mIpButton;
    private Button mNetworkInfoButton;
    private Button mTrafficStatsButton;
    private Button mInterfacesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIpButton = findViewById(R.id.buttonIP);
        mNetworkInfoButton = findViewById(R.id.buttonNetworkInfo);
        mTrafficStatsButton = findViewById(R.id.buttonTrafficStats);
        mInterfacesButton = findViewById(R.id.buttonInt);

        mIpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new IPbyNameFragment());
            }
        });

        mNetworkInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new NetworkInfoFragment());
            }
        });

        mTrafficStatsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new TrafficStatsFragments());
            }
        });

        mInterfacesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new InterfacesFragment());
            }
        });

    }

    private void replaceFragment(Fragment fr){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place, fr);
        fragmentTransaction.commit();
    }

}
