package top.byoung.demo.jar.serialize;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtobufIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import top.byoung.demo.jar.objenesis.User;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @description: serialize test
 * @author: Yang Weixin
 * @create: 2019/12/10
 */
public class SerializeTest {

    public static void main(String[] args) {
        User user = new User("杨悦熙", 1, 10);
        Schema schema = RuntimeSchema.createFrom(User.class);
        byte[] bytes = ProtobufIOUtil.toByteArray(user, schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
        System.out.println("-----> protobuf: "+ bytes);

        try(ByteArrayOutputStream bao = new ByteArrayOutputStream();ObjectOutputStream out = new ObjectOutputStream(bao);) {
            out.writeObject(user);
            byte[] bytes1 = bao.toByteArray();
            System.out.println("-----> java serialize: "+ bytes1.toString());
            ByteArrayInputStream bai = new ByteInputStream(bytes1, bytes1.length);
            ObjectInputStream ois = new ObjectInputStream(bai);

            User user1 = (User)ois.readObject();
            System.out.println(user1);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
