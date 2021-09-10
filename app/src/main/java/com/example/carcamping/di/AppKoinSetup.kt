package com.example.carcamping.di

import org.koin.core.module.Module
import org.koin.dsl.module

class AppKoinSetup : KoinBaseKoinSetup() {

    private val viewModelModule = module {

    }

    private val repositoryModule = module {

    }

    private val sourceModule = module {

    }

    private val apiModule = module {


    }


    override fun getModules(): List<Module> {
        return listOf(
            viewModelModule,
            repositoryModule,
            sourceModule,
            apiModule
        )
    }
}