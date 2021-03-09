package com.babyapps.hiltsample.di.module

import android.content.Context
import com.babyapps.hiltsample.di.model.music.Band
import com.babyapps.hiltsample.di.model.music.Instrument
import com.babyapps.hiltsample.di.model.music.Musician
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Named

@Module
@InstallIn(ActivityComponent::class)
//We limited musicians just like below,through ActivityComponent on top
//We just want to use musicians in Activity Classes
object MusicianModule {

    //This module is created for only Mainactivity
    //Scope ordering is ; Singleton>ActivityRetainedScoped>ViewModelScoped
    // -> ActivityScoped>FragmentScoped>ViewScoped
    //Component ordering is ;
    //SingletonComponent>ActivityRetainedComponent>ViewModelComponent>ActivityComponent
    // -> FragmentComponent>ViewComponent>ViewWithFragmentComponent>ServiceComponent

    @ActivityScoped
    @Provides
    @Named("SlashMainActivity")
    fun provideSlash(
        @ApplicationContext context: Context,
        @Named("ElectroGuitar") instrument: Instrument,
        band: Band
    ): Musician {
        return Musician("Slash", band, instrument)
    }

    @ActivityScoped
    @Provides
    @Named("AxlRoseMainActivity")
    fun provideAxlRose(
        @ApplicationContext context: Context,
        @Named("Vocal") instrument: Instrument,
        band: Band
    ): Musician {
        return Musician("Axl Rose", band, instrument)
    }

    @ActivityScoped
    @Provides
    @Named("DuffMcKaganMainActivity")
    fun provideDuff(
        @ApplicationContext context: Context,
        @Named("BassGuitar") instrument: Instrument,
        band: Band
    ): Musician {
        return Musician("Duff McKagan", band, instrument)
    }

}