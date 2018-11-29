package protocol.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import protocol.BasePacket;
import session.Session;

import static protocol.command.Command.JOIN_GROUP_RESPONSE;

/**
 * @author hezilong
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class JoinGroupResponsePacket extends BasePacket {
    private Session joinMember;
    private String groupId;
    private boolean success;
    private String reason;
    @Override
    public Byte getCommand() {
        return JOIN_GROUP_RESPONSE;
    }
}
