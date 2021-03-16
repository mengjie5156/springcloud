package cn.study.microcloud.rest;

import cn.study.microcloud.service.IDeptService;
import cn.study.vo.Dept;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class DeptRest {
    @Resource
    private IDeptService deptService ;
    @RequestMapping("/dept/sessionId")
    public Object id(HttpServletRequest request) {
        return request.getSession().getId() ;
    }

    @Resource
    private DiscoveryClient client ;    // 进行Eureka的发现服务
    @RequestMapping("/dept/discover")
    public Object discover() {    // 直接返回发现服务信息
        return this.client ;
    }

    @RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
    @HystrixCommand(fallbackMethod="getFallback")    // 如果当前调用的get()方法出现了错误，则执行fallback
    public Object get(@PathVariable("id") long id) {
        Dept vo = this.deptService.get(id) ;    // 接收数据库的查询结果
        if (vo == null) {    // 数据不存在，假设让它抛出个错误
            throw new RuntimeException("部门信息不存在！") ;
        }
        return vo ;

        //return this.deptService.get(id) ;
    }
    @RequestMapping(value="/dept/add",method=RequestMethod.GET)
    public Object add(@RequestBody Dept dept) {
        return this.deptService.add(dept) ;
    }
    @RequestMapping(value="/dept/list",method=RequestMethod.GET)
    public Object list() {
        return this.deptService.list() ;
    }

    public Object getFallback(@PathVariable("id") long id) {    // 此时方法的参数 与get()一致
        Dept vo = new Dept() ;
        vo.setDeptno(999999L);
        vo.setDname("【ERROR】Microcloud-Dept-Hystrix");    // 错误的提示
        vo.setLoc("DEPT-Provider");
        return vo ;
    }
}