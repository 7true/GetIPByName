package tk.alltrue.getipbyname;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class InterfacesFragment extends Fragment {
    private View interfacesView;
    private TextView mInterfacesTextView;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        interfacesView = inflater.inflate(R.layout.fragmentinterfaces, container, false);
        mInterfacesTextView = interfacesView.findViewById(R.id.textViewInterfaces);
        mInterfacesTextView.setText(getIpAddress());
        return interfacesView;
    }

    private String getIpAddress() {
        String ip = "";
        try {
            Enumeration<NetworkInterface> enumNetworkInterfaces = NetworkInterface
                    .getNetworkInterfaces();
            while (enumNetworkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = enumNetworkInterfaces
                        .nextElement();
                Enumeration<InetAddress> enumInetAddress = networkInterface
                        .getInetAddresses();
                while (enumInetAddress.hasMoreElements()) {
                    InetAddress inetAddress = enumInetAddress.nextElement();

                    String ipAddress = "";
                    if (inetAddress.isLoopbackAddress()) {
                        ipAddress = "LoopbackAddress: ";
                    } else if (inetAddress.isSiteLocalAddress()) {
                        ipAddress = "SiteLocalAddress: ";
                    } else if (inetAddress.isLinkLocalAddress()) {
                        ipAddress = "LinkLocalAddress: ";
                    } else if (inetAddress.isMulticastAddress()) {
                        ipAddress = "MulticastAddress: ";
                    }
                    ip += ipAddress + inetAddress.getHostAddress() + "\n";
                }
            }
        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            ip += "Something Wrong! " + e.toString() + "\n";
        }
        return ip;
    }

}
