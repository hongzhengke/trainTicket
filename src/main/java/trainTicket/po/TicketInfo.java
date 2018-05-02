package trainTicket.po;

import java.util.Date;

public class TicketInfo {
    private Integer id;

    private Integer trainInfoId;

    private Date departureDate;

    private Integer ticketAmount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTrainInfoId() {
        return trainInfoId;
    }

    public void setTrainInfoId(Integer trainInfoId) {
        this.trainInfoId = trainInfoId;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Integer getTicketAmount() {
        return ticketAmount;
    }

    public void setTicketAmount(Integer ticketAmount) {
        this.ticketAmount = ticketAmount;
    }
}