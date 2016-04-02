package klep.yaacademytz.api;

import java.util.List;

import klep.yaacademytz.model.Artist;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import rx.Observable;
import rx.Observer;

/**
 * Created by klep.io on 31.03.16.
 */
public interface YaApi {
    @GET("artists.json")
    Observable<List<Artist>> getArtist();

}
