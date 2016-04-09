package klep.yaacademytz.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by klep.io on 08.04.16.
 */
public class CheckInternet {
    public static boolean isDeviceOnline(Context context) {

        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();


        return (networkInfo != null && networkInfo.isConnected());
    }

}
