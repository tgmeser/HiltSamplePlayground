package com.babyapps.hiltsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.babyapps.hiltsample.databinding.ActivityMainBinding
import com.babyapps.hiltsample.di.model.army.Marine
import com.babyapps.hiltsample.di.model.army.Soldier
import com.babyapps.hiltsample.di.model.music.Musician
import com.babyapps.hiltsample.notdi.*
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //Setting ViewBinding variable
    private lateinit var binding: ActivityMainBinding

    //Dependency Injection variables
    @Inject
    @Named("AxlRoseMainActivity")
    lateinit var axlRose: Musician

    @Inject
    @Named("DuffMcKaganMainActivity")
    lateinit var duffMcKagan: Musician

    @Inject
    @Named("SlashMainActivity")
    lateinit var slash: Musician

    private val instrumentViewModel: InstrumentViewModel by viewModels()

    @Inject
    lateinit var captain: Soldier

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewAppLabel.text = "Dependency Injection App"

        //Not dependency injection
        manuelUsage()

        //Dependency Injection - Class Level
        diUsageClassLevel()

        //Dependency Injection - Interface Level
        diUsageInterfaceLevel()


    }
    fun diUsageClassLevel(){
        Log.d(
            "MainActivityDI",
            "musician name : ${slash.musicianName} , " +
                    " band : ${slash.band.bandName} and band size: ${slash.band.bandSize} ," +
                    " instrument : ${slash.instrument.instrumentName} "
        )
        Log.d(
            "MainActivityDI",
            "musician name : ${axlRose.musicianName} ," +
                    " band : ${axlRose.band.bandName} and band size: ${axlRose.band.bandSize} ," +
                    " instrument : ${axlRose.instrument.instrumentName} "
        )
        Log.d(
            "MainActivityDI",
            "musician name : ${duffMcKagan.musicianName} ," +
                    " band : ${duffMcKagan.band.bandName} and band size: ${duffMcKagan.band.bandSize} ," +
                    " instrument : ${duffMcKagan.instrument.instrumentName} "
        )
        println("${axlRose.musicianName}")
        println("${axlRose.band.bandName}")
        println("${axlRose.instrument.instrumentName}")

        //Just checking di in InstrumentViewModel
        instrumentViewModel

    }
    fun diUsageInterfaceLevel(){
        println("${captain.soldierDives()}")
        println("${captain.soldierParachute()}")
        println("${captain.soldierGivesFirstAid()}")
    }
    fun manuelUsage() {
        val rijkaard = Coach("Frank Rijkaard")
        val position = Position("Attacking Midfield")
        val team = Team("Barcelona", rijkaard)
        val ronaldinho = Player(10, "Ronaldinho", position, team)

        //As we can see when we want to create only one player object ,
        //we need another different objects to put into container object
        //That is why we should use Dependency Injection

        ronaldinho.play()
        Log.d(
            "Roni",
               " ${ronaldinho.squadNumber} ," +
                    " ${ronaldinho.playerName} ," +
                    " ${ronaldinho.position.position} ," +
                    " ${ronaldinho.team.teamName} ," +
                    " ${ronaldinho.team.coach.coachname}"
        )
    }
}