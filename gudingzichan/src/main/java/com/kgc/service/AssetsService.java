package com.kgc.service;

import com.kgc.pojo.Assets;

import java.util.List;

public interface AssetsService {
    //查询表&指定查询
    List<Assets> getlist(String aid, String atype);
    //添加
    int add(Assets assets);
}
