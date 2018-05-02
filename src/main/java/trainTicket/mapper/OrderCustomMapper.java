package trainTicket.mapper;

import java.util.List;

import trainTicket.po.OrderCustom;
import trainTicket.po.UserCustom;

public interface OrderCustomMapper {
	public List<OrderCustom> selectOrderByUserIdAndTime(UserCustom userCustom);
}
