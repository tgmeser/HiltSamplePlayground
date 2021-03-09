package com.babyapps.hiltsample.di.model.army

class Marine : Diver, Parachutist, FirsAider {
    override fun diveDeep(): String = "Marine is diving into the sea..!"
    override fun parachute(): String = "Marine is jumping off the plane with parachute..!"
    override fun firstAid(): String = "Marine is giving first-aid...!"
}
