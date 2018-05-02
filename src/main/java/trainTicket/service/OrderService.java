package trainTicket.service;

import java.util.Date;
import java.util.List;

import trainTicket.po.OrderCustom;
import trainTicket.po.OrderInfo;
import trainTicket.po.TicketCustom;
import trainTicket.po.User;

public interface OrderService {
	/**
	 * 根据查询结构进行购票
	 * @param user
	 * @param ticketCustom
	 * @return
	 */
	public OrderInfo buyTicket(User user,TicketCustom ticketCustom);
	/**
	 * 详细列出当前用户已购买且未到发车时间的车票；
	 * @param user
	 * @return
	 */
	public List<OrderCustom> selectCurrentOrderByUserId(Integer userId);
	/**
	 * 根据查询结果进行退票,此处有bug...
	 * @param orderCustom
	 * @return
	 */
	public boolean refundTicket(OrderCustom orderCustom);
}
