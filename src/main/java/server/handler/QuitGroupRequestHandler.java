package server.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import protocol.request.QuitGroupRequestPacket;
import protocol.response.QuitGroupResponsePacket;
import util.SessionUtil;

/**
 * @author hezilong
 */
@ChannelHandler.Sharable
public class QuitGroupRequestHandler extends SimpleChannelInboundHandler<QuitGroupRequestPacket> {
    public static final QuitGroupRequestHandler INSTANCE = new QuitGroupRequestHandler();

    protected QuitGroupRequestHandler() {}

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, QuitGroupRequestPacket msg) throws Exception {
        String groupId = msg.getGroupId();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);
        QuitGroupResponsePacket responsePacket = new QuitGroupResponsePacket();
        responsePacket.setGroupId(groupId);
        if (channelGroup == null || !channelGroup.contains(ctx.channel())) {
            responsePacket.setSuccess(false);
            responsePacket.setReason("要退出的群聊[" + groupId + "]不存在或你不在该群聊中");
        } else {
            responsePacket.setSuccess(true);
            responsePacket.setQuitMember(SessionUtil.getSession(ctx.channel()));
            channelGroup.remove(ctx.channel());
            if (channelGroup.size() == 0) {
                SessionUtil.removeChannelGroup(groupId);
            } else {
                channelGroup.writeAndFlush(responsePacket);
            }
        }
        ctx.channel().writeAndFlush(responsePacket);
    }
}
