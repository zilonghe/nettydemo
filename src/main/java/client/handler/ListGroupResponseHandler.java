package client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import protocol.response.ListGroupResponsePacket;

/**
 * @author hezilong
 */
public class ListGroupResponseHandler extends SimpleChannelInboundHandler<ListGroupResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ListGroupResponsePacket msg) throws Exception {
        if (msg.isSuccess()) {
            System.out.println("群[" + msg.getGroupId() + "]中的人包括：" + msg.getSessionsList());
        } else {
            System.out.println("获取群聊[" + msg.getGroupId() + "]群成员列表失败，原因：" + msg.getReason());
        }
    }
}
