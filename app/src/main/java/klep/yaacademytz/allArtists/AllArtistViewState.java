package klep.yaacademytz.allArtists;

import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;

/**
 * Created by klep.io on 03.04.16.
 */
public class AllArtistViewState implements ViewState<AllArtistView> {
    final int STATE_SHOW_LOADING = 0;
    final int STATE_SHOW_ERROR = 1;
    final int STATE_GET_ARTISTS = 2;

    int state = STATE_GET_ARTISTS;

    @Override
    public void apply(AllArtistView view, boolean retained) {
        switch (state) {
            case STATE_SHOW_ERROR:
                view.showError();
                break;
            case STATE_SHOW_LOADING:
                view.showLoading();
                break;
            case STATE_GET_ARTISTS:
                view.showGetArtists();
                break;


        }

    }

    public void setStateShowLoading() {
        state = STATE_SHOW_LOADING;
    }

    public void setStateShowError() {
        state = STATE_SHOW_ERROR;
    }

    public void setStateGetArtists() {
        state = STATE_GET_ARTISTS;
    }


}
