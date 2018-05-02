package trainTicket.po;

import java.util.Date;

public class OrderInfo {
    private Integer id;

    private Date orderTime;

    private Integer ticketInfoId;

    private Integer carriageNumber;

    private Integer seatNumber;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getTicketInfoId() {
        return ticketInfoId;
    }

    public void setTicketInfoId(Integer ticketInfoId) {
        this.ticketInfoId = ticketInfoId;
    }

    public Integer getCarriageNumber() {
        return carriageNumber;
    }

    public void setCarriageNumber(Integer carriageNumber) {
        this.carriageNumber = carriageNumber;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}