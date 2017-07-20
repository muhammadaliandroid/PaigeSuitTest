package uk.co.mali.pagesuitetest.utils.rxutils;

import rx.Scheduler;

/**
 * Created by alig2 on 26/06/2017.
 */

public interface IRxSchedulers {

    Scheduler runOnBackground();
    Scheduler io();
    Scheduler compute();
    Scheduler androidThread();
    Scheduler internet();



}
