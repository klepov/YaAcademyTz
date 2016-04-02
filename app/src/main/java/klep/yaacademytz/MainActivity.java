package klep.yaacademytz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import klep.yaacademytz.allArtists.AllArtistActivity;
import klep.yaacademytz.api.YaApi;
import klep.yaacademytz.model.Artist;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(this, AllArtistActivity.class));
    }



}
