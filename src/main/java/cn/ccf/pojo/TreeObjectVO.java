package cn.ccf.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 列表树形式显示的实体
 * 这里的字段是前台显示的所有的，可修改
 */
@Data
public class TreeObjectVO {

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

    private List<TreeObjectVO> children = new ArrayList<>();
}
