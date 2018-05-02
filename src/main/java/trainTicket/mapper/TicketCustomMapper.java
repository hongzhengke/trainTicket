package trainTicket.mapper;

import java.util.List;

import trainTicket.po.TicketCustom;
import trainTicket.po.TicketInfo;
import trainTicket.po.TrainInfo;

public interface TicketCustomMapper {
	public List<TicketCustom> selectTicket(TicketCustom ticketCustom);
	public void insertBatchTicketInfo(List<TicketInfo>ticketInfos);
}
