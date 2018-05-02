package trainTicket.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import trainTicket.mapper.CarrageInfoMapper;
import trainTicket.mapper.OrderCustomMapper;
import trainTicket.mapper.OrderInfoMapper;
import trainTicket.mapper.SeatInfoCustomMapper;
import trainTicket.mapper.SeatInfoMapper;
import trainTicket.mapper.TicketInfoMapper;
import trainTicket.po.CarrageInfo;
import trainTicket.po.CarrageInfoExample;
import trainTicket.po.OrderCustom;
import trainTicket.po.OrderInfo;
import trainTicket.po.SeatInfo;
import trainTicket.po.SeatInfoExample;
import trainTicket.po.TicketCustom;
import trainTicket.po.TicketInfo;
import trainTicket.po.TrainInfo;
import trainTicket.po.User;
import trainTicket.po.UserCustom;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private CarrageInfoMapper carrageInfoMapper; 
	@Autowired 
	private TicketInfoMapper ticketInfoMapper;
	@Autowired
	private OrderInfoMapper orderInfoMapper;
	@Autowired
	private OrderCustomMapper orderCustomMapper;
	@Autowired
	private SeatInfoMapper seatInfoMapper;
	@Autowired
	private SeatInfoCustomMapper seatInfoCustomMapper;

	public SeatInfoCustomMapper getSeatInfoCustomMapper() {
		return seatInfoCustomMapper;
	}

	public void setSeatInfoCustomMapper(SeatInfoCustomMapper seatInfoCustomMapper) {
		this.seatInfoCustomMapper = seatInfoCustomMapper;
	}

	public SeatInfoMapper getSeatInfoMapper() {
		return seatInfoMapper;
	}

	public void setSeatInfoMapper(SeatInfoMapper seatInfoMapper) {
		this.seatInfoMapper = seatInfoMapper;
	}

	public OrderCustomMapper getOrderCustomMapper() {
		return orderCustomMapper;
	}

	public void setOrderCustomMapper(OrderCustomMapper orderCustomMapper) {
		this.orderCustomMapper = orderCustomMapper;
	}

	public OrderInfoMapper getOrderInfoMapper() {
		return orderInfoMapper;
	}

	public void setOrderInfoMapper(OrderInfoMapper orderInfoMapper) {
		this.orderInfoMapper = orderInfoMapper;
	}

	public TicketInfoMapper getTicketInfoMapper() {
		return ticketInfoMapper;
	}

	public void setTicketInfoMapper(TicketInfoMapper ticketInfoMapper) {
		this.ticketInfoMapper = ticketInfoMapper;
	}

	public CarrageInfoMapper getCarrageInfoMapper() {
		return carrageInfoMapper;
	}

	public void setCarrageInfoMapper(CarrageInfoMapper carrageInfoMapper) {
		this.carrageInfoMapper = carrageInfoMapper;
	}

	@Transactional
	public OrderInfo buyTicket(Integer userId, TicketCustom ticketCustom) {
		TicketInfo ticketInfo = ticketCustom.getTicketInfo();
		OrderInfo orderInfo = null;
		//找出所有对应的座位信息
		SeatInfo seatInfo = seatInfoCustomMapper.selectOneSeatByTicketId(ticketInfo.getId());
		if(seatInfo != null) {
			orderInfo = new OrderInfo();
			orderInfo.setSeatNumber(seatInfo.getSeatNumber());
			orderInfo.setCarriageNumber(seatInfo.getCarriageNumber());
			orderInfo.setOrderTime(new Date());
			orderInfo.setUserId(userId);
			orderInfo.setTicketInfoId(ticketInfo.getId());
			//修改数据库
			seatInfoMapper.deleteByPrimaryKey(seatInfo.getId());
			
			ticketInfo.setTicketAmount(ticketInfo.getTicketAmount() - 1);
			ticketInfoMapper.updateByPrimaryKey(ticketInfo);
			
			orderInfoMapper.insert(orderInfo);
		}
		return orderInfo;
	}
	
	@Transactional(readOnly=true)
	public List<OrderCustom> selectCurrentOrderByUserId(Integer userId) {
		UserCustom userCustom = new UserCustom();
		userCustom.setUserId(userId);
		Date currentDate = new Date();
		userCustom.setCurrentDate(currentDate);
		userCustom.setCurrentTime(currentDate);
		return orderCustomMapper.selectOrderByUserIdAndTime(userCustom);
	}

	@Transactional
	public boolean refundTicket(OrderCustom orderCustom) {
		OrderInfo orderInfo = orderCustom.getOrderInfo();
		TicketInfo ticketInfo = orderCustom.getTicketInfo();
		//找出所有对应的车厢信息
		SeatInfo seatInfo = new SeatInfo();
		seatInfo.setCarriageNumber(orderInfo.getCarriageNumber());
		seatInfo.setSeatNumber(orderInfo.getSeatNumber());
		seatInfo.setTicketInfoId(ticketInfo.getId());
		
		//更新数据库
		seatInfoMapper.insert(seatInfo);
		
		ticketInfo.setTicketAmount(ticketInfo.getTicketAmount() + 1);
		ticketInfoMapper.updateByPrimaryKey(ticketInfo);
		
		orderInfoMapper.deleteByPrimaryKey(orderInfo.getId());
		return true;
	}

}
