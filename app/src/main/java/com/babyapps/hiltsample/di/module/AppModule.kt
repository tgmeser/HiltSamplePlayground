package com.babyapps.hiltsample.di.module

import com.babyapps.hiltsample.di.model.music.Band
import com.babyapps.hiltsample.di.model.music.Instrument
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
//SingletonComponent is top level scope, we can use  anywhere - no limit
//And after that we should keep balance , we use @Singleton annotation above providers
object AppModule {

    @Singleton
    @Provides
    @Named("ElectroGuitar")
    fun provideElectroGuitar() : Instrument {
        return Instrument("Electro Guitar")
    }

    @Singleton
    @Provides
    @Named("BassGuitar")
    fun provideBassGuitar() : Instrument {
        return Instrument("Bass Guitar")
    }
    @Singleton
    @Provides
    @Named("Vocal")
    fun provideVocal() : Instrument {
        return Instrument("Vocal")
    }

    @Singleton
    @Provides
    @Named("Drums")
    fun providesDrums() : Instrument {
        return Instrument("Drums")
    }

    @Singleton
    @Provides
    fun provideBand(): Band {
        return Band(5,"Guns N' Roses")
    }



}