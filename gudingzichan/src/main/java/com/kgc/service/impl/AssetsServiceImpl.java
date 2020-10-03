package com.kgc.service.impl;

import com.kgc.mapper.AssetsMapper;
import com.kgc.pojo.Assets;
import com.kgc.pojo.AssetsExample;
import com.kgc.service.AssetsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("assetsService")
public class AssetsServiceImpl implements AssetsService {
    @Resource
    AssetsMapper assetsMapper;
    @Override
    public List<Assets> getlist(String aid, String atype) {
        AssetsExample example=new AssetsExample();
        AssetsExample.Criteria criteria=example.createCriteria();
        if(aid!=null&&atype!=null){
            criteria.andAidEqualTo(aid);
            criteria.andAtypeEqualTo(atype);
        }
        List<Assets> list=assetsMapper.selectByExample(example);

        return list;
    }

    @Override
    public int add(Assets assets) {
        int i=assetsMapper.insertSelective(assets);
        return i;
    }
}
