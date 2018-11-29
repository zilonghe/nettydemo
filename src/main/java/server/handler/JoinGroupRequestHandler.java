package server.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import protocol.request.JoinGroupRequestPacket;
import protocol.response.JoinGroupResponsePacket;
import util.SessionUtil;

/**
 * @author hezilong
 */
@ChannelHandler.Sharable
public class JoinGroupRequestHandler extends SimpleChannelInboundHandler<JoinGroupRequestPacket> {
    public static final JoinGroupRequestHandler INSTANCE = new JoinGroupRequestHandler();

    protected JoinGroupRequestHandler() {}

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, JoinGroupRequestPacket msg) throws Exception {
        String groupId = msg.getGroupId();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);

        JoinGroupResponsePacket joinGroupResponsePacket = new JoinGroupResponsePacket();
        joinGroupResponsePacket.setGroupId(groupId);
        if (channelGroup == null) {
            joinGroupResponsePacket.setSuccess(false);
            joinGroupResponsePacket.setReason("群聊id[" + groupId + "]不存在");
        } else {
            joinGroupResponsePacket.setSuccess(true);
            joinGroupResponsePacket.setJoinMember(SessionUtil.getSession(ctx.channel()));
            channelGroup.writeAndFlush(joinGroupResponsePacket);
            channelGroup.add(ctx.channel());
        }
        ctx.channel().writeAndFlush(joinGroupResponsePacket);
    }
}
