package com.example.wellington.pokeapisample.presenter;

import android.content.Context;
import android.util.Log;

import com.example.wellington.pokeapisample.model.TestResponseEnum;
import com.example.wellington.pokeapisample.rule.RxSchedulersOverrideRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import rx.Scheduler;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;
import rx.plugins.RxJavaSchedulersHook;
import rx.schedulers.Schedulers;

/**
 * Created by Wellington on 18/10/2016.
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(Log.class)
@PowerMockIgnore("javax.net.ssl.*")
class BaseUnitTest  {

    @Mock
    Context fakeContext;

    @Rule public final RxSchedulersOverrideRule mRxSchedulersOverrideRule = new RxSchedulersOverrideRule();

    @Before
    public void setup(){
        startMocks();
    }

    private void startMocks(){
        MockitoAnnotations.initMocks(this);
        PowerMockito.mockStatic(Log.class);


        RxJavaPlugins.getInstance().registerErrorHandler(new RxJavaErrorHandler() {
            @Override
            public void handleError(Throwable e) {
                e.printStackTrace();
            }
        });
    }

    protected void printMessage(String className, String methodName, String message, TestResponseEnum testResponseEnum){
        System.out.println("className = [" + className + "], methodName = [" + methodName + "], message = [" + message + "], testResponseEnum = [" + testResponseEnum + "]");
    }


}
