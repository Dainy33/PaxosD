package com.dainy33.comm;

/**
 * Created by dainy33 on 2019-04-27.
 */
public class MsgReceiverImplByTCP implements MsgReceiver {
    private TCPServer tcpServer;

    public MsgReceiverImplByTCP(String ip, int port) {
        this.tcpServer = new TCPServer();
        tcpServer.setListenIP(ip);
        tcpServer.setListenPort(port);
    }

    @Override
    public void startServer() {
        tcpServer.startCommServer();
    }

    @Override
    public void addMsgReceiverListener(MsgRecvListener msgRecvListener) {
        tcpServer.setMsgRecvListener(msgRecvListener);
    }
}
