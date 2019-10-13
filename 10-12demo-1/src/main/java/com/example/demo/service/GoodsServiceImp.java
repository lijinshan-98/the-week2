package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Goods;
import com.example.demo.mapper.GoodsMapper;

@Service
public class GoodsServiceImp implements GoodsService{
	@Autowired
	private GoodsMapper mapper;
	@Override
	public List<Goods> getfindAll() {
		// TODO Auto-generated method stub
		return mapper.getfindAll();
	}
	
}
