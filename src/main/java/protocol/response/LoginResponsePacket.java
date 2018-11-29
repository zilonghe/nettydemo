package protocol.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import protocol.BasePacket;

import static protocol.command.Command.LOGIN_RESPONSE;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoginResponsePacket extends BasePacket {
    private String userName;

    private String userId;

    private boolean success;

    private String reason;

    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }
}
