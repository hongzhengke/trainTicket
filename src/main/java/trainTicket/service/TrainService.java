package trainTicket.service;

import java.util.List;

import trainTicket.po.TrainInfo;

public interface TrainService {
	/**
	 * 新增车次
	 * @param trainInfo
	 * @return
	 */
	public boolean addTrainInfo(TrainInfo trainInfo);
	/**
	 * 更新车次
	 * @param trainInfo
	 * @return
	 */
	public boolean updateTrainInfo(TrainInfo trainInfo);
	/**
	 * 删除车次
	 * @param trainInfoId
	 * @return
	 */
	public boolean deleteTrainInfo(Integer trainInfoId);
	/**
	 * 查询所有的车次信息
	 * @return
	 */
	public List<TrainInfo> queryForAllTrain();
}
