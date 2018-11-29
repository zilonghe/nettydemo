package client.handler;

import client.console.ConsoleCommandManager;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import protocol.response.LoginResponsePacket;
import session.Session;
import util.SessionUtil;

import java.util.Date;

public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, LoginResponsePacket loginResponsePacket) throws Exception {
        String userId = loginResponsePacket.getUserId();
        String userName = loginResponsePacket.getUserName();

        if (loginResponsePacket.isSuccess()) {
            SessionUtil.bindSession(new Session(userId, userName), channelHandlerContext.channel());
            System.out.println("[" + userName + "]登录成功，userId 为: " + loginResponsePacket.getUserId());
            System.out.println("支持的操作：");
            ConsoleCommandManager.getConsoleCommandMap().keySet().forEach(System.out::println);
        } else {
            System.out.println(new Date() + " 客户端登陆失败，原因：" + loginResponsePacket.getReason());
        }
    }
}
