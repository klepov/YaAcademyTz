package klep.yaacademytz.dagger.modules;

import dagger.Module;
import dagger.Provides;
import klep.yaacademytz.api.YaApi;
import klep.yaacademytz.dagger.scopes.UserScope;
import retrofit2.Retrofit;

/**
 * Created by klep.io on 01.04.16.
 */
@Module
public class ApiModule {
    @Provides
    @UserScope
    public YaApi provideYaApi(Retrofit retrofit){
        return retrofit.create(YaApi.class);
    }
}
