package protocol.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import protocol.BasePacket;
import session.Session;

import static protocol.command.Command.GROUP_MESSAGE_RESPONSE;

/**
 * @author hezilong
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GroupMessageResponsePacket extends BasePacket {
    private String message;
    private Session fromUser;
    private String groupId;
    private boolean success;
    private String reason;

    @Override
    public Byte getCommand() {
        return GROUP_MESSAGE_RESPONSE;
    }
}
