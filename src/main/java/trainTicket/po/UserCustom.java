package trainTicket.po;

import java.util.Date;

public class UserCustom {
	private Integer userId;
	private Date currentDate;
	private Date currentTime;
	public Date getCurrentTime() {
		return currentTime;
	}
	public void setCurrentTime(Date currentTime) {
		this.currentTime = currentTime;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
	@Override
	public String toString() {
		return "UserCustom [userId=" + userId + ", currentDate=" + currentDate + "]";
	}
	
	
}	
