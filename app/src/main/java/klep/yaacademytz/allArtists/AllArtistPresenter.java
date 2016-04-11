package klep.yaacademytz.allArtists;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import java.util.List;

import javax.inject.Inject;

import klep.yaacademytz.App;
import klep.yaacademytz.api.YaApi;
import klep.yaacademytz.model.Artist;
import klep.yaacademytz.utils.Const;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class AllArtistPresenter extends MvpBasePresenter<AllArtistView> {

    @Inject
    YaApi yaApi;

    @Inject
    Gson gson;

    @Inject
    SharedPreferences preferences;

    Subscriber<List<Artist>> subscriber;

    private List<Artist> artists;

    public AllArtistPresenter() {
        App.getApiComponent().inject(this);
    }

    /**
     * получение артистов
     */
    public void getArtists() {

        if (getView() != null) {
            getView().showLoading();
        }

        subscriber = new Subscriber<List<Artist>>() {
            @Override
            public void onCompleted() {
                getView().showAllArtist(artists);
            }

            @Override
            public void onError(Throwable e) {
//                попытка вытащить предыдущий ответ
//                если его нет, отдать ошибку
                String json = preferences.getString(Const.PREFERENCES_ARTISTS, null);
                if (json == null) {
                    getView().showError();
                } else {
                    List<Artist> artists = gson.fromJson(json, new TypeToken<List<Artist>>() {
                    }.getType());
                    getView().showAllArtist(artists);
                }

            }

            @Override
            public void onNext(List<Artist> list) {
                artists = list;
            }
        };

        yaApi.getArtist()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        /*
            если не созранено состояние, то отписаться
         */
        if (!retainInstance) {
            cancelSub();
        }
    }

    @Override
    public void attachView(AllArtistView view) {
        super.attachView(view);
    }

    private void cancelSub() {
        if (subscriber != null && !subscriber.isUnsubscribed()) {
            subscriber.unsubscribe();
        }
    }
}
