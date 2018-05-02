package trainTicket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import trainTicket.po.TrainInfo;
import trainTicket.service.TrainService;

@Controller
public class TrainController {
	@Autowired
	private TrainService trainService;

	public TrainService getTrainService() {
		return trainService;
	}

	public void setTrainService(TrainService trainService) {
		this.trainService = trainService;
	}
	
	@RequestMapping("/addTrainInfo.action")
	public @ResponseBody ResponseEntity addTrainInfo(TrainInfo trainInfo) {
		boolean flag = trainService.addTrainInfo(trainInfo);
		return new ResponseEntity(flag == true ? "SUCCESS":"FAIL", null);
	}
	
	@RequestMapping("/updateTrainInfo.action")
	public @ResponseBody ResponseEntity updateTrainInfo(TrainInfo trainInfo) {
		boolean flag = trainService.updateTrainInfo(trainInfo);
		return new ResponseEntity(flag == true ? "SUCCESS":"FAIL", null);
	}
	
	@RequestMapping("/deleteTrainInfo.action")
	public @ResponseBody ResponseEntity deleteTrainInfo(Integer trainInfoId) {
		boolean flag = trainService.deleteTrainInfo(trainInfoId);
		return new ResponseEntity(flag == true ? "SUCCESS":"FAIL", null);
	}
	
	@RequestMapping("/queryForAllTrainInfo.action")
	public @ResponseBody ResponseEntity queryForAllTrainInfo() {
		return new ResponseEntity("SUCCESS", trainService.queryForAllTrain());
	}
}
