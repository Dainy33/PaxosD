package com.dainy33.comm;

/**
 * Created by dainy33 on 2019-04-27.
 */
public interface MsgReceiver {
    void startServer();
    void addMsgReceiverListener(MsgRecvListener msgRecvListener);
}
