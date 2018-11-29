package protocol.request;

import protocol.BasePacket;

import static protocol.command.Command.LOGOUT_REQUEST;

public class LogoutRequestPacket extends BasePacket {
    @Override
    public Byte getCommand() {
        return LOGOUT_REQUEST;
    }
}
