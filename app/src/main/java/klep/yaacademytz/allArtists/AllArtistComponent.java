package klep.yaacademytz.allArtists;

import javax.inject.Singleton;

import dagger.Component;
import klep.yaacademytz.dagger.modules.AllArtistsModule;

/**
 * Created by klep.io on 10.04.16 with love.
 */
@Singleton
@Component(modules = AllArtistsModule.class)
public interface AllArtistComponent {
    public AllArtistPresenter presenter();
}
