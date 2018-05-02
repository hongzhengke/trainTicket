package trainTicket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import trainTicket.mapper.TrainInfoMapper;
import trainTicket.po.TrainInfo;
import trainTicket.po.TrainInfoExample;

@Service
public class TrainServiceImpl implements TrainService {
	@Autowired
	private TrainInfoMapper trainInfoMapper;
	@Autowired
	private TicketService ticketService;

	public TicketService getTicketService() {
		return ticketService;
	}

	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	public TrainInfoMapper getTrainInfoMapper() {
		return trainInfoMapper;
	}

	public void setTrainInfoMapper(TrainInfoMapper trainInfoMapper) {
		this.trainInfoMapper = trainInfoMapper;
	}

	@Transactional
	public boolean addTrainInfo(TrainInfo trainInfo) {
		trainInfo.setId(null);
		trainInfoMapper.insert(trainInfo);
		ticketService.insertTicketForTrain(trainInfo);
		return true;
	}

	@Transactional
	public boolean updateTrainInfo(TrainInfo trainInfo) {
		trainInfoMapper.updateByPrimaryKey(trainInfo);
		return true;
	}

	@Transactional
	public boolean deleteTrainInfo(Integer trainInfoId) {
		ticketService.deleteTicketForTrain(trainInfoId);
		trainInfoMapper.deleteByPrimaryKey(trainInfoId);
		return true;
	}

	@Transactional(readOnly=true)
	public List<TrainInfo> queryForAllTrain() {
		TrainInfoExample trainInfoExample = new TrainInfoExample();
		return trainInfoMapper.selectByExample(trainInfoExample);
	}

}
