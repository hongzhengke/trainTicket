package trainTicket.test;

import org.springframework.beans.BeanUtils;

import trainTicket.po.CarrageInfo;

public class Main {

	public static void main(String[] args) {
		CarrageInfo carrageInfo = new CarrageInfo();
		carrageInfo.setTicketInfoId(666);
		carrageInfo.setCarriageNumber(1);
		
		CarrageInfo  carrageInfo2 = new CarrageInfo();
		BeanUtils.copyProperties(carrageInfo, carrageInfo2);
		System.out.println("debug");
	}

}
