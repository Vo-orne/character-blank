package com.example.characterblank.di

import android.content.Context
import androidx.room.Room
import com.example.characterblank.data.database.AppDatabase
import com.example.characterblank.data.database.CharacterDao
import com.example.characterblank.data.repository.CharacterRepository
import com.example.characterblank.data.repository.CharacterRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext app: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            "app.db"
        ).fallbackToDestructiveMigration(false).build()
    }

    @Provides
    fun provideCharacterDao(db: AppDatabase): CharacterDao = db.characterDao()

    @Provides
    @Singleton
    fun provideCharacterRepository(dao: CharacterDao): CharacterRepository {
        return CharacterRepositoryImpl(dao)
    }
}