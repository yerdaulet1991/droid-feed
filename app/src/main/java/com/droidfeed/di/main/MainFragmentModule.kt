package com.droidfeed.di.main

import com.droidfeed.ui.module.about.AboutFragment
import com.droidfeed.ui.module.contribute.ContributeFragment
import com.droidfeed.ui.module.feed.BookmarksFragment
import com.droidfeed.ui.module.feed.NewsFeedFragment
import com.droidfeed.ui.module.newsletter.NewsletterFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentModule {

    @ContributesAndroidInjector()
    abstract fun contributeNewsFragment(): NewsFeedFragment

    @ContributesAndroidInjector()
    abstract fun contributeBookmarksFragment(): BookmarksFragment

    @ContributesAndroidInjector()
    abstract fun contributeAboutFragment(): AboutFragment

    @ContributesAndroidInjector()
    abstract fun contributeNewsletterFragment(): NewsletterFragment

    @ContributesAndroidInjector()
    abstract fun contributeHelpUsFragment(): ContributeFragment
}