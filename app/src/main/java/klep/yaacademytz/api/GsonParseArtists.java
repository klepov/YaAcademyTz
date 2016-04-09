package klep.yaacademytz.api;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import klep.yaacademytz.model.Artist;

/**
 * Created by klep.io on 08.04.16.
 */
public class GsonParseArtists implements JsonDeserializer<Artist> {


    @Override
    public Artist deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {


        Artist artist = new Gson().fromJson(json, Artist.class);


        return artist;
    }
}
