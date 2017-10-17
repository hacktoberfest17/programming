package com.example.wellington.pokeapisample.rule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.plugins.RxJavaPlugins;
import rx.plugins.RxJavaSchedulersHook;
import rx.schedulers.Schedulers;

/**
 * Created by Wellington on 18/10/2016.
 */

public class RxSchedulersOverrideRule implements TestRule {

    private final RxJavaSchedulersHook mRxJavaSchedulersHook = new RxJavaSchedulersHook(){
        @Override
        public Scheduler getIOScheduler(){
            return Schedulers.immediate();
        }

        @Override
        public Scheduler getNewThreadScheduler(){
            return Schedulers.immediate();
        }

    };

    private final RxAndroidSchedulersHook mRxAndroidSchedulersHook = new RxAndroidSchedulersHook(){

        public Scheduler getMainTrheadeScheduler(){
            return Schedulers.immediate();
        }

    };


    @Override
    public Statement apply(final Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                RxAndroidPlugins.getInstance().reset();
                RxAndroidPlugins.getInstance().registerSchedulersHook(mRxAndroidSchedulersHook);

                RxJavaPlugins.getInstance().reset();
                RxJavaPlugins.getInstance().registerSchedulersHook(mRxJavaSchedulersHook);

                base.evaluate();

                RxAndroidPlugins.getInstance().reset();
                RxJavaPlugins.getInstance().reset();
            }
        };
    }
}
