package cn.study.microcloud.rest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import cn.study.microcloud.service.IDeptService;
import cn.study.vo.Dept;

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
    public Object get(@PathVariable("id") long id) {
        return this.deptService.get(id) ;
    }
    @RequestMapping(value="/dept/add",method=RequestMethod.GET)
    public Object add(@RequestBody Dept dept) {
        return this.deptService.add(dept) ;
    }
    @RequestMapping(value="/dept/list",method=RequestMethod.GET)
    public Object list() {
        return this.deptService.list() ;
    }
}