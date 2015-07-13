package global;


import com.neo4j.demo.bean.DatingBean;
import com.neo4j.demo.bean.UserBean;
import com.neo4j.demo.entity.Dating;
import com.neo4j.demo.entity.User;
import java.util.Iterator;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Excutable {
   public static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
   
   public static void main(String[] args){
      ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("file:/Users/yorg/Developer/DateAppServer/DateAppServer/src/beans.xml");
      
      
      UserBean userBean = (UserBean)context.getBean("userBean");
      
      DatingBean datingBean = (DatingBean)context.getBean("datingBean");
      
//      testUserCount(userBean);
//      testAllUser(userBean);
//      
//      testDatingCount(datingBean);
//      testAllDating(datingBean);
//      
//      testFreshDate(userBean, datingBean);
      
      System.out.println(userBean.getCount());

   }
   
   public static void populateGraph(ClassPathXmlApplicationContext context){
      UserBean userBean = (UserBean)context.getBean("userBean");
      
      User freshdate = userBean.create("freshdate","freshdate_pw");
      User yuhan = userBean.create("yuhan","yuhan_pw");
      User yuki = userBean.create("yuki","yuki_pw");
      
      DatingBean datingBean = (DatingBean)context.getBean("datingBean");
      datingBean.create(yuhan,freshdate);
      datingBean.create(yuki,freshdate);
   }
   
   public static Iterator<Dating> findAllFreshDate(ClassPathXmlApplicationContext context){
      UserBean userBean = (UserBean)context.getBean("userBean");
      DatingBean datingBean = (DatingBean)context.getBean("datingBean");
      
      User freshdate = userBean.findByAccount("freshDate");
      Iterator<Dating> datings = datingBean.findByGuest(freshdate).iterator();
      
      return datings;
   }
   
   public static Long testUserCount(UserBean bean){
      System.out.println("User Node Count: " + bean.getCount());
      return bean.getCount();
   }
   
   public static void testAllUser(UserBean userBean){
      Iterable<User> users = userBean.getAll();
      Iterator<User> it = users.iterator();
      while(it.hasNext()){
         User u = it.next();
         System.out.println("User Account: " + u.getAccount() + "\tID: " + u.getId());
      }
      System.out.println();
   }
   
   public static Long testDatingCount(DatingBean bean){
      System.out.println("Dating Relationship Count: " + bean.getCount());
      return bean.getCount();
   }
   
   public static void testAllDating(DatingBean datingBean){
      Iterable<Dating> datings = datingBean.getAll();
      Iterator<Dating> it = datings.iterator();
      while(it.hasNext()){
         Dating d = it.next();
         System.out.println("Dating id: " + d.getId() + " Host: " + d.getHost().getAccount() + " Guest: " + d.getGuest().getAccount());
      }
      System.out.println();
   }
   
   public static void testFreshDate(UserBean userBean, DatingBean datingBean){
      User fresh = userBean.findByAccount("freshdate");
      Iterable<Dating> datings = datingBean.findByGuest(fresh);
      System.out.println("Fresh Datings are: ");
      Iterator<Dating> it = datings.iterator();
      while(it.hasNext()){
         System.out.println("Host Account: " + it.next().getHost().getAccount());
      }
      System.out.println();
   }
}



//      InternalAbstractGraphDatabase graphdb = (InternalAbstractGraphDatabase)db;
//      WrappingNeoServerBootstrapper srv;
//      srv = new WrappingNeoServerBootstrapper(graphdb);
//      srv.start();