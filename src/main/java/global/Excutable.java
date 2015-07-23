package global;


import com.neo4j.demo.bean.DateInfoBean;
import com.neo4j.demo.bean.DatesBean;
import com.neo4j.demo.bean.UserBean;
import com.neo4j.demo.entity.DateInfo;
import com.neo4j.demo.entity.Dates;
import com.neo4j.demo.entity.User;
import java.util.Iterator;
import org.json.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Excutable {
   public static ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
   
   static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("file:/Users/yorg/Developer/ZhaiClansServer/beans.xml");
   static UserBean userBean = (UserBean)context.getBean("userBean");
   static DateInfoBean dateInfoBean = (DateInfoBean)context.getBean("dateInfoBean");
   static DatesBean datesBean = (DatesBean)context.getBean("datesBean");
   
   
   public static void main(String[] args){
      
      String s = dateInfoBean.getOneUnmatched();
      
      System.out.println(s);
      
//      populateGraph();
      testAllUser();
      testAllDateInfo();
      testAllDates();
//      System.out.println("-Xms64m -Xmx256m jdbc_prog -classpath %classpath ${packageClassName}");
      
   }
   
   public static void populateGraph(){
      userBean.create("yuhan","yuhan_pw");
      userBean.create("yuki","yuki_pw");
      userBean.create("xiaozaozi", "xiaozaozi_pw");
      
//      DateInfo dateInfo1 = dateInfoBean.create("yuhan");
//      DateInfo dateInfo2 = dateInfoBean.create("yuki");
//      DateInfo dateInfo3 = dateInfoBean.create("xiaozaozi");
      
//      Dates dates = datesBean.create(dateInfo1.getId(), "yuki");
   }
   
   
   
   public static void testAllUser(){
      Iterator<User> users = userBean.findAll();
      
      System.out.println("User Node Count: " + userBean.getCount());
      while(users.hasNext()){
         User u = users.next();
         System.out.println("User Account: " + u.getAccount() + "\tID: " + u.getId() + "\t" + userBean.getUserInfoByAccount(u.getAccount()));   
      }
      System.out.println();
   }
   
   
   public static void testAllDateInfo(){
      Iterator<DateInfo> dateInfos = dateInfoBean.findAll();
      
      while(dateInfos.hasNext()){
         DateInfo d = dateInfos.next();
         System.out.println("Dating id: " + d.getId() + " Host: " + d.getHostAccount());
      }
      System.out.println();
   }
   
   public static void testAllDates(){
      Iterator<Dates> dates = datesBean.findAll();
      
      while(dates.hasNext()){
         Dates d = dates.next();
         System.out.println("id:\t" + d.getId() + "\tHost:\t" + d.getHost().getAccount() + "\tGuest:\t" + d.getGuest().getAccount());
      }
      System.out.println();
   }
   
   
   
   
   
   
//   static private String retrieveDateInfo(){
////      String account = request.getParameter("account");
//      DateInfo dateInfo = dateInfoBean.getOne();
//      String ret = "host=" + dateInfo.getHostAccount() + "&guest=" + dateInfo.getGuestAccount();
//      
//      return dateInfo.getId().toString();
//   }
   

   static private String acceptDate(Long dateInfoId, String guestAccount){

      Dates dates = datesBean.create(dateInfoId, guestAccount);
      
      return dates.getId().toString();
   }
   
   
//   static private String startDate(String hostAccount){
//      DateInfo dateInfo = dateInfoBean.create(hostAccount);
//      
//      return dateInfo.getId().toString();
//   }
   
}



//      InternalAbstractGraphDatabase graphdb = (InternalAbstractGraphDatabase)db;
//      WrappingNeoServerBootstrapper srv;
//      srv = new WrappingNeoServerBootstrapper(graphdb);
//      srv.start();