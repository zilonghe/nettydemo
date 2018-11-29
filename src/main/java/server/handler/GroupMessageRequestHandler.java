package server.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import protocol.request.GroupMessageRequestPacket;
import protocol.response.GroupMessageResponsePacket;
import session.Session;
import util.SessionUtil;

/**
 * @author hezilong
 */
@ChannelHandler.Sharable
public class GroupMessageRequestHandler extends SimpleChannelInboundHandler<GroupMessageRequestPacket> {
    public static final GroupMessageRequestHandler INSTANCE = new GroupMessageRequestHandler();

    protected GroupMessageRequestHandler() {}

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMessageRequestPacket msg) throws Exception {
        GroupMessageResponsePacket responsePacket = new GroupMessageResponsePacket();

        String groupId = msg.getGroupId();
        responsePacket.setGroupId(groupId);
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);

        if (channelGroup == null || !channelGroup.contains(ctx.channel())) {
            responsePacket.setSuccess(false);
            responsePacket.setReason("不存在该群聊或者你不在该群聊中");
            ctx.channel().writeAndFlush(responsePacket);
        } else {
            Session fromUser = SessionUtil.getSession(ctx.channel());
            responsePacket.setSuccess(true);
            responsePacket.setFromUser(fromUser);
            responsePacket.setMessage(msg.getMessage());
            channelGroup.writeAndFlush(responsePacket);
        }
    }
}
