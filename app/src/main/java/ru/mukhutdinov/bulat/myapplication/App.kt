package ru.mukhutdinov.bulat.myapplication

import android.app.Application
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.AndroidLifecycleScope
import org.kodein.di.generic.bind
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton

class App : Application(), KodeinAware {
    override val kodein = Kodein.lazy {


        bind<MyViewModel>() with scoped(AndroidLifecycleScope<MainActivity>()).singleton {

            ViewModelProviders.of(context).get(MyViewModel::class.java)
        }

    }
}