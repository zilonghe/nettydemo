package server.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import protocol.request.LogoutRequestPacket;
import protocol.response.LogoutResponsePacket;
import util.SessionUtil;

import java.util.Date;

/**
 * @author hezilong
 */
@ChannelHandler.Sharable
public class LogoutRequestHandler extends SimpleChannelInboundHandler<LogoutRequestPacket> {
    public static final LogoutRequestHandler INSTANCE = new LogoutRequestHandler();

    protected LogoutRequestHandler() {}

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogoutRequestPacket msg) throws Exception {
        System.out.println(new Date() + "：收到客户端登出请求");
        LogoutResponsePacket logoutResponsePacket = new LogoutResponsePacket();

        if (valid(msg)) {
            System.out.println(new Date() + "[" + SessionUtil.getSession(ctx.channel()).getUserName() + "]登出成功");
            SessionUtil.unBindSession(ctx.channel());
            logoutResponsePacket.setSuccess(true);
        } else {
            System.out.println(new Date() + "：登出失败！");
            logoutResponsePacket.setSuccess(false);
        }
        ctx.channel().writeAndFlush(logoutResponsePacket);
    }

    private boolean valid(LogoutRequestPacket logoutRequestPacket) {
        return true;
    }

}
