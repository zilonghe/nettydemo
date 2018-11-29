package attribute;

import io.netty.util.AttributeKey;
import session.Session;

/**
 * @author hezilong
 */
public interface Attributes {
    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");
}
