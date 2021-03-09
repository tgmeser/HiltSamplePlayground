package com.babyapps.hiltsample.di.model.army

import javax.inject.Inject
import javax.inject.Named

//This is the plan ;
//A class get an injection object as constructor in itself
//And this injection object implements some interfaces
//The meaning of soldier takes marine(as inj. obj.) which implements ranger or diver or both
//Hilt needs provider method which gets @Provide annotation to access diveDeep methon on marine above
//Therefore we see module objects to use dependency injection with hilt

class Soldier @Inject constructor(
    @Named("Diving") private val diverSkill: Diver,
    @Named("Parachuting") private val parachutistSkill: Parachutist,
    @Named("FirstAiding") private val firsAiderSkill: FirsAider
    //The point is : that skills are just like marine objects as which hide under "Interface Hood"
    //Because we bring marines with @Named("....") annotations that will be returned in ArmyModule by Providers !

    //Basicly ,  interface views that are implemented to marine class by provide methods in module

) {
    //We injected diving,first-aid and parachuting abilities into Soldier class constructor above this line
    fun soldierDives(): String = "Soldier Situation : ${diverSkill.diveDeep()}"

    fun soldierParachute(): String = "Soldier Situation : ${parachutistSkill.parachute()}"

    fun soldierGivesFirstAid(): String = "Soldier Situation : ${firsAiderSkill.firstAid()}"


}
