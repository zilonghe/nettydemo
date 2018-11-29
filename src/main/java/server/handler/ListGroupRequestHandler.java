package server.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import protocol.request.ListGroupRequestPacket;
import protocol.response.ListGroupResponsePacket;
import session.Session;
import util.SessionUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hezilong
 */
@ChannelHandler.Sharable
public class ListGroupRequestHandler extends SimpleChannelInboundHandler<ListGroupRequestPacket> {
    public static final ListGroupRequestHandler INSTANCE = new ListGroupRequestHandler();

    protected ListGroupRequestHandler() {}

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ListGroupRequestPacket msg) throws Exception {
        String groupId = msg.getGroupId();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);

        ListGroupResponsePacket responsePacket = new ListGroupResponsePacket();
        responsePacket.setGroupId(groupId);

        if (channelGroup == null || !channelGroup.contains(ctx.channel())) {
            responsePacket.setSuccess(false);
            responsePacket.setReason("不存在该群聊或你不在该群组中");
        } else {
            responsePacket.setSuccess(true);
            List<Session> sessionList = new ArrayList<>(channelGroup.size());
            for (Channel channel : channelGroup) {
                Session session = SessionUtil.getSession(channel);
                sessionList.add(session);
            }
            responsePacket.setSessionsList(sessionList);
        }
        ctx.channel().writeAndFlush(responsePacket);
    }
}
