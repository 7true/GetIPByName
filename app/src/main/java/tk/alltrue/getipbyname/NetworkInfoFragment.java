package tk.alltrue.getipbyname;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NetworkInfoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View networkFragmentView = inflater.inflate(R.layout.fragmentnetworkinfo, container, false);
        final ListView mListView = (ListView) networkFragmentView.findViewById(R.id.listViewNetworkInfo);

        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();

        List<String> listNetworkInfo = new ArrayList<String>();
        for (int i = 0; i < networkInfo.length; i++) {
            listNetworkInfo.add(networkInfo[i].toString());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1,
                listNetworkInfo);

        mListView.setAdapter(adapter);

        return networkFragmentView;
    }
}
