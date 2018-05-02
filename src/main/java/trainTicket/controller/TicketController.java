package trainTicket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import trainTicket.po.TicketCustom;
import trainTicket.service.TicketService;

@Controller
public class TicketController {
	@Autowired
	private TicketService ticketService;

	public TicketService getTicketService() {
		return ticketService;
	}

	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	@RequestMapping("queryTicket.action")
	public @ResponseBody ResponseEntity queryTicket(TicketCustom ticketCustom) {
		List<TicketCustom>ticketCustoms = ticketService.queryTicket(ticketCustom);
		ResponseEntity responseEntity = new ResponseEntity();
		responseEntity.setMessage("SUCCESS");
		responseEntity.setData(ticketCustoms);
		return responseEntity;
	}
	
}
