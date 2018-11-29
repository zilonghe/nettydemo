package client.console;

import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author hezilong
 */
public interface ConsoleCommand {
    void exec(Scanner scanner, Channel channel);
}
