package protocol.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import protocol.BasePacket;
import session.Session;

import static protocol.command.Command.QUIT_GROUP_RESPONSE;

/**
 * @author hezilong
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class QuitGroupResponsePacket extends BasePacket {
    private boolean success;
    private String groupId;
    private String reason;
    private Session quitMember;
    @Override
    public Byte getCommand() {
        return QUIT_GROUP_RESPONSE;
    }
}
