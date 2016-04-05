package klep.yaacademytz.allArtists;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import klep.yaacademytz.R;
import klep.yaacademytz.common.BaseActivity;
import klep.yaacademytz.common.BaseViewStateActivity;

/**
 * Created by klep.io on 03.04.16.
 */
public class AllArtistActivity extends BaseActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_artist);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.place_fragment, new AllArtistFragment())
                    .commit();
        }
    }
}
