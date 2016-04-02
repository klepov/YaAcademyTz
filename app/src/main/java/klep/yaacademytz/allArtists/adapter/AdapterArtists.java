package klep.yaacademytz.allArtists.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import klep.yaacademytz.App;
import klep.yaacademytz.R;
import klep.yaacademytz.model.Artist;

/**
 * Created by klep.io on 03.04.16.
 */
public class AdapterArtists extends RecyclerView.Adapter<AdapterArtists.ViewHolder>{

    private List<Artist> artists;

    public AdapterArtists(List<Artist> artists) {
        this.artists = artists;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View artistView = inflater.inflate(R.layout.artsit_prev,parent,false);

        ViewHolder viewHolder = new ViewHolder(artistView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Artist artist = artists.get(position);

        holder.nameArtist.setText(artist.getName());
        holder.genreArtist.setText(artist.getFullGenre());
        holder.countMusicAndAlbumArtist.setText(artist.getCountInfo());

        Picasso.with(App.getApplication())
                .load(artist.getCover().getSmall())
                .into(holder.imageArtists);


    }

    @Override
    public int getItemCount() {
        return artists.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.nameArtist)
        TextView nameArtist;

        @Bind(R.id.genreArtist)
        TextView genreArtist;

        @Bind(R.id.countMusicAndAlbumArtist)
        TextView countMusicAndAlbumArtist;

        @Bind(R.id.imagePrevArtist)
        ImageView imageArtists;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}