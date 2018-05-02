package trainTicket.po;


public class OrderCustom {
	private OrderInfo orderInfo;
	private TicketInfo ticketInfo;
	private TrainInfo trainInfo;


	public OrderInfo getOrderInfo() {
		return orderInfo;
	}
	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}
	public TicketInfo getTicketInfo() {
		return ticketInfo;
	}
	public void setTicketInfo(TicketInfo ticketInfo) {
		this.ticketInfo = ticketInfo;
	}
	public TrainInfo getTrainInfo() {
		return trainInfo;
	}
	public void setTrainInfo(TrainInfo trainInfo) {
		this.trainInfo = trainInfo;
	}
	@Override
	public String toString() {
		return "OrderCustom [orderInfo=" + orderInfo + ", ticketInfo=" + ticketInfo + ", trainInfo=" + trainInfo + "]";
	}
	
}
