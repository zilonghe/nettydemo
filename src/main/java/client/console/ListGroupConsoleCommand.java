package client.console;

import io.netty.channel.Channel;
import protocol.request.ListGroupRequestPacket;

import java.util.Scanner;

/**
 * @author hezilong
 */
public class ListGroupConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.print("输入groupId，获取群成员列表：");
        String groupId = scanner.next();
        ListGroupRequestPacket listGroupRequestPacket = new ListGroupRequestPacket();
        listGroupRequestPacket.setGroupId(groupId);
        channel.writeAndFlush(listGroupRequestPacket);
    }
}
