package com.dainy33.core;

import com.dainy33.comm.MsgTransport;
import com.dainy33.message.PaxosMsgTypeEnum;
import com.dainy33.node.NodeInfo;

/**
 * Proposer, Accepter, Learner 的父类
 * Created by dainy33 on 2019-04-20.
 */
public class Base {
    private MsgTransport msgTransport;

    // 当前proposer所在的instance
    private InstanceManager InstanceManager;

    // 当前节点信息
    private NodeInfo curNodeInfo;

    public Base(MsgTransport msgTransport, InstanceManager InstanceManager, NodeInfo curNodeInfo) {
        this.msgTransport = msgTransport;
        this.InstanceManager = InstanceManager;
        this.curNodeInfo = curNodeInfo;
    }

    /**
     * @param nodeID
     * @param paxosMsg
     * @param msgType
     */
    public void sendMsg(int nodeID, String paxosMsg, PaxosMsgTypeEnum msgType) {
        this.msgTransport.sendMsg(nodeID, paxosMsg, msgType);
    }

    /**
     * @param paxosMsg
     * @param msgType
     */
    public void broadcastMessage(String paxosMsg, PaxosMsgTypeEnum msgType) {
        this.msgTransport.broadcastMessage(paxosMsg, msgType);
    }

    public InstanceManager getInstanceManager() {
        return InstanceManager;
    }

    public NodeInfo getCurNodeInfo() {
        return curNodeInfo;
    }
}
