package com.yacov.databaseapp;

/**
 * Created by YacovR on 19-Oct-17.
 */

public class Tasks {
    private int id;
    private String _taskName;

    public void Tasks(){

    }

    public Tasks(String _taskName){
        this._taskName = _taskName;
    }

    public int getId() {
        return id;
    }

    public String get_taskName() {
        return _taskName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void set_taskName(String _taskName) {
        this._taskName = _taskName;
    }
}
