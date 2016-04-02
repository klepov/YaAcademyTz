package klep.yaacademytz;

import android.app.Application;

import klep.yaacademytz.dagger.components.ApiComponent;
import klep.yaacademytz.dagger.components.DaggerApiComponent;
import klep.yaacademytz.dagger.components.DaggerNetComponent;
import klep.yaacademytz.dagger.components.NetComponent;
import klep.yaacademytz.dagger.modules.ApiModule;
import klep.yaacademytz.dagger.modules.AppModule;
import klep.yaacademytz.dagger.modules.NetModule;


public class App extends Application {
    private NetComponent netComponent;
    private ApiComponent apiComponent;
    private static  Application  application;
    @Override
    public void onCreate() {
        super.onCreate();
        application = this;

        netComponent = DaggerNetComponent.builder()
                .netModule(new NetModule())
                .appModule(new AppModule(this))
                .build();

        apiComponent = DaggerApiComponent.builder()
                .apiModule(new ApiModule())
                .netComponent(netComponent)
                .build();
    }

    public static Application getApplication(){
        return application;
    }

    public NetComponent getNetComponent() {
        return netComponent;
    }

    public ApiComponent getApiComponent() {
        return apiComponent;
    }
}
