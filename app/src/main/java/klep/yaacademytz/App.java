package klep.yaacademytz;

import android.app.Application;

import com.mikepenz.iconics.Iconics;

import klep.yaacademytz.allArtists.AllArtistComponent;
import klep.yaacademytz.allArtists.DaggerAllArtistComponent;
import klep.yaacademytz.dagger.components.ApiComponent;
import klep.yaacademytz.dagger.components.AppComponent;
import klep.yaacademytz.dagger.components.DaggerApiComponent;
import klep.yaacademytz.dagger.components.DaggerAppComponent;
import klep.yaacademytz.dagger.components.DaggerNetComponent;
import klep.yaacademytz.dagger.components.NetComponent;
import klep.yaacademytz.dagger.modules.AllArtistsModule;
import klep.yaacademytz.dagger.modules.ApiModule;
import klep.yaacademytz.dagger.modules.AppModule;
import klep.yaacademytz.dagger.modules.NetModule;
import klep.yaacademytz.utils.CustomFont;


public class App extends Application {
    static private NetComponent netComponent;
    static private ApiComponent apiComponent;
    static private AppComponent appComponent;
    private static Application application;

    @Override
    public void onCreate() {
        super.onCreate();

        Iconics.init(this);
        Iconics.registerFont(new CustomFont());
        application = this;

        netComponent = DaggerNetComponent.builder()
                .netModule(new NetModule())
                .appModule(new AppModule(this))
                .build();

        apiComponent = DaggerApiComponent.builder()
                .apiModule(new ApiModule())
                .netComponent(netComponent)
                .build();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();




    }

    public static Application getApplication() {
        return application;
    }

    public static NetComponent getNetComponent() {
        return netComponent;
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    public static ApiComponent getApiComponent() {
        return apiComponent;
    }
}
