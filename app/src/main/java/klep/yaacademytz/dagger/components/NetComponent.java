package klep.yaacademytz.dagger.components;

import javax.inject.Singleton;

import dagger.Component;
import klep.yaacademytz.dagger.modules.AppModule;
import klep.yaacademytz.dagger.modules.NetModule;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by klep.io on 01.04.16.
 */
@Singleton
@Component(modules = {AppModule.class,NetModule.class})
public interface NetComponent {
    Retrofit retrofit();
    OkHttpClient okHttpClient();
}
