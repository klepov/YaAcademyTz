package klep.yaacademytz.api;

import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import klep.yaacademytz.App;
import klep.yaacademytz.allArtists.AllArtistFragment;
import klep.yaacademytz.model.Artist;
import klep.yaacademytz.utils.Const;

/**
 * Created by klep.io on 09.04.16.
 */
public class GsonParseArtistsList implements JsonDeserializer<List<Artist>> {

    @Inject
    SharedPreferences preferences;

    public GsonParseArtistsList() {
        App.getApiComponent().inject(this);
    }

    @Override
    public List<Artist> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(Const.PREFERENCES_ARTISTS,json.toString());
        editor.apply();

        List<Artist> listArtist = new Gson().fromJson(json, new TypeToken<List<Artist>>(){}.getType());


        return listArtist;
    }
}
