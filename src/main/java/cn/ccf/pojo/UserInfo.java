package cn.ccf.pojo;

import javafx.scene.chart.ValueAxis;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import java.math.BigDecimal;

/**
 * @author charles
 */
public class UserInfo {
    private BigDecimal id;

    @NotBlank(message = "真实姓名不能为空")
    private String name;

    private String orgId;

    private String orgName;

    private String depId;

    private String depName;

    private String workId;

    @NotBlank(message = "卡号不能为空")
    private String echoWorkId;

    @NotBlank(message = "用户名不能为空")
    private String username;

    @Length(min = 3, max = 18, message = "密码长度在3字符到18字符之间")
    private String password;

    private String role;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId == null ? null : depId.trim();
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName == null ? null : depName.trim();
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId == null ? null : workId.trim();
    }

    public String getEchoWorkId() {
        return echoWorkId;
    }

    public void setEchoWorkId(String echoWorkId) {
        this.echoWorkId = echoWorkId == null ? null : echoWorkId.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }
}