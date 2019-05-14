package com.dainy33.comm;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import com.dainy33.message.TransMsg;

/**
 * Created by dainy33 on 2019-04-14.
 */
public class TCPServerHandler extends ChannelInboundHandlerAdapter {
    private TCPServer tcpServer;

    public TCPServerHandler(TCPServer tcpServer) {
        this.tcpServer = tcpServer;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        TransMsg transMsg = (TransMsg)msg;

        MsgRecvListener msgRecvListener = tcpServer.getMsgRecvListener();
        msgRecvListener.onMsgRecv(transMsg.getTransMsgHead().getMsgType(), transMsg);

        ReferenceCountUtil.release(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
