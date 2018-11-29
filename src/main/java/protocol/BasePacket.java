package protocol;


/**
 * @author hezilong
 */
@lombok.Data
public abstract class BasePacket {
    /**
     * 协议版本
     */
    private Byte version = 1;

    /**
     * 指令
     * @return 指令
     */
    public abstract Byte getCommand();
}
