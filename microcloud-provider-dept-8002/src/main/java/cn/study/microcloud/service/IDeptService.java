package cn.study.microcloud.service;

import java.util.List;

import cn.study.vo.Dept;

public interface IDeptService {
    public Dept get(long id) ;
    public boolean add(Dept dept) ;
    public List<Dept> list() ;
}