package klep.yaacademytz.dagger.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import klep.yaacademytz.allArtists.AllArtistPresenter;

/**
 * Created by klep.io on 10.04.16 with love.
 */
@Module
public class AllArtistsModule {
    @Singleton
    @Provides
    AllArtistPresenter providePresenter(){
        return new AllArtistPresenter();
    }
}
