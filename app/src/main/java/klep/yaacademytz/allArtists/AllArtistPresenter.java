package klep.yaacademytz.allArtists;

import android.util.Log;
import android.view.View;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import java.util.List;

import javax.inject.Inject;

import klep.yaacademytz.App;
import klep.yaacademytz.api.YaApi;
import klep.yaacademytz.model.Artist;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Created by klep.io on 03.04.16.
 */
public class AllArtistPresenter extends MvpBasePresenter<AllArtistView> {

    @Inject
    YaApi yaApi;

    Subscriber<List<Artist>> subscriber;

    private List<Artist> artists;

    public AllArtistPresenter() {
        ((App) App.getApplication()).getApiComponent().inject(this);
    }

    public void getArtists(){
        if (getView() != null){
            getView().showLoading();
        }

        subscriber = new Subscriber<List<Artist>>() {
            @Override
            public void onCompleted() {
                getView().showAllArtist(artists);


            }

            @Override
            public void onError(Throwable e) {
                getView().showError();

            }

            @Override
            public void onNext(List<Artist> list) {
                artists = list;
            }
        };

        yaApi.getArtist()
                .subscribeOn(Schedulers.newThread())
                .subscribe(subscriber);
    }

}
