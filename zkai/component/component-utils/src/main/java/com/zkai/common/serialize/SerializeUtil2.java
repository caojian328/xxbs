package com.zkai.common.serialize;

import java.io.*;

public final class SerializeUtil2 {

    private SerializeUtil2(){}

    public static byte[] serialize(Object value) {

        try(FileReader f = new FileReader(new File(""))){
            f.read();
        }catch (FileNotFoundException e){

        }catch (java.io.IOException e2){

        }finally {

        }

        if (value == null) {
            throw new NullPointerException("Can't serialize null");
        }
        byte[] rv = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream os = null;
        try {
            bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            os.writeObject(value);
            os.close();
            bos.close();
            rv = bos.toByteArray();
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
            close(os);
            close(bos);
        }
        return rv;
    }


	public static Object deserialize(byte[] in) {
        return deserialize(in, Object.class);
    }

    public static <T> T deserialize(byte[] in, Class<T>...requiredType) {
        Object rv = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream is = null;
        try {
            if (in != null) {
                bis = new ByteArrayInputStream(in);
                is = new ObjectInputStream(bis);
                rv = is.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(is);
            close(bis);
        }
        return (T) rv;
    }

    private static void close(Closeable closeable) {
        if (closeable != null)
            try {
                closeable.close();
            } catch (IOException e) {
            	 e.printStackTrace();
            }
    }

}
