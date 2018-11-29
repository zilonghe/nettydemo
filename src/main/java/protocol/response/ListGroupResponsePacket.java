package protocol.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import protocol.BasePacket;
import session.Session;

import java.util.List;

import static protocol.command.Command.LIST_GROUP_RESPONSE;

/**
 * @author hezilong
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ListGroupResponsePacket extends BasePacket {
    private String groupId;
    private List<Session> sessionsList;
    private boolean success;
    private String reason;
    @Override
    public Byte getCommand() {
        return LIST_GROUP_RESPONSE;
    }
}
