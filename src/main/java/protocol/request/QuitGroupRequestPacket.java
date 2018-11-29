package protocol.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import protocol.BasePacket;

import static protocol.command.Command.QUIT_GROUP_REQUEST;

/**
 * @author hezilong
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class QuitGroupRequestPacket extends BasePacket {
    private String groupId;
    @Override
    public Byte getCommand() {
        return QUIT_GROUP_REQUEST;
    }
}
