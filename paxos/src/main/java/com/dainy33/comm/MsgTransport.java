package com.dainy33.comm;

import com.dainy33.message.PaxosMsgTypeEnum;

/**
 * 发送数据的接口
 * Created by dainy33 on 2019-04-15.
 */
public interface MsgTransport {
    /**
     * 发送数据到特定节点
     * @param nodeID    节点ID
     * @param paxosMsg  字符串格式的消息
     * @param msgType   消息类型, {@link PaxosMsgTypeEnum}
     */
    void sendMsg(int nodeID, String paxosMsg, PaxosMsgTypeEnum msgType);

    /**
     * 发送数据到所有节点
     * @param paxosMsg  字符串格式的消息
     * @param msgType   消息类型, {@link PaxosMsgTypeEnum}
     */
    void broadcastMessage(String paxosMsg, PaxosMsgTypeEnum msgType);
}
