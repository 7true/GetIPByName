package tk.alltrue.getipbyname;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TrafficStatsFragments extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View trafficFragmentView = inflater.inflate(R.layout.fragmenttrafficstats, container, false);
        final TextView textMobileRxBytes = (TextView) trafficFragmentView.findViewById(R.id.tvMobileRxBytes);
        final TextView textMobileRxPackets = (TextView) trafficFragmentView.findViewById(R.id.tvMobileRxPackets);
        final TextView textMobileTxBytes = (TextView) trafficFragmentView.findViewById(R.id.tvMobileTxBytes);
        final TextView textMobileTxPackets = (TextView) trafficFragmentView.findViewById(R.id.tvMobileTxPackets);

        final TextView textTotalRxBytes = (TextView) trafficFragmentView.findViewById(R.id.tvTotalRxBytes);
        final TextView textTotalRxPackets = (TextView) trafficFragmentView.findViewById(R.id.tvTotalRxPackets);
        final TextView textTotalTxBytes = (TextView) trafficFragmentView.findViewById(R.id.tvTotalTxBytes);
        final TextView textTotalTxPackets = (TextView) trafficFragmentView.findViewById(R.id.tvTotalTxPackets);

        if (TrafficStats.getMobileRxBytes() == TrafficStats.UNSUPPORTED) {
            textMobileRxBytes.setText("MobileRxBytes: "
                    + "Не поддерживается!");
        } else {
            textMobileRxBytes.setText("MobileRxBytes: "
                    + String.valueOf(TrafficStats.getMobileRxBytes()));
        }

        if (TrafficStats.getMobileRxPackets() == TrafficStats.UNSUPPORTED) {
            textMobileRxPackets.setText("MobileRxPackets: "
                    + "Не поддерживается!");
        } else {
            textMobileRxPackets.setText("MobileRxPackets: "
                    + String.valueOf(TrafficStats.getMobileRxPackets()));
        }

        if (TrafficStats.getMobileTxBytes() == TrafficStats.UNSUPPORTED) {
            textMobileTxBytes.setText("MobileTxBytes: "
                    + "Не поддерживается!");
        } else {
            textMobileTxBytes.setText("MobileTxBytes: "
                    + String.valueOf(TrafficStats.getMobileTxBytes()));
        }

        if (TrafficStats.getMobileTxPackets() == TrafficStats.UNSUPPORTED) {
            textMobileTxPackets.setText("MobileTxPackets: "
                    + "Не поддерживается!");
        } else {
            textMobileTxPackets.setText("MobileTxPackets: "
                    + String.valueOf(TrafficStats.getMobileTxPackets()));
        }

        if (TrafficStats.getTotalRxBytes() == TrafficStats.UNSUPPORTED) {
            textTotalRxBytes.setText("TotalRxBytes: " + "Не поддерживается!");
        } else {
            textTotalRxBytes.setText("TotalRxBytes: "
                    + String.valueOf(TrafficStats.getTotalRxBytes()));
        }

        if (TrafficStats.getTotalRxPackets() == TrafficStats.UNSUPPORTED) {
            textTotalRxPackets.setText("TotalRxPackets: "
                    + "Не поддерживается!");
        } else {
            textTotalRxPackets.setText("TotalRxPackets: "
                    + String.valueOf(TrafficStats.getTotalRxPackets()));
        }

        if (TrafficStats.getTotalTxBytes() == TrafficStats.UNSUPPORTED) {
            textTotalTxBytes.setText("TotalTxBytes: " + "Не поддерживается!");
        } else {
            textTotalTxBytes.setText("TotalTxBytes: "
                    + String.valueOf(TrafficStats.getTotalTxBytes()));
        }

        if (TrafficStats.getTotalTxPackets() == TrafficStats.UNSUPPORTED) {
            textTotalTxPackets.setText("TotalTxPackets: "
                    + "Не поддерживается!");
        } else {
            textTotalTxPackets.setText("TotalTxPackets: "
                    + String.valueOf(TrafficStats.getTotalTxPackets()));
        }

        return trafficFragmentView;
    }
}
