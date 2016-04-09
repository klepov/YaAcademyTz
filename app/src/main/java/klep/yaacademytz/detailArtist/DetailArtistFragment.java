package klep.yaacademytz.detailArtist;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikepenz.iconics.IconicsDrawable;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import klep.yaacademytz.AllArtistActivity;
import klep.yaacademytz.R;
import klep.yaacademytz.common.BaseFragment;
import klep.yaacademytz.model.Artist;
import klep.yaacademytz.utils.CustomFont;

/**
 * Created by klep.io on 06.04.16 with love.
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

    public static DetailArtistFragment getInstance(Bundle bundle) {

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
        Artist artist = this.getArguments()
                .getParcelable(AllArtistActivity.ARTIST);


        Drawable placeholderImg = new IconicsDrawable(getActivity())
                .icon(CustomFont.Icon.cFont_wait)
                .color(Color.GRAY)
                .sizePxX(1000)
                .sizePxY(1000);

        Picasso.with(getActivity())
                .load(artist.getCover().getBig())
                .placeholder(placeholderImg)
                .into(detailPhoto);

        try {
            ((DetailsArtistActivity) getActivity()).getSupportActionBar().setTitle(artist.getName());
        }catch (NullPointerException ignored){

        }

        genreDetail.setText(artist.getFullGenre());
        countMusicAndAlbumArtistDetail.setText(artist.getCountInfoDetail());
        biographyDetail.setText(artist.getDescription());

    }
}
