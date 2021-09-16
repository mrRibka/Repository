package org.example;
import java.util.Date;

public class Refueler {
    private ForRefueler forRefueler;
    private Date fromDate;
    private Date expires;

    Refueler(ForRefueler forRefueler, Date fromDate, Date expires){
        this.forRefueler = forRefueler;
        this.expires = expires;
        this.fromDate = fromDate;
    }

    public ForRefueler getForRefueler() {
        return forRefueler;
    }

    public void setForRefueler(ForRefueler forRefueler) {
        this.forRefueler = forRefueler;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }
}
