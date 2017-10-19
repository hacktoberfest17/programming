package com.example.wellington.pokeapisample.repository.listener;

/**
 * Created by Wellington on 17/10/2016.
 */

public interface BaseListener {
    /**
     * Api Started Loading      * Time to show loading screen
     */
    void onRequestStarted();

    /**
     * Api Finished Loading      * Time to dismiss loading screen
     */
    void onRequestFinished();

    /**
     * Error occured      *      * @param error - Exception
     */
    void onError(Throwable error);
}