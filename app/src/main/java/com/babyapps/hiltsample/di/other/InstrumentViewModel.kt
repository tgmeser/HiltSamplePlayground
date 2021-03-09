package com.babyapps.hiltsample.notdi

import android.util.Log
import androidx.lifecycle.ViewModel
import com.babyapps.hiltsample.di.model.music.Instrument
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class InstrumentViewModel @Inject constructor(
    @Named("Drums") drums: Instrument,
    @Named("BassGuitar") bassGuitar: Instrument,
    @Named("ElectroGuitar") electroGuitar: Instrument
) : ViewModel() {

    init {
        Log.d("InstrumentViewModel", "InstrumentViewModel1 ---> ${drums.instrumentName}")
        Log.d("InstrumentViewModel", "InstrumentViewModel2 ---> ${bassGuitar.instrumentName}")
        Log.d("InstrumentViewModel", "InstrumentViewModel3 ---> ${electroGuitar.instrumentName}")
    }
}