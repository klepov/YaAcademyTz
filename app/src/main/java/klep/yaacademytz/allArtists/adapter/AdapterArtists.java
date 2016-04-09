package klep.yaacademytz.allArtists.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikepenz.iconics.IconicsDrawable;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import klep.yaacademytz.App;
import klep.yaacademytz.R;
import klep.yaacademytz.model.Artist;
import klep.yaacademytz.utils.CustomFont;

/**
 * Created by klep.io on 03.04.16.
 */

/*
* в адаптере два коллбека
* 1 коллбек - вытаскивает id по клику на item
* 2 коллбек - пробрасывет id полученый с первого коллбека во фрагмент
*/
public class AdapterArtists extends RecyclerView.Adapter<AdapterArtists.ViewHolder> {


    @Inject
    Context context;

    private List<Artist> artists;
    private CallbackItemClickListener callbackItemClickListener;

    public AdapterArtists(List<Artist> artists, CallbackItemClickListener callbackItemClickListener) {
        App.getAppComponent().inject(this);
        this.artists = artists;
        this.callbackItemClickListener = callbackItemClickListener;
    }

    public AdapterArtists(CallbackItemClickListener callbackItemClickListener) {
        App.getAppComponent().inject(this);

        this.callbackItemClickListener = callbackItemClickListener;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View artistView = inflater.inflate(R.layout.artsit_prev, parent, false);

        ViewHolder viewHolder = new ViewHolder(artistView, new ViewHolder.ViewHolderCallback() {
            @Override
            public void itemSelected(int itemNum) {
                callbackItemClickListener
                        .itemClickedFromViewHolder(artists.get(itemNum));
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Artist artist = artists.get(position);

        Drawable placeholderImg = new IconicsDrawable(context)
                .icon(CustomFont.Icon.cFont_wait)
                .color(Color.GRAY)
                .sizePx(300);

        holder.nameArtist.setText(artist.getName());
        holder.genreArtist.setText(artist.getFullGenre());
        holder.countMusicAndAlbumArtist.setText(artist.getCountInfo());

        Picasso.with(App.getApplication())
                .load(artist.getCover().getSmall())
                .placeholder(placeholderImg)
                .into(holder.imageArtists);


    }

    @Override
    public int getItemCount() {
        return artists.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ViewHolderCallback callback;

        @Bind(R.id.nameArtist)
        TextView nameArtist;

        @Bind(R.id.genreArtist)
        TextView genreArtist;

        @Bind(R.id.countMusicAndAlbumArtist)
        TextView countMusicAndAlbumArtist;

        @Bind(R.id.imagePrevArtist)
        ImageView imageArtists;

        /**
         * инжектит view.
         * реализует callback для выбранного элемента
         *
         * @param itemView
         * @param callback
         */
        public ViewHolder(View itemView, ViewHolderCallback callback) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            this.callback = callback;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
//            отправляет в адаптер id выбранного артиста
            callback.itemSelected(getLayoutPosition());
        }

        public interface ViewHolderCallback {
            void itemSelected(int itemNum);
        }

    }

    public interface CallbackItemClickListener {
        //        2 callback
        void itemClickedFromViewHolder(Artist artist);
    }
}