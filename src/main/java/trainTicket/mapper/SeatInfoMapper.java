package trainTicket.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import trainTicket.po.SeatInfo;
import trainTicket.po.SeatInfoExample;

public interface SeatInfoMapper {
    long countByExample(SeatInfoExample example);

    int deleteByExample(SeatInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SeatInfo record);

    int insertSelective(SeatInfo record);

    List<SeatInfo> selectByExample(SeatInfoExample example);

    SeatInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SeatInfo record, @Param("example") SeatInfoExample example);

    int updateByExample(@Param("record") SeatInfo record, @Param("example") SeatInfoExample example);

    int updateByPrimaryKeySelective(SeatInfo record);

    int updateByPrimaryKey(SeatInfo record);
}