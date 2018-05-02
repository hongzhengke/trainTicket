package trainTicket.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import trainTicket.po.TicketInfo;
import trainTicket.po.TicketInfoExample;

public interface TicketInfoMapper {
    long countByExample(TicketInfoExample example);

    int deleteByExample(TicketInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TicketInfo record);

    int insertSelective(TicketInfo record);

    List<TicketInfo> selectByExample(TicketInfoExample example);

    TicketInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TicketInfo record, @Param("example") TicketInfoExample example);

    int updateByExample(@Param("record") TicketInfo record, @Param("example") TicketInfoExample example);

    int updateByPrimaryKeySelective(TicketInfo record);

    int updateByPrimaryKey(TicketInfo record);
}