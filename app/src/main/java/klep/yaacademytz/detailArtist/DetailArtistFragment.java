package klep.yaacademytz.detailArtist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import klep.yaacademytz.AllArtistActivity;
import klep.yaacademytz.R;
import klep.yaacademytz.common.BaseFragment;
import klep.yaacademytz.model.Artist;

/**
 * Created by klep.io on 06.04.16.
 */
public class DetailArtistFragment extends BaseFragment {

    @Bind(R.id.detailPhoto)
    ImageView detailPhoto;

    @Bind(R.id.genreArtistDetail)
    TextView genreDetail;

    @Bind(R.id.countMusicAndAlbumArtistDetail)
    TextView countMusicAndAlbumArtistDetail;

    @Bind(R.id.biography)
    TextView biographyDetail;

    @Override
    protected int getLayoutRes() {
        return R.layout.detail_artist;
    }

    public static final DetailArtistFragment getInstance(Bundle bundle) {

        DetailArtistFragment fragment = new DetailArtistFragment();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("asd", "asd");
        Artist artist = this.getArguments()
                .getParcelable(AllArtistActivity.ARTIST);


        Picasso.with(getActivity())
                .load(artist.getCover().getBig())
                .into(detailPhoto);

        try {
            ((DetailsArtistActivity) getActivity()).getSupportActionBar().setTitle(artist.getName());
        }catch (Exception e){

        }

        genreDetail.setText(artist.getFullGenre());
        countMusicAndAlbumArtistDetail.setText(artist.getCountInfoDetail());
        biographyDetail.setText(artist.getDescription());

    }
}
