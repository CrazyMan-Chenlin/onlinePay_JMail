package JMail;


import java.util.Base64;

public class Base64Demo {
      public static void main(String[] args) {
          Base64.Encoder encoder = Base64.getEncoder();
            System.out.println(encoder.encodeToString(("13247529607@163.com").getBytes()));
            System.out.println(encoder.encodeToString(("269344402cl").getBytes()));
      }
}
