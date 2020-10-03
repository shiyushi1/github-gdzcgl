package com.kgc.controller;

import com.kgc.pojo.Assets;
import com.kgc.service.AssetsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class AssetsController {
    @Resource
    AssetsService assetsService;
    //初始页面
    @RequestMapping("/wecome")
    public String wecome(){
        return "/strat";
    }
    //查询表+指定查询
    @RequestMapping("/list")
    public String list(String aid, String atype, Model model){
        List<Assets> list=assetsService.getlist(aid,atype);
        model.addAttribute("list",list);
        return "/index";
    }
    //添加
    @RequestMapping("/toadd")
    public String add(Assets assets){
        int i=assetsService.add(assets);
        return "redirect:/list";
    }

}
