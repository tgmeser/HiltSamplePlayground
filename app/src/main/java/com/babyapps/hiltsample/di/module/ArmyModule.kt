package com.babyapps.hiltsample.di.module

import com.babyapps.hiltsample.di.model.army.Diver
import com.babyapps.hiltsample.di.model.army.FirsAider
import com.babyapps.hiltsample.di.model.army.Marine
import com.babyapps.hiltsample.di.model.army.Parachutist
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object ArmyModule {

    @Provides
    @ActivityScoped
    @Named("Diving")
    fun provideDiverToMarine(): Diver = Marine()

    @Provides
    @ActivityScoped
    @Named("Parachuting")
    fun providPrachutistToMarine(): Parachutist = Marine()

    @Provides
    @ActivityScoped
    @Named("FirstAiding")
    fun provideFirstAiderToMarine(): FirsAider = Marine()

}

