package com.dainy33.sm;

/**
 * Created by dainy33 on 2019-04-14.
 */
public abstract class StateMachine {
    private int SMID;

    public int getSMID() {
        return SMID;
    }

    public void setSMID(int SMID) {
        this.SMID = SMID;
    }

    public abstract void execute(String value);
}
