package cn.ccf.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author charles
 */
@Data
public class Workshop {
    private String id;

    @NotBlank(message = "厂房编号不能为空")
    private String workshopNumber;

    private String name;

    private String location;

    private Date createtime;

    @NotBlank(message = "厂房IP不得为空")
    private String ip;

    @NotNull(message = "定员不能为空")
    private BigDecimal personnelQuota;

}