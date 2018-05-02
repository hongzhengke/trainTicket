package trainTicket.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import trainTicket.mapper.CarrageInfoCustomMapper;
import trainTicket.mapper.CarrageInfoMapper;
import trainTicket.mapper.OrderInfoMapper;
import trainTicket.mapper.SeatInfoCustomMapper;
import trainTicket.mapper.SeatInfoMapper;
import trainTicket.mapper.TicketCustomMapper;
import trainTicket.mapper.TicketInfoMapper;
import trainTicket.mapper.TrainInfoMapper;
import trainTicket.po.CarrageInfo;
import trainTicket.po.CarrageInfoExample;
import trainTicket.po.OrderInfoExample;
import trainTicket.po.SeatInfo;
import trainTicket.po.SeatInfoExample;
import trainTicket.po.TicketCustom;
import trainTicket.po.TicketInfo;
import trainTicket.po.TicketInfoExample;
import trainTicket.po.TrainInfo;
import trainTicket.po.TrainInfoExample;

@Service
public class TicketServiceImpl implements TicketService {
	private final int PRE_SALE_PERIOD = 10;
	@Autowired
	private TicketCustomMapper ticketCustomMapper;
	@Autowired
	private TrainInfoMapper trainInfoMapper;
	@Autowired
	private TicketInfoMapper ticketInfoMapper;
	@Autowired
	private CarrageInfoMapper carrageInfoMapper;
	@Autowired
	private CarrageInfoCustomMapper carrageInfoCustomMapper;
	@Autowired 
	private SeatInfoCustomMapper seatInfoCustomMapper;
	@Autowired
	private SeatInfoMapper seatInfoMapper;
	@Autowired
	private OrderInfoMapper orderInfoMapper;


	public OrderInfoMapper getOrderInfoMapper() {
		return orderInfoMapper;
	}


	public void setOrderInfoMapper(OrderInfoMapper orderInfoMapper) {
		this.orderInfoMapper = orderInfoMapper;
	}


	public SeatInfoMapper getSeatInfoMapper() {
		return seatInfoMapper;
	}


	public void setSeatInfoMapper(SeatInfoMapper seatInfoMapper) {
		this.seatInfoMapper = seatInfoMapper;
	}


	public SeatInfoCustomMapper getSeatInfoCustomMapper() {
		return seatInfoCustomMapper;
	}


	public void setSeatInfoCustomMapper(SeatInfoCustomMapper seatInfoCustomMapper) {
		this.seatInfoCustomMapper = seatInfoCustomMapper;
	}


	public CarrageInfoCustomMapper getCarrageInfoCustomMapper() {
		return carrageInfoCustomMapper;
	}


	public void setCarrageInfoCustomMapper(CarrageInfoCustomMapper carrageInfoCustomMapper) {
		this.carrageInfoCustomMapper = carrageInfoCustomMapper;
	}


	public TrainInfoMapper getTrainInfoMapper() {
		return trainInfoMapper;
	}


	public void setTrainInfoMapper(TrainInfoMapper trainInfoMapper) {
		this.trainInfoMapper = trainInfoMapper;
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


	public TicketCustomMapper getTicketCustomMapper() {
		return ticketCustomMapper;
	}


	public void setTicketCustomMapper(TicketCustomMapper ticketCustomMapper) {
		this.ticketCustomMapper = ticketCustomMapper;
	}

	public List<TicketCustom> queryTicket(TicketCustom ticketCustom) {
		return ticketCustomMapper.selectTicket(ticketCustom);
	}

	@Scheduled(cron="* 0/30 * * * * ")
	public void autoInsertTicketForAllTrain() {
		List<TrainInfo> trainInfos = trainInfoMapper.selectByExample(new TrainInfoExample());
		for(TrainInfo trainInfo:trainInfos) {
			insertTicketForTrain(trainInfo);
		}
		return;
	}


	@Transactional
	public boolean insertTicketForTrain(TrainInfo trainInfo) {
		Date date = new Date();
		List<TicketInfo>ticketInfos = new ArrayList<TicketInfo>();
		List<SeatInfo>seatInfos = new ArrayList<SeatInfo>();
		
		for(int i = 0;i < PRE_SALE_PERIOD;i++,date = DateUtils.addDays(date, 1)) {
			/*判断数据库中是否已经有该车票信息-----------*/
			TicketInfoExample ticketInfoExample = new TicketInfoExample();
			TicketInfoExample.Criteria criteria = ticketInfoExample.createCriteria();
			criteria.andTrainInfoIdEqualTo(trainInfo.getId());
			criteria.andDepartureDateEqualTo(date);
			if(ticketInfoMapper.countByExample(ticketInfoExample) > 0)
				continue;
			/*------------------------------------------*/
			TicketInfo ticketInfo = new TicketInfo();
			ticketInfo.setTrainInfoId(trainInfo.getId());
			ticketInfo.setTicketAmount(trainInfo.getCarriageAmount()*trainInfo.getSeatAmount());
			ticketInfo.setDepartureDate(date);
			ticketInfos.add(ticketInfo);
		}
		if(ticketInfos.size() > 0) {
			ticketCustomMapper.insertBatchTicketInfo(ticketInfos);
		}
		for(TicketInfo ticketInfo:ticketInfos) {
			for(int j = 0;j < trainInfo.getCarriageAmount();j++) {
				SeatInfo seatInfoBase = new SeatInfo();
				seatInfoBase.setTicketInfoId(ticketInfo.getId());
				seatInfoBase.setCarriageNumber(j + 1);
				for(int k = 0;k < trainInfo.getSeatAmount();k++) {
					SeatInfo seatInfo = new SeatInfo();
					BeanUtils.copyProperties(seatInfoBase, seatInfo);
					seatInfo.setSeatNumber(k + 1);
					seatInfos.add(seatInfo);
				}
			}
		}
		if(seatInfos.size() > 0)
			seatInfoCustomMapper.insertBatch(seatInfos);
		return true;
	}

	@Transactional
	public boolean deleteTicketForTrain(Integer trainInfoId) {
		TicketInfoExample ticketInfoExample = new TicketInfoExample();
		TicketInfoExample.Criteria ticketCriteria = ticketInfoExample.createCriteria();
		ticketCriteria.andTrainInfoIdEqualTo(trainInfoId);
		List<TicketInfo>ticketInfos = ticketInfoMapper.selectByExample(ticketInfoExample);
		for(TicketInfo ticketInfo:ticketInfos) {
			OrderInfoExample orderInfoExample = new OrderInfoExample();
			OrderInfoExample.Criteria orderInfoCriteria = orderInfoExample.createCriteria();
			orderInfoCriteria.andTicketInfoIdEqualTo(ticketInfo.getId());
			orderInfoMapper.deleteByExample(orderInfoExample);
			
			SeatInfoExample seatInfoExample = new SeatInfoExample();
			SeatInfoExample.Criteria seatInfoCriteria = seatInfoExample.createCriteria();
			seatInfoCriteria.andTicketInfoIdEqualTo(ticketInfo.getId());
			seatInfoMapper.deleteByExample(seatInfoExample);
		}
		ticketInfoMapper.deleteByExample(ticketInfoExample);
		return true;
	}

}
