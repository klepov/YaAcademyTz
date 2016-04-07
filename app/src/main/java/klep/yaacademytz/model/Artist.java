
package klep.yaacademytz.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.hannesdorfmann.parcelableplease.annotation.ParcelablePlease;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;


@ParcelablePlease
@Generated("org.jsonschema2pojo")
public class Artist implements Parcelable {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("genres")
    @Expose
    public List<String> genres = new ArrayList<String>();
    @SerializedName("tracks")
    @Expose
    public Integer tracks;
    @SerializedName("albums")
    @Expose
    public Integer albums;
    @SerializedName("link")
    @Expose
    public String link;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("cover")
    @Expose
    public Cover cover;

    public String ALBUMS = " альбомов";

    public String SONGS = " песен";


    /**
     * @return The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The genres
     */
    public List<String> getGenres() {
        return genres;
    }

    /**
     * @param genres The genres
     */
    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    /**
     * @return The tracks
     */
    public Integer getTracks() {
        return tracks;
    }

    /**
     * @param tracks The tracks
     */
    public void setTracks(Integer tracks) {
        this.tracks = tracks;
    }

    /**
     * @return The albums
     */
    public Integer getAlbums() {
        return albums;
    }

    /**
     * @param albums The albums
     */
    public void setAlbums(Integer albums) {
        this.albums = albums;
    }

    /**
     * @return The link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link The link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The cover
     */
    public Cover getCover() {
        return cover;
    }

    /**
     * @param cover The cover
     */


    public void setCover(Cover cover) {
        this.cover = cover;
    }

    /**
     * @return возращяет отформатированную строку с жанрами
     */
    public String getFullGenre() {
        String fullGenre = "";

        for (int i = 0; i < genres.size(); i++) {
//            если элемент последний, то просто его добавить к строке
//            иначе добавить знак
            if (i == genres.size() - 1) {
                fullGenre = fullGenre.concat(genres.get(i));

            } else {
                fullGenre = fullGenre.concat(genres.get(i) + ", ");

            }

        }
        return fullGenre;
    }

    public String getCountInfo() {

        String fullCount = "";
        String prepareAlbums = getAlbums() + ALBUMS;
        String prepareSongs = getTracks() + SONGS;
        return fullCount = prepareAlbums + ", " + prepareSongs;
    }

    public String getCountInfoDetail() {

        String fullCount = "";
        String prepareAlbums = getAlbums() + ALBUMS;
        String prepareSongs = getTracks() + SONGS;
        return fullCount = prepareAlbums + " · " + prepareSongs;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        ArtistParcelablePlease.writeToParcel(this, dest, flags);
    }

    public static final Creator<Artist> CREATOR = new Creator<Artist>() {
        public Artist createFromParcel(Parcel source) {
            Artist target = new Artist();
            ArtistParcelablePlease.readFromParcel(target, source);
            return target;
        }

        public Artist[] newArray(int size) {
            return new Artist[size];
        }
    };
}
