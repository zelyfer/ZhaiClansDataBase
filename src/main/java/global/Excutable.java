package global;


import com.neo4j.demo.bean.DateInfoBean;
import com.neo4j.demo.bean.DatesBean;
import com.neo4j.demo.bean.UserBean;
import com.neo4j.demo.entity.DateInfo;
import com.neo4j.demo.entity.Dates;
import com.neo4j.demo.entity.User;
import java.util.Iterator;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;


public class Excutable {
   public static ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
   
   static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("file:/Users/yorg/Developer/ZhaiClansServer/beans.xml");
   static UserBean userBean = (UserBean)context.getBean("userBean");
   static DateInfoBean dateInfoBean = (DateInfoBean)context.getBean("dateInfoBean");
   static DatesBean datesBean = (DatesBean)context.getBean("datesBean");
   
   @Transactional
   public static void main(String[] args){
      
      
//      System.out.println(retrieveDateInfo());
//      System.out.println(acceptDate(new Long(4), "yuhan"));
//      System.out.println(startDate("xiaozaozi"));
//      System.out.println();
      
      System.out.println(userBean.getUserInfoByAccount("yuhan"));
      userBean.updateUserInfo("yuhan", "nwpu");
      userBean.updateUserHobby("yuki", "TV");
      
      testAllUser();
      testAllDateInfo();
      testAllDates();
      
   }
   
   public static void populateGraph(){
      User yuhan = userBean.create("yuhan","yuhan_pw");
      User yuki = userBean.create("yuki","yuki_pw");
      User zaozi = userBean.create("xiaozaozi", "xiaozaozi_pw");
      
      DateInfo dateInfo1 = dateInfoBean.create(yuhan.getAccount());
      DateInfo dateInfo2 = dateInfoBean.create(yuki.getAccount());
      DateInfo dateInfo3 = dateInfoBean.create(zaozi.getAccount());
      
      Dates dates = datesBean.create(yuhan,yuki,dateInfo1);
   }
   
   
   
   public static void testAllUser(){
      Iterator<User> users = userBean.findAll();
      
      System.out.println("User Node Count: " + userBean.getCount());
      while(users.hasNext()){
         User u = users.next();
         System.out.println("User Account: " + u.getAccount() + "\tID: " + u.getId() + " " + "School: " + u.getSchool() + "\tHobby: " + u.getHobby());         
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
   
   
   
   
   
   
   static private String retrieveDateInfo(){
//      String account = request.getParameter("account");
      DateInfo dateInfo = dateInfoBean.getOne();
      String ret = "host=" + dateInfo.getHostAccount() + "&guest=" + dateInfo.getGuestAccount();
      
      return dateInfo.getId().toString();
   }
   

   static private String acceptDate(Long dateInfoId, String guestAccount){

      Dates dates = datesBean.create(dateInfoId, guestAccount);
      
      return dates.getId().toString();
   }
   
   
   static private String startDate(String hostAccount){
      DateInfo dateInfo = dateInfoBean.create(hostAccount);
      
      return dateInfo.getId().toString();
   }
   
}



//      InternalAbstractGraphDatabase graphdb = (InternalAbstractGraphDatabase)db;
//      WrappingNeoServerBootstrapper srv;
//      srv = new WrappingNeoServerBootstrapper(graphdb);
//      srv.start();