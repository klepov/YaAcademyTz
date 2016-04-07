package klep.yaacademytz.detailArtist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import klep.yaacademytz.AllArtistActivity;
import klep.yaacademytz.R;
import klep.yaacademytz.common.BaseActivity;
import klep.yaacademytz.model.Artist;

/**
 * Created by klep.io on 07.04.16.
 */
public class DetailsArtistActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        if (savedInstanceState == null) {
            Artist artist = (Artist) getIntent()
                    .getExtras()
                    .get(AllArtistActivity.ARTIST);


            DetailArtistFragment detailArtistFragment = new DetailArtistFragment();
            Bundle args = new Bundle();
            args.putParcelable(AllArtistActivity.ARTIST, artist);
            detailArtistFragment.setArguments(args);


            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.artistDetailPlaceFragment, DetailArtistFragment.getInstance(args))
                    .commit();

        }

    }

    @Nullable
    @Override
    public ActionBar getSupportActionBar() {
        return super.getSupportActionBar();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
