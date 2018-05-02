package trainTicket.mapper;

import java.util.List;

import trainTicket.po.SeatInfo;

public interface SeatInfoCustomMapper {
	public void insertBatch(List<SeatInfo>seatInfos);
	public SeatInfo selectOneSeatByTicketId(int ticketId);
}
