package klep.yaacademytz.allArtists;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import klep.yaacademytz.R;
import klep.yaacademytz.allArtists.adapter.AdapterArtists;
import klep.yaacademytz.common.BaseViewStateFragment;
import klep.yaacademytz.model.Artist;

/**
 * Created by klep.io on 03.04.16.
 */
public class AllArtistFragment extends BaseViewStateFragment<AllArtistView, AllArtistPresenter>
        implements AllArtistView {
    @Bind(R.id.recycleArtists)
    RecyclerView recyclerView;
    private AdapterArtists adapter;
    private List<Artist> artists;
    private LinearLayoutManager layoutManager;
    private Bundle bundle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        bundle = savedInstanceState;

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        if (bundle == null) {
            artists = new ArrayList<>();
        }
        adapter = new AdapterArtists(artists);
        recyclerView.setAdapter(adapter);

    }


    @Override
    public void showLoading() {
    }

    @Override
    public void showError() {

    }

    @Override
    public void showAllArtist(List<Artist> listArtists) {
        Log.d("update_artists", "receive");
        artists.addAll(listArtists);
        adapter.notifyDataSetChanged();
        Log.d("update_artists", "notifyDataSetChanged");

    }

    @Override
    public void showGetArtists() {
        if (bundle == null) {
            presenter.getArtists();
        }
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_artist;
    }

    @Override
    public ViewState createViewState() {
        // TODO: 03.04.16 dagger
        return new AllArtistViewState();
    }

    @Override
    public void onNewViewStateInstance() {
        showGetArtists();
    }

    @Override
    public AllArtistPresenter createPresenter() {
        // TODO: 03.04.16 dagger
        return new AllArtistPresenter();
    }


}
