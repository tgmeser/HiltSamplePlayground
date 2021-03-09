package com.babyapps.hiltsample.di.other

import android.util.Log
import androidx.fragment.app.Fragment
import com.babyapps.hiltsample.R
import com.babyapps.hiltsample.di.model.music.Instrument
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MusicianFragment @Inject constructor(@Named("Drums") drums: Instrument): Fragment(R.layout.musician_fragment) {
    init {
        Log.d("HiltFragment", "Hilt ViewModel : $drums")

    }
}