package util;

import attribute.Attributes;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import session.Session;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hezilong
 */
public class SessionUtil {

    private static final Map<String, Channel> USER_ID_CHANNEL_MAP = new ConcurrentHashMap<>();

    private static final Map<String, ChannelGroup> GROUP_ID_CHANNEL_GROUP_MAP = new ConcurrentHashMap<>();

    public static void bindSession(Session session, Channel channel) {
        USER_ID_CHANNEL_MAP.put(session.getUserId(), channel);
        channel.attr(Attributes.SESSION).set(session);
    }

    public static void unBindSession(Channel channel) {
        if (hasLogin(channel)) {
            USER_ID_CHANNEL_MAP.remove(getSession(channel).getUserId());
            channel.attr(Attributes.SESSION).set(null);
        }
    }

    public static boolean hasLogin(Channel channel) {
        return channel.hasAttr(Attributes.SESSION);
    }

    public static Session getSession(Channel channel) {

        return channel.attr(Attributes.SESSION).get();
    }

    public static Channel getChannel(String userId) {

        return USER_ID_CHANNEL_MAP.get(userId);
    }

    public static void bindChannelGroup(String groupId, ChannelGroup channelGroup) {
        GROUP_ID_CHANNEL_GROUP_MAP.put(groupId, channelGroup);
    }

    public static ChannelGroup getChannelGroup(String groupId) {
        return GROUP_ID_CHANNEL_GROUP_MAP.get(groupId);
    }

    public static void removeChannelGroup(String groupId) {
        GROUP_ID_CHANNEL_GROUP_MAP.remove(groupId);
    }

    public static void main(String[] args) {
        Map<String, Integer> db = new HashMap<>();
        db.put("DFHXR",1);
        db.put("YSXFJ",1);
        db.put("TUDDY",1);
        db.put("AXVUH",1);
        db.put("RUTWZ",1);
        db.put("DEDUC",1);
        db.put("WFCVW",1);
        db.put("ZETCU",1);
        db.put("GCVUR",1);
    }

    public static class Hzl {
        private int name;

        public Hzl(int name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            return false;
        }

        @Override
        public int hashCode() {
            return 1;
        }
    }
}
