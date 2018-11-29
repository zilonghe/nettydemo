package client.console;

import io.netty.channel.Channel;
import protocol.request.MessageRequestPacket;

import java.util.Scanner;

/**
 * @author hezilong
 */
public class SendToUserConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner sc, Channel channel) {
        System.out.print("发送消息至用户(格式：用户id 消息)：");
        String toUserId = sc.next();
        String message = sc.next();
        channel.writeAndFlush(new MessageRequestPacket(toUserId, message));
    }
}
