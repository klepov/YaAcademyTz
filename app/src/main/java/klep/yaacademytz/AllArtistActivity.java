package klep.yaacademytz;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import klep.yaacademytz.allArtists.AllArtistFragment;
import klep.yaacademytz.common.BaseActivity;
import klep.yaacademytz.detailArtist.DetailArtistFragment;
import klep.yaacademytz.detailArtist.DetailsArtistActivity;
import klep.yaacademytz.model.Artist;


public class AllArtistActivity extends BaseActivity implements AllArtistFragment.ItemSendToActivity {
    private FragmentTransaction transaction;

    public static final String ARTIST = "ARTIST";
    private boolean masterDetail;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_list);

        transaction = getSupportFragmentManager().beginTransaction();


        if (savedInstanceState == null) {
//            проверка на устройство
//            если планшет/что большое - то включить
//            поддержку двух панелей
            if (findViewById(R.id.artistDetailPlaceFragment) != null) {
                masterDetail = true;
            }
            transaction.replace(R.id.artistListPlaceFragment, new AllArtistFragment())
                    .commit();
        }

    }


    /**
     * коллбек метод с фрагмента
     * заполнение детальной инфой об артисте
     *
     * @param artist выбранный артист
     */
    @Override
    public void itemSend(Artist artist) {

        if (masterDetail || isTablet(this)) {

            sendToDetailPanel(artist);

        } else {
            Intent intent = new Intent(this, DetailsArtistActivity.class);
            intent.putExtra(ARTIST, artist);
            startActivity(intent);
        }

    }


    /**
     * коллбек метод с фрагмента
     * заполнение панели для планшета
     * вызывается при первом запуске
     *
     * @param artist выбранный артист
     */
    @Override
    public void itemSendFirst(Artist artist) {

        if (masterDetail) {
            sendToDetailPanel(artist);
        }
    }

    /**
     * отображает фрагмент детальной информацим
     * об арститсе
     *
     * @param artist выбранный артист
     */
    private void sendToDetailPanel(Artist artist) {
        DetailArtistFragment detailArtistFragment = new DetailArtistFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARTIST, artist);
        detailArtistFragment.setArguments(args);

        transaction = getSupportFragmentManager().beginTransaction();

        transaction
                .replace(R.id.artistDetailPlaceFragment, DetailArtistFragment.getInstance(args))
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else if (getFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        }
    }


    private boolean isTablet(Context context) {
        boolean xlarge = ((context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_XLARGE);
        boolean large = ((context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE);
        return (xlarge || large);
    }


}
