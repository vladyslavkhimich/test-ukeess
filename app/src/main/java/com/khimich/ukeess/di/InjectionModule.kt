package com.khimich.ukeess.di

import android.content.Context
import com.khimich.ukeess.repository.PeopleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object InjectionModule {
    @ActivityRetainedScoped
    @Provides
    fun providePeopleRepository(@ApplicationContext context: Context) = PeopleRepository(context)
}