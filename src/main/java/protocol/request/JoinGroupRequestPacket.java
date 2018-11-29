package protocol.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import protocol.BasePacket;

import static protocol.command.Command.JOIN_GROUP_REQUEST;

/**
 * @author hezilong
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class JoinGroupRequestPacket extends BasePacket {
    private String groupId;
    @Override
    public Byte getCommand() {
        return JOIN_GROUP_REQUEST;
    }
}
