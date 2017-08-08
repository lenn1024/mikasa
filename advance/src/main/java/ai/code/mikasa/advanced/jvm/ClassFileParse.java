package ai.code.mikasa.advanced.jvm;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lenn on 17/5/4.
 */
public class ClassFileParse {
    public static void main(String[] args) throws IOException {
        ClassFileParse parser = new ClassFileParse();
        parser.parse(new FileInputStream("ByteCode.class"));
    }

    public void parse(InputStream is) throws IOException {
        DataInputStream dis = new DataInputStream(is);

        // magic
        int magic = dis.readInt();
        if(magic != 0xcafebabe){
            throw new RuntimeException("找不到魔数.");
        }

        // version
        int minorVersion = dis.readShort();
        int majorVersion = dis.readShort();
        System.out.println("minor version:" + minorVersion);
        System.out.println("major version:" + majorVersion);

        // constant pool
        System.out.println("==============常量池详情===============");
        int constantPoolCount = dis.readShort();
        System.out.println("constant pool count:" + constantPoolCount);
        for(int i=1; i < constantPoolCount; i++){
            System.out.println("");
            System.out.println("第" + i + "个常量");
            int tag = dis.readByte();
            switch (tag){
                case 1:
                    System.out.println("类型: CONSTANT_Utf8_info");
                    int length = dis.readShort();
                    System.out.println("长度: " + length);
                    byte[] bytes = new byte[length];
                    dis.read(bytes);
                    String value = new String(bytes, "utf8");
                    System.out.println("value: " + value);
                    break;
                case 3:
                    System.out.println("类型: CONSTANT_Integer_info");
                    System.out.println("value: " + dis.readInt());
                    break;
                case 4:
                    System.out.println("类型: CONSTANT_Float_info");
                    System.out.print("value: " + dis.readFloat());
                    break;
                case 5:
                    System.out.println("类型: CONSTANT_Long_info");
                    System.out.print("value: " + dis.readLong());
                    break;
                case 6:
                    System.out.println("类型: CONSTANT_Double_info");
                    System.out.print("value: " + dis.readDouble());
                    break;
                case 7:
                    System.out.println("类型: CONSTANT_Class_info");
                    System.out.println("index: " + dis.readShort());
                    break;
                case 8:
                    System.out.println("类型: CONSTANT_String_info");
                    System.out.println("index: " + dis.readShort());
                    break;
                case 9:
                    System.out.println("类型: CONSTANT_Fieldref_info");
                    System.out.println("index: " + dis.readShort());
                    System.out.println("index: " + dis.readShort());
                    break;
                case 10:
                    System.out.println("类型: CONSTANT_Methodref_info");
                    System.out.println("index: " + dis.readShort());
                    System.out.println("index: " + dis.readShort());
                    break;
                case 11:
                    System.out.println("类型: CONSTANT_InrerfaceMethodref_info");
                    System.out.println("index: " + dis.readShort());
                    System.out.println("index: " + dis.readShort());
                    break;
                case 12:
                    System.out.println("类型: CONSTANT_NameAndType_info");
                    System.out.println("index: " + dis.readShort());
                    System.out.println("index: " + dis.readShort());
                    break;
                default:break;
            }
        }

        // access_flags
        dis.readShort();

        // this_class
        System.out.println("this class index: " + dis.readShort());

        // super_class
        System.out.println("super class index: " + dis.readShort());

        // interfaces_count
        int interfacesCount = dis.readShort();
        System.out.println("========== 接口信息 ==========");
        for (int i = 0; i < interfacesCount; i++){
            System.out.println("index: " + dis.readShort());
        }

        // field count
        System.out.println("========== 字段信息 ==========");
//        int fieldCount = dis.readShort();
//        for(int i=0; i < fieldCount; i++){
//            // access_flags
//            System.out.println("");
//            System.out.println("access flags: " + dis.readShort());
//
//            // name_index
//            dis.readShort();
//            System.out.println("name index: " + dis.readShort());
//
//            // descriptor_index
//            System.out.println("descriptor index: " + dis.readShort());
//
//            // attribute
//            int attributeCount = dis.readShort();
//            for(int j = 0; j < attributeCount; j++){
//                System.out.println("");
//                System.out.println("attribute name index: " + dis.readShort());
//                // todo
//            }
//        }


        dis.close();
    }
}
