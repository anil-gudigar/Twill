package com.twilllnews.dagger;

import android.app.Application;

import com.twilllnews.app.TwillApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by Anil on 20/05/2017.
 */
@Singleton
@Component(modules = {
        AppModule.class,
        AndroidInjectionModule.class,
        ActivityBuilderModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }

    void inject(TwillApplication aaApp);
}
