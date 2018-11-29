package protocol.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import protocol.BasePacket;

import java.util.List;

import static protocol.command.Command.CREATE_GROUP_RESPONSE;

/**
 * @author hezilong
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CreateGroupResponsePacket extends BasePacket {
    private boolean success;
    private String groupId;
    private List<String> userNameList;

    @Override
    public Byte getCommand() {
        return CREATE_GROUP_RESPONSE;
    }
}
