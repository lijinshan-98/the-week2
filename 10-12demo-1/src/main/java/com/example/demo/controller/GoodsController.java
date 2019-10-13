package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.BoundZSetOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.bean.Goods;
import com.example.demo.service.GoodsService;
import com.example.demo.utils.PageUtils;

@Controller

public class GoodsController {
	@Autowired
	private GoodsService service;
	@Autowired
	private RedisTemplate<String, Object> redistem;
	
	@RequestMapping("list.do")
	public String findList(Model model,
			@RequestParam(defaultValue="1")long cpage,
			@RequestParam(defaultValue="")String  orders
			) {
		
		//List<Goods> list = service.getfindAll();
		
		BoundListOperations<String, Object> boundo = redistem.boundListOps("getfindAll");
		Map<String,Long> pagemap = PageUtils.pageUtils(boundo.size(), cpage);
		List<Object> list = boundo.range(pagemap.get("start"), pagemap.get("end"));
		
		if(orders.length()>0) {
			BoundZSetOperations<String,Object> boundZSetOps = redistem.boundZSetOps("sortGoods");
			for (Object object : list) {
				Goods goods = (Goods) object;
				boundZSetOps.add(goods, goods.getSaleCount()/goods.getGcount());
			}
			Set<Object> range2 = boundZSetOps.range(0, -1);
			model.addAttribute("goodsList", range2);
		}
		
		model.addAttribute("list", list);
		model.addAttribute("cpage", pagemap.get("cpage"));
		model.addAttribute("pages", pagemap.get("pages"));
		return "list";
	}
	
}
