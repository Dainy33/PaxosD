package com.dainy33.comm;

/**
 * Created by dainy33 on 2019-04-15.
 */
public interface MsgSendListener {
    public static enum MsgSendRetEnum {
        SUCCESS,
        FAIL,
        OTHER
    }

    void onMsgSendRet(MsgSendRetEnum msgSendRetEnum, int msgId);

    // 不做任何事的listener
    MsgSendListener DO_NOTHING = (msgSendRetEnum, msgId) -> {};
}
