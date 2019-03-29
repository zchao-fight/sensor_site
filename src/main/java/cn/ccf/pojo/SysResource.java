package cn.ccf.pojo;

import lombok.Data;

@Data
public class SysResource {
    private Integer id;

    private String resName;

    private String resKey;

    private String resUrl;

    private Integer type;

    private String resIcon;

    private Integer parentId;

    private String parentName;

    private String parentIds;

    private Integer seq;

    private Boolean isEnable;

    private String description;

}