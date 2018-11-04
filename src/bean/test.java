package bean;
import java.util.Calendar;
import java.util.Date;


public class test {
    public static void main(String[] args) {
        /*Calendar calendar =Calendar.getInstance();
        calendar.set(2018,9,25,10,0);
        System.out.println(calendar.getTime());
        Calendar calendar1 = Calendar.getInstance();
       calendar1.add(Calendar.DATE,2);
       if (calendar.before(calendar1)){
           System.out.println(calendar1.getTime());
       }else{
           System.out.println("时间在此之后");
       }*/
        Calendar calendar =Calendar.getInstance();
        calendar.set(2018,9,25,12,30,0);
        calendar.add(Calendar.DATE,2);
        Calendar calendar1 =Calendar.getInstance();
        calendar.setTime(new Date());
        System.out.println(calendar1.before(calendar));
    }
}
