package cn.study.microcloud.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.study.microcloud.dao.IDeptDAO;
import cn.study.microcloud.service.IDeptService;
import cn.study.vo.Dept;
@Service
public class DeptServiceImpl implements IDeptService {
    @Resource
    private IDeptDAO deptDAO ;
    @Override
    public Dept get(long id) {
        return this.deptDAO.findById(id);
    }

    @Override
    public boolean add(Dept dept) {
        return this.deptDAO.doCreate(dept);
    }

    @Override
    public List<Dept> list() {
        return this.deptDAO.findAll();
    }

}