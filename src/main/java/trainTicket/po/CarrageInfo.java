package trainTicket.po;

public class CarrageInfo {
    private Integer id;

    private Integer ticketInfoId;

    private Integer carriageNumber;

    private Integer seatAmount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getSeatAmount() {
        return seatAmount;
    }

    public void setSeatAmount(Integer seatAmount) {
        this.seatAmount = seatAmount;
    }
}