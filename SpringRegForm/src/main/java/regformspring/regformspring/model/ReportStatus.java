package regformspring.regformspring.model;

public enum ReportStatus {
    SENT("SENT"),
    APPROVED("APPROVED"),
    UNAPPROVED("UNAPPROVED");

    String status;

    ReportStatus(String status) {
        this.status = status;
    }
}
