package trainTicket.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import trainTicket.po.TrainInfo;
import trainTicket.po.TrainInfoExample;

public interface TrainInfoMapper {
    long countByExample(TrainInfoExample example);

    int deleteByExample(TrainInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TrainInfo record);

    int insertSelective(TrainInfo record);

    List<TrainInfo> selectByExample(TrainInfoExample example);

    TrainInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TrainInfo record, @Param("example") TrainInfoExample example);

    int updateByExample(@Param("record") TrainInfo record, @Param("example") TrainInfoExample example);

    int updateByPrimaryKeySelective(TrainInfo record);

    int updateByPrimaryKey(TrainInfo record);
}