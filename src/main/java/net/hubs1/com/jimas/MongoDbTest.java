/** 
 * MongoDbTest.java 
 * 版权所有(C) 2012  
 * 创建:cuiran 2012-12-05 13:47:22 
 */  
package net.hubs1.com.jimas;  
  
import java.util.Random;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
  
/** 
 * TODO 
 * @author cuiran 
 * @version TODO 
 */  
public class MongoDbTest {  
  
     private Mongo mg = null;     
     private DB db;     
     private DBCollection users;  
       
     /** 
      * 初始化 
      * TODO 
      */  
     public void init(){  
             try {  
//              mg=new Mongo();  
                 mg=new Mongo("127.0.0.1",27017);  
            } catch (MongoException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
            //获取temp DB 如果默认没有 会自动创建  
            db=mg.getDB("temp");  
            //获取users Collection 如果默认没有 会自动创建  
            users=db.getCollection("users");  
              
              
              
     }  
       
     /** 
      * 销毁 
      * TODO 
      */  
     public void destory(){  
         if(mg!=null){  
             mg.close();  
         }  
         mg=null;  
         db=null;  
         users=null;  
         System.gc();  
           
     }  
     /** 
      * <b>function:</b> 查询所有数据 
      * @author cuiran 
      * @createDate 2012-12-11 09:24:11 
      */  
     public void queryAll(){  
         print("查询users的所有数据");  
         //Db游标  
         DBCursor cur=users.find();  
         while(cur.hasNext()){  
             print(cur.next());  
         }  
     }  
       
     /** 
      *  
      *<b>function:</b>添加数据 
      * @author cuiran 
      * @createDate 2012-12-11 09:25:23 
      */  
     public void add(){  
         queryAll();  
           
         print("count:"+users.count());  
         DBObject user=new BasicDBObject();  
         user.put("name", "cuiran1"+new Random().nextInt(100));  
         user.put("age", 27);  
           
         users.save(user);  
//       print(users.save(user).getN());  
         queryAll();  
         user.put("sex", "男");  
         print(users.save(user));  
//         print(users.save(user).getN());  
           
           
         print("count:"+users.count());  
         queryAll();  
           
     }  
     /** 
      *  
      *<b>function:</b>删除数据 
      * @author cuiran 
      * @createDate 2012-12-11 09:38:12 
      */  
     public void remove(){  
         queryAll();  
         print("删除id = 57902fb972d0fdb6c4caf610：" + users.remove(new BasicDBObject("_id", new ObjectId("57902fb972d0fdb6c4caf610"))));  
         queryAll();  
     }  
       
     public void print(Object o){  
         System.out.println(o);  
     }  
       
       
     public void start(){  
         init();  
         add();  
       remove();  
       queryAll();  
       destory();  
           
           
     }  
       
    /** 
     * TODO 
     * @param args 
     */  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        MongoDbTest t=new MongoDbTest();  
        t.start();  
    }  
  
}  