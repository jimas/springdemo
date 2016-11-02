在责任链模式里，很多对象由每一个对象对其下家的引用而连接起来形成一条链。请求在这个链上传递，

直到链上的某一个对象决定处理此请求。发出这个请求的客户端并不知道链上的哪一个对象最终处理这个请求，

这使得系统可以在不影响客户端的情况下动态地重新组织和分配责任


例如：java 中的 异常机制，能处理就自行处理，不能就往上抛出异常。
	  java web 中 Filter 与  FilterChain   chain.doFilter(request, response); 
	  
	  package test.filter;
 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
 
public class LogFilter implements Filter { 
    private FilterConfig config; 
    // 实现初始化方法 
    public void init(FilterConfig config) { 
        this.config = config; 
    } 
    // 实现销毁方法 
    public void destroy() { 
        this.config = null; 
    } 
    public void doFilter(ServletRequest request, ServletResponse response, 
            FilterChain chain) { 
        // 获取ServletContext 对象，用于记录日志 
        ServletContext context = this.config.getServletContext(); 
        long before = System.currentTimeMillis(); 
        System.out.println("开始过滤... "); 
        // 将请求转换成HttpServletRequest 请求 
        HttpServletRequest hrequest = (HttpServletRequest) request; 
        // 记录日志 
        context.log("Filter已经截获到用户的请求的地址: " + hrequest.getServletPath()); 
        try { 
            // Filter 只是链式处理，请求依然转发到目的地址。 
            chain.doFilter(request, response); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
        long after = System.currentTimeMillis(); 
        // 记录日志 
        context.log("过滤结束"); 
        // 再次记录日志 
        context.log(" 请求被定位到" + ((HttpServletRequest) request).getRequestURI() 
                + "所花的时间为: " + (after - before)); 
    } 
} 