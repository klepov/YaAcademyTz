package klep.yaacademytz.allArtists;

import com.hannesdorfmann.mosby.mvp.MvpView;

import java.util.List;

import klep.yaacademytz.model.Artist;

/**
 * Created by klep.io on 02.04.16.
 */
public interface AllArtistView extends MvpView {
    void showLoading();
    void showError();
    void showAllArtist(List<Artist> artists);
    void showGetArtists();
}
