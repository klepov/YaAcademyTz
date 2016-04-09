package klep.yaacademytz.dagger.components;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import klep.yaacademytz.allArtists.adapter.AdapterArtists;
import klep.yaacademytz.dagger.modules.AppModule;

/**
 * Created by klep.io on 09.04.16.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
//    Context context();
    void inject(AdapterArtists adapterArtists);
}
