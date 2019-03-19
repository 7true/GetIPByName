package tk.alltrue.getipbyname;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NetWorkInfoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View networkFragmentView = inflater.inflate(R.layout.fragmentnetworkinfo, container, false);
        return networkFragmentView;
    }
}
