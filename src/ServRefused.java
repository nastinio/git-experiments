import java.util.Date;
import java.util.Map;

public class ServRefused {
    private String servIdName = "servId";
    private String reasonIdName = "reasonId";
    private String refuseDateName = "refuseDate";

    private Integer servId;
    private Integer refuseReasonId;
    private Date refuseDate;

  public ServRefused(Integer servId, Integer refuseReasonId, Date refuseDate) {
    this.servId = servId;
    this.refuseReasonId = refuseReasonId;
    this.refuseDate = refuseDate;
  }

  public Integer getServId() {
    return servId;
  }

  public Integer getRefuseReasonId() {
    return refuseReasonId;
  }

  public Date getRefuseDate() {
    return refuseDate;
  }
}
