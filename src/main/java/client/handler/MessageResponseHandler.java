package client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import protocol.response.MessageResponsePacket;

/**
 * @author hezilong
 */
public class MessageResponseHandler extends SimpleChannelInboundHandler<MessageResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageResponsePacket messageResponsePacket) throws Exception {
        if (!messageResponsePacket.isSuccess()) {
            System.out.println("消息发送失败，原因：" + messageResponsePacket.getReason());
            return;
        }
        String fromUserId = messageResponsePacket.getFromUserId();
        String fromUserName = messageResponsePacket.getFromUserName();

        if (fromUserId == null || fromUserName == null) {
            System.out.println("发送成功！");
        } else {
            System.out.println(fromUserId + ":" + fromUserName + " -> " + messageResponsePacket.getMessage());
        }
    }
}
