package klep.yaacademytz.dagger.components;

import android.app.Activity;

import dagger.Component;
import klep.yaacademytz.allArtists.AllArtistPresenter;
import klep.yaacademytz.api.GsonParseArtistsList;
import klep.yaacademytz.dagger.modules.ApiModule;
import klep.yaacademytz.dagger.scopes.UserScope;

/**
 * Created by klep.io on 01.04.16.
 */
@UserScope
@Component(dependencies = NetComponent.class, modules = ApiModule.class)
public interface ApiComponent {
    void inject(AllArtistPresenter presenter);
    void inject(GsonParseArtistsList parseArtistsList);
}
