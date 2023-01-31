package com.saffy.day08.IO;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Reader, writer는 char지원 -> 2바이트씩 읽기 때문에 한글을 입력해도 깨지지 않음
 * Input/Output Stream은 byte지원 -> 1바이트씩 읽기 때문에 한글 입력시 깨짐
 * 
 * 추가로 JVM 내부에서 한글은 2바이트
 * 파일 입출력 클래스명은 어떤 타입의 파일을 char/byte로 처리할래가 명시되어있다.
 */
public class Test {
    public static void main(String[] args) {
        try {
            
            
//            //현재 디렉토리 (".")는 프로젝트 폴더
//            //버퍼의 목적은 속도향상
//            FileWriter fw = new FileWriter("a.txt");
//            BufferedWriter bw = new BufferedWriter(fw); //fw만 사용해서도 파일을 읽을 수 있지만 속도 향상을 위해  Buffer사용
            
//            bw.write("abc");
            /*    해당 구문 실행시 파일은 생성되지만 내용은 없음
                 왜? 버퍼가 가득 차지 않아서!
                 flush를 통해 강제 출력 후 close해야 정상 적인 프로그래밍 
            */
    
            //이후 try with resources가 구문이 등장하며  autocloseable 인터페이스를 통해
            //수동으로 close할 필요가 사라짐
//            System.out.println("end...");
//            
//            
//        
//            /* <<파일 입출력이 어려운 이유>> - 프로그램에 걸맞는 타입을 선정하기 어려움
//             * 이미지 파일 -> byte
//             * 한글은 -> char
//             * 음악 파일 -> byte
//             * 영어 숫자 -> char/byte 
//             * 이모지 -> char + 인코딩 호환성 고려
            
//             * 근데 byte로 읽어온 데이터들은 text editor로 확인이 어려움(주로 비정형 데이터)
//             * 플러그인 프로그램 없이 볼 수 있다 -> char 권장
//             * (.docs, .hwp, .xls파일은 전용 프로그램 없이 볼 수 없다)
//             * 한글, 특수문자가 없다면 byte 써도됨
//             * 
//             * 파일 입출력의 주 목적은 파일을 읽어와 활용(내용 변경)하기 때문에 타입에 대한 신경을 써야한다.. 
//             */
            
            
//            DataOutputStream out = new DataOutputStream(out);
//            //data reader, writer는 없음! 일반적인 Data(음악, 이미지 등)들은 byte로 이루어져 char가 필요없음
//            //수업 내용중 Object I/O stream은 메모리에 저장된 객체 정보를 byte정보로 끌어쓰기 위한 것
//            //따라서 byte를 처리하기 위한 클래스들(I/OStream)은 char처리를 지원하는 read(),write()가 없다!!
//            //byte함수에서는 정수, 실수를 다 쓰기 위해서는 writeInt(), writeDouble()이라는 메서드를 통해 parameter 자체로 처리할 수 있게함
//            
//            
            
//            //반면 XXer클래스 들은 메소드 오버로딩을 통해 동일한 함수명에 다양한 파라미터를 처리할 수 있다.
//            //한글은 2바이트기 때문에 바이트 처리하는 클래스 선언시 마지막 바이트만 입력되므로 글자가 깨짐
            FileWriter fw = new FileWriter("a.txt");
            fw.write(97); //a가 입력됨
            //fw.write('a');//a가 입력됨
            //이유 ? => int specifying a character to be written
            //int값을 character형태로 변환하여 쓰여지게 된다.
            //fw.write("hello java"); -> write(String str)로 오버로딩 된 write함수 실행
        
//            //97은 2바이트 내의 범위라 정상 저장되지만 2바이트를 초과하는 int 값은 하위 2바이트만 저장되어 깨짐 
            
//            //숫자는 아스키코드 값을 가진 숫자가 입력되고
//            //받아올 때는 아스키코드 값을 받아옴 -> write할 때 read할 때 서로 상호호환이 되야하니까,..

//            //숫자를 정확하게 쓰고 싶다면 다른 형식의 함수를 사용해야함        
            fw.close();
            
            
            //<바이트 단위로 적기>
//            FileOutputStream fos = new FileOutputStream("b.txt");
//            DataOutputStream dos = new DataOutputStream(fos);
//            dos.writeInt(11);
//            dos.writeDouble(150.12);
//            dos.close();
//            fos.close();
//            System.out.println("입력 테스트");
            
            //<바이트 파일 읽어오기>>
//            FileInputStream fis = new FileInputStream("b.txt");
//            DataInputStream dis = new DataInputStream(fis);
//            int a = dis.readInt();
//            double b = dis.readDouble();
//            System.out.println(a+ ", " + b);
//            System.out.println("읽기 테스트");
            
            
            //<오브젝트 파일 적기> - 객체는 Serializable을 implements 해야함
//            FileOutputStream fos = new FileOutputStream("c.txt");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(new User());
//            oos.close();
//            fos.close();
//            System.out.println("입력 테스트");
            
            //<오브젝트 파일 적기>
            FileInputStream fis = new FileInputStream("c.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            System.out.println(o);
            System.out.println("읽기 테스트");
            

        }catch(Exception e) {
            e.printStackTrace();
        }
        
        //이클립스는 실시간 새로고침을 허용하지 않음. 시스템 리소스를 잡아먹기 때문에
    }
    static class User implements Serializable{
        //serializable은 메소드가 없다,,!
        /*    
         *     <serializableVersionUID가 없을 때> 
         *  클래스파일을 불러(InputStream)와 수정하여 저장(OutputStream)
         *  이후에 불러오면 파일 내용이 변경되어 버전이 달라졌기에 제대로 인식할 수 없음
         *  
         *  <serializableVersionUID가 있다면> 
         *  클래스파일을 불러(InputStream)와 수정하여 저장(OutputStream)
         *  이후에 불러오면 파일 내용이 변경되어도 UID가 작성되어 있기 때문에 컴파일러가 매칭을 통해 정상인식
         *  
         *  파일로 저장하면안되는 민감한 정보는 transient 선언을 통해 null로 저장할 수 있음
         */
    }
}
