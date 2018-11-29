package protocol.request;

import lombok.EqualsAndHashCode;
import protocol.BasePacket;

import static protocol.command.Command.LOGIN_REQUEST;

@EqualsAndHashCode(callSuper = true)
@lombok.Data
public class LoginRequestPacket extends BasePacket {

    private String userId;

    private String userName;

    private String password;

    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}
