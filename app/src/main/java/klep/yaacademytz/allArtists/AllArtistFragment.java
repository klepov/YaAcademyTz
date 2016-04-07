package klep.yaacademytz.allArtists;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
        implements AllArtistView, AdapterArtists.CallbackItemClickListener {
    @Bind(R.id.recycleArtists)
    RecyclerView recyclerView;
    private AdapterArtists adapter;
    private List<Artist> artists;
    private Bundle bundle;

    private ItemSendToActivity itemSendToActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        itemSendToActivity = (ItemSendToActivity) activity;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        bundle = savedInstanceState;

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        if (bundle == null) {
            artists = new ArrayList<>();
        }
        adapter = new AdapterArtists(artists, this);
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
        artists.addAll(listArtists);
        adapter.notifyDataSetChanged();
        itemSendToActivity.itemSendFirst(listArtists.get(0));

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

    @NonNull
    @Override
    public ViewState createViewState() {
        // TODO: 03.04.16 dagger
        return new AllArtistViewState();
    }

    @Override
    public void onNewViewStateInstance() {
        showGetArtists();
    }

    @NonNull
    @Override
    public AllArtistPresenter createPresenter() {
        // TODO: 03.04.16 dagger
        return new AllArtistPresenter();
    }


    @Override
    public void itemClickedFromViewHolder(Artist artist) {
        itemSendToActivity.itemSend(artist);
    }

    public interface ItemSendToActivity {
        void itemSend(Artist artist);
        void itemSendFirst(Artist artist);
    }
}
