package cn.ccf.pojo;

import lombok.Data;

/**
 * @author charles
 * @date 2019/09/03
 */
@Data
public class InAndOutHistory {
    private String id;

    private String workshopId;

    private String workId;

    private String name;

    private String entryTime;

    private String departureTime;

}