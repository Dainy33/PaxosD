package com.dainy33.comm;

import com.dainy33.message.PaxosMsgTypeEnum;
import com.dainy33.message.TransMsg;

/**
 * Created by dainy33 on 2019-04-15.
 */
public interface MsgRecvListener {
    void onMsgRecv(PaxosMsgTypeEnum paxosMsgTypeEnum, TransMsg transMsg);
}
