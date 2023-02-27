package com.mazanov.rick_and_morty.diimport android.content.Contextimport com.mazanov.rick_and_morty.data.local_data_source.dao.PersonDaoimport com.mazanov.rick_and_morty.data.local_data_source.database.AppDatabaseimport dagger.Moduleimport dagger.Providesimport dagger.hilt.InstallInimport dagger.hilt.android.qualifiers.ApplicationContextimport dagger.hilt.components.SingletonComponentimport javax.inject.Singleton@Module@InstallIn(SingletonComponent::class)class DataModule {    @Singleton    @Provides    fun providePersonDao(@ApplicationContext appContext: Context): PersonDao {        return AppDatabase.getInstance(appContext).personDao()    }}