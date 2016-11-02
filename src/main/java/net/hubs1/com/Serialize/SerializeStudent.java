package net.hubs1.com.Serialize;
 
import java.io.Serializable;
 
public class SerializeStudent implements Serializable {
 

	/**
      * 序列化对象的标识，用于在反序列化的时候使用 <BR>
      * 反序列化的时候，如果当前内存中已经有这个标识的对象，则认为是同一类对象
      */
	private static final long serialVersionUID = -3210969043102487456L;
 
    /* 演示瞬时态对象不会被序列化 */
    private transient String m_nClass = null ;
 
    /* 成员属性 */
    private String m_sStudentName = null ;
 
    public static String m_sDept = null ;
 
    public void setStudentName(String studentName) {
       m_sStudentName = studentName;
    }
 
    public void setDept(String _sDept) {
       m_sDept = _sDept;
    }
 
    public void setClass(String _nAge) {
       m_nClass = _nAge;
    }
 
    @Override
    public String toString() {
       return " 学生姓名： " + m_sStudentName + ", 系 ( 静态字段 ) ： " +m_sDept + ", 班级 ( 瞬时态字段 ) ： "
              + m_nClass ;
    }
}
 