package klep.yaacademytz.dagger.modules;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by klep.io on 31.03.16.
 */
@Module
public class AppModule {
    Application application;
    Context context;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideApplication(){
        return application;
    }

    @Provides
    @Singleton
    Context provideContext(Application application){
        context = application.getApplicationContext();
        return context;
    }
}
