package protocol.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import protocol.BasePacket;

import static protocol.command.Command.GROUP_MESSAGE_REQUEST;

/**
 * @author hezilong
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GroupMessageRequestPacket extends BasePacket {
    private String message;
    private String groupId;
    @Override
    public Byte getCommand() {
        return GROUP_MESSAGE_REQUEST;
    }
}
