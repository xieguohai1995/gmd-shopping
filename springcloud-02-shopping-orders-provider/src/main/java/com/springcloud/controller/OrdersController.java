package com.springcloud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.springcloud.common.PageUtils;
import com.springcloud.entity.Orders;
import com.springcloud.service.OrdersService;
import com.springcloud.vo.ResultValue;

/**
 * 订单模块的控制层
 * @author Administrator
 *
 */
@RestController
@RequestMapping("orders")
public class OrdersController {

	@Autowired
	private OrdersService  ordersService;
	
	/**
	 * 查询满足条件的订单信息
	 * @param orders 查询条件
	 * @param pageNumber 查询页数
	 * @return
	 */
	@RequestMapping(value = "/selectOrders")
	public ResultValue selectOrders(Orders orders,@RequestParam("pageNumber") Integer pageNumber) {
		ResultValue rv = new ResultValue();
		
		try {
			//查询满足条件的订单信息
			PageInfo<Orders> pageInfo = this.ordersService.selectOders(orders, pageNumber);
			List<Orders> list = pageInfo.getList();
			if(list !=null && list.size() >0) {
				rv.setCode(0);
				Map<String,Object> map = new HashMap<>();
				//将商品信息以指定的键存入Map集合中
				map.put("ordersList", list);
				PageUtils pageUtils = new PageUtils(pageInfo.getPages() * PageUtils.PAGE_ROW_COUNT);
				pageUtils.setPageNumber(pageNumber);
				//将分页信息以指定的名字存入Map集合
				map.put("pageUtils", pageUtils);
				
				rv.setDataMap(map);
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		rv.setMessage("没有找到满足条件的订单信息！！！");
		return rv;
	}
	
	/**
	 * 修改指定编号订单的订单状态
	 * @param orders 修改的订单信息
	 * @return
	 */
	@RequestMapping(value = "/updateOrdersStatus")
	public ResultValue updateOrdersStatus(Orders orders) {
		ResultValue rv = new ResultValue();
		
		try {
			//修改订单状态信息
			Integer status = this.ordersService.updateOrdersStatus(orders);
			if(status > 0 ) {
				rv.setCode(0);
				rv.setMessage("修改订单状态成功！！！");
				return rv;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		rv.setMessage("修改订单状态失败！！！");
		return rv;
	}
	
	@RequestMapping(value = "/selectGroup")
	public ResultValue selectGroup(Orders orders) {
		ResultValue rv = new ResultValue();
		
		try {
			List<Orders> list = this.ordersService.selectGroup(orders);
			System.out.println(list);
			if(list != null && list.size() >0) {
				rv.setCode(0);
				List<String> x =new ArrayList<>();
				List<Double> y =new ArrayList<>();
				for (Orders o : list) {
					x.add(o.getOrderMonth());
					y.add(o.getOrderPrice());
				}
				Map<String,Object> map = new HashMap<>();
				map.put("x", x);
				map.put("y", y);
				rv.setDataMap(map);
				return rv;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		rv.setCode(1);
		return rv;
	}
	
}
