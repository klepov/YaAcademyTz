package klep.yaacademytz.allArtists;

import android.content.SharedPreferences;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import javax.inject.Inject;

import klep.yaacademytz.App;
import klep.yaacademytz.api.GsonParseArtists;
import klep.yaacademytz.api.GsonParseArtistsList;
import klep.yaacademytz.api.YaApi;
import klep.yaacademytz.model.Artist;
import klep.yaacademytz.utils.Const;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by klep.io on 03.04.16.
 */
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

    public void getArtists(){

        if (getView() != null){
            getView().showLoading();
        }

        subscriber = new Subscriber<List<Artist>>() {
            @Override
            public void onCompleted() {
//                getView().showAllArtist(artists);


            }

            @Override
            public void onError(Throwable e) {
                String json = preferences.getString(Const.PREFERENCES_ARTISTS,null);
                if (json == null) {
                    getView().showError();
                }
                else {
                    gson.fromJson(json,Artist.class);
                    List<Artist> kek = (List<Artist>) new Gson().fromJson(json,Artist.class);
                    Log.d("asd","DAS");
                }

            }

            @Override
            public void onNext(List<Artist> list) {



                getView().showAllArtist(list);
            }
        };

        yaApi.getArtist()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}
