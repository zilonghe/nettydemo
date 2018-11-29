package client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import protocol.response.GroupMessageResponsePacket;

/**
 * @author hezilong
 */
public class GroupMessageResponseHandler extends SimpleChannelInboundHandler<GroupMessageResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMessageResponsePacket msg) throws Exception {
        if (msg.isSuccess()) {
            System.out.println("收到群[" + msg.getGroupId() + "]中[" + msg.getFromUser() + "]发来的消息：" + msg.getMessage());
        } else {
            System.out.println("发送群聊消息失败，原因：" + msg.getReason());
        }
    }
}
