package tk.alltrue.getipbyname;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TrafficStatsFragments extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View trafficFragmentView = inflater.inflate(R.layout.fragmenttrafficstats, container, false);
        return trafficFragmentView;
    }
}
