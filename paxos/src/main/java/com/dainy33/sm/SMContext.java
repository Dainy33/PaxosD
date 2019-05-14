package com.dainy33.sm;

/**
 * StateMachine 需要用到的context
 * Created by dainy33 on 2019-04-19.
 */
public class SMContext<T> {
    private int SMID;
    private T ctx;

    public SMContext(int SMID, T ctx) {
        this.SMID = SMID;
        this.ctx = ctx;
    }

    public int getSMID() {
        return SMID;
    }

    public void setSMID(int SMID) {
        this.SMID = SMID;
    }

    public T getCtx() {
        return ctx;
    }

    public void setCtx(T ctx) {
        this.ctx = ctx;
    }
}
