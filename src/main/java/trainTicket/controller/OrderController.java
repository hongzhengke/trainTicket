package trainTicket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import trainTicket.po.OrderCustom;
import trainTicket.po.OrderInfo;
import trainTicket.po.TicketCustom;
import trainTicket.po.User;
import trainTicket.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	
	public OrderService getOrderService() {
		return orderService;
	}


	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@RequestMapping("/buyTicket.action")
	public @ResponseBody ResponseEntity buyTicket(User user,TicketCustom ticketCustom) {
		OrderInfo orderInfo = orderService.buyTicket(user, ticketCustom);
		ResponseEntity responseEntity = new ResponseEntity(orderInfo != null ? "SUCCESS":"FAIL",orderInfo);
		return responseEntity;
	}
	
	@RequestMapping("queryCurrentOrder.action")
	public @ResponseBody ResponseEntity queryCurrentOrderByUserId(Integer userId) {
		return new ResponseEntity("SUCCESS",orderService.selectCurrentOrderByUserId(userId));
	}
	
	@RequestMapping("refundTicket.action")
	public @ResponseBody ResponseEntity refundTicket(OrderCustom orderCustom) {
		boolean flag = orderService.refundTicket(orderCustom);
		return new ResponseEntity(flag == true ? "SUCCESS":"FAIL", null);
	}
}
