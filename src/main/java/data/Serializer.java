package data;

import java.io.*;

public class Serializer {
    public static final Serializer SERIALIZER=new Serializer();

    public <T> void serialize(T t, String fileName) {
        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(t);

            out.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public <T> T deserialize(String fileName) throws Exception{
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);

            return (T) in.readObject();
    }
}
