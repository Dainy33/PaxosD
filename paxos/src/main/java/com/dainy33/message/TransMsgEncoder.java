package com.dainy33.message;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by dainy33 on 2019-04-14.
 */
public class TransMsgEncoder extends MessageToByteEncoder<TransMsg> {
    @Override
    protected void encode(ChannelHandlerContext ctx, TransMsg msg, ByteBuf out) throws Exception {
        int version = msg.getTransMsgHead().getVersion();
        int msgType = msg.getTransMsgHead().getMsgType().getMsgId();
        int id = msg.getTransMsgHead().getId();
        int length = msg.getTransMsgHead().getMsgLength();
        byte[] data = msg.getPaxosMsg();

        out.writeShort(version);
        out.writeShort(msgType);
        out.writeInt(id);
        out.writeInt(length);
        out.writeBytes(data);
    }
}
