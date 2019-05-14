package com.dainy33.comm;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import com.dainy33.node.NodeInfo;

/**
 * Created by dainy33 on 2019-04-14.
 */
public class TCPClientHandler extends ChannelInboundHandlerAdapter {
    private TCPClient tcpClient;

    public TCPClientHandler(TCPClient tcpClient) {
        this.tcpClient = tcpClient;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        NodeInfo nodeInfo = tcpClient.getServerByChannel(ctx.channel().id());
        tcpClient.doConnect(nodeInfo);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
