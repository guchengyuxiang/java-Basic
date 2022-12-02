package io.data;

import java.io.*;

public class DataStreamTest {
    public static void main(String[] args) {
        File file = new File("java-io/src/main/java/io/data/data.log");
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(file));
             DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file))) {
            dataOutputStream.writeInt(101);
            dataOutputStream.writeLong(101L);
            dataOutputStream.writeDouble(101.33D);
            dataOutputStream.writeFloat(101.33F);
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeBoolean(false);

            System.out.println(inputStream.readInt());
            System.out.println(inputStream.readLong());
            System.out.println(inputStream.readDouble());
            System.out.println(inputStream.readFloat());
            System.out.println(inputStream.readBoolean());
            System.out.println(inputStream.readBoolean());
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
