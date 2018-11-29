package protocol.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import protocol.BasePacket;

import static protocol.command.Command.LIST_GROUP_REQUEST;

@EqualsAndHashCode(callSuper = true)
@Data
public class ListGroupRequestPacket extends BasePacket {
    private String groupId;
    @Override
    public Byte getCommand() {
        return LIST_GROUP_REQUEST;
    }
}
