package protocol.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import protocol.BasePacket;

import static protocol.command.Command.LOGOUT_RESPONSE;

/**
 * @author hezilong
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LogoutResponsePacket extends BasePacket {
    private boolean success;
    @Override
    public Byte getCommand() {
        return LOGOUT_RESPONSE;
    }
}
