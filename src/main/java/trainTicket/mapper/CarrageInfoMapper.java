package trainTicket.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import trainTicket.po.CarrageInfo;
import trainTicket.po.CarrageInfoExample;

public interface CarrageInfoMapper {
    long countByExample(CarrageInfoExample example);

    int deleteByExample(CarrageInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CarrageInfo record);

    int insertSelective(CarrageInfo record);

    List<CarrageInfo> selectByExample(CarrageInfoExample example);

    CarrageInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CarrageInfo record, @Param("example") CarrageInfoExample example);

    int updateByExample(@Param("record") CarrageInfo record, @Param("example") CarrageInfoExample example);

    int updateByPrimaryKeySelective(CarrageInfo record);

    int updateByPrimaryKey(CarrageInfo record);
}