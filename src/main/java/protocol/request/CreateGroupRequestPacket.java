package protocol.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import protocol.BasePacket;

import java.util.List;

import static protocol.command.Command.CREATE_GROUP_REQUEST;

/**
 * @author hezilong
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CreateGroupRequestPacket extends BasePacket {
    private List<String> userIdList;
    @Override
    public Byte getCommand() {
        return CREATE_GROUP_REQUEST;
    }
}
