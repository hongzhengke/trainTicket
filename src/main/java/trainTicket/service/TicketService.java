package trainTicket.service;

import java.util.List;

import trainTicket.po.TicketCustom;
import trainTicket.po.TicketInfo;
import trainTicket.po.TrainInfo;

public interface TicketService {
	/**
	 * 根据出发地、目的地、出发日、发车时间（该发车时间-24:00），返回包括出发地、目的地、发车时间（时分秒）、时长、余票信息
	 */
	public List<TicketCustom> queryTicket(TicketCustom ticketCustom);
	/**
	 * 定时刷新所有车票信息
	 */
	public void autoInsertTicketForAllTrain();
	/**
	 * 根据trainInfo刷新对应的车票信息
	 * @param trainInfo
	 * @return
	 */
	public boolean insertTicketForTrain(TrainInfo trainInfo);
	/**
	 * 根据trainInfoId删除所对应的车票信息
	 * @param trainInfoId
	 * @return
	 */
	public boolean deleteTicketForTrain(Integer trainInfoId);
}
