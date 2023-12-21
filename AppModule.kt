package com.example.ccontectssmvvm.di

import com.example.ccontectssmvvm.data.datasource.KisilerDataSource
import com.example.ccontectssmvvm.data.repo.KisilerRepository
import com.example.ccontectssmvvm.retrofit.ApiUtils
import com.example.ccontectssmvvm.retrofit.KisilerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideKisilerDataSource( kdao:KisilerDao) : KisilerDataSource{
        return KisilerDataSource(kdao)
    }

    @Provides
    @Singleton
    fun provideKisilerRepository(kds:KisilerDataSource) : KisilerRepository{
        return KisilerRepository(kds)
    }


    @Provides
    @Singleton
    fun provideKisilerDao() : KisilerDao{
        // Daoya gönderdiğimiz veriler Apiutilste ve sağlamasını yaptık
       return ApiUtils.getKisilerDao() // api utisten verileri aldık
    }

}