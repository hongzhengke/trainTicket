package trainTicket.mapper;

import java.util.List;

import trainTicket.po.CarrageInfo;

public interface CarrageInfoCustomMapper {
	/**
	 * 批量插入
	 * @param carrageInfos
	 * @return
	 */
	public boolean insertBatch(List<CarrageInfo> carrageInfos);
}
