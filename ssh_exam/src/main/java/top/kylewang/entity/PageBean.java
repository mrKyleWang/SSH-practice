package top.kylewang.entity;

import lombok.Data;

import java.util.List;

/**
 * @author Kyle.Wang
 * 2017/12/27 0027 20:57
 */
@Data
public class PageBean {
    private Integer totalPage;
    private List list;

}
