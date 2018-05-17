package com.zkai.common.serialize;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.Session;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public final class SerializeUtil {

    private SerializeUtil(){}

    public static String serialize(Session session) {
        if(session == null)return "";
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(session);
            return Base64.encodeToString(bos.toByteArray());
        } catch (Exception e) {
            throw new RuntimeException("serialize session error", e);
        }
    }

    public static Session deserialize(String sessionStr) {
        if(sessionStr == null)return null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(Base64.decode(sessionStr));
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (Session) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("deserialize session error", e);
        }
    }

    public static String serializeObject(Object object) {
        try {
            if (object != null) {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(bos);
                oos.writeObject(object);
                return Base64.encodeToString(bos.toByteArray());
            } else
                return null;

        } catch (Exception e) {
            throw new RuntimeException("serialize session error", e);
        }
    }

    public static Object deserializeObject(String objectStr) {
        try {
            if (StringUtils.isNotEmpty(objectStr)) {
                ByteArrayInputStream bis = new ByteArrayInputStream(Base64.decode(objectStr));
                ObjectInputStream ois = new ObjectInputStream(bis);
                return ois.readObject();
            } else
                return null;

        } catch (Exception e) {
            throw new RuntimeException("deserialize session error", e);
        }
    }
}
