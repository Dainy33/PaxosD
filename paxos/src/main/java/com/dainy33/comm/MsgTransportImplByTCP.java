package com.dainy33.comm;

import com.dainy33.message.PaxosMsgTypeEnum;
import com.dainy33.message.TransMsg;
import com.dainy33.message.TransMsgHead;
import com.dainy33.node.NodeInfo;

import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by dainy33 on 2019-04-20.
 */
public class MsgTransportImplByTCP implements MsgTransport {
    private List<NodeInfo> nodeInfos;
    private TCPClient tcpClient;

    public MsgTransportImplByTCP(List<NodeInfo> nodeInfos) {
        this.nodeInfos = nodeInfos;
        tcpClient = new TCPClient();
        tcpClient.init();
        tcpClient.addNodeInfo(nodeInfos);
        tcpClient.startClient();
    }

    @Override
    public void sendMsg(int nodeID, String paxosMsg, PaxosMsgTypeEnum msgType) {
        byte[] msgBytes = paxosMsg.getBytes(Charset.forName("UTF-8"));
        TransMsgHead transMsgHead = new TransMsgHead(1, msgType, 0, msgBytes.length);
        TransMsg transMsg = new TransMsg(transMsgHead, msgBytes);
        this.tcpClient.sendMsg(nodeID, transMsg, MsgSendListener.DO_NOTHING);
    }

    @Override
    public void broadcastMessage(String paxosMsg, PaxosMsgTypeEnum msgType) {
        for (NodeInfo node : nodeInfos) {
            sendMsg(node.getNodeID(), paxosMsg, msgType);
        }
    }
}
