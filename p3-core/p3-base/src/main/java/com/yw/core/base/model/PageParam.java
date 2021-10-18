package com.yw.core.base.model;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;

/**
 * @author Administrator
 */


@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class PageParam implements Serializable {


    private static final long serialVersionUID = 3609578468270245724L;
    /**
     * 当前页
     */
    @Range(min = 1, max = Integer.MAX_VALUE,message = "分页参数错误")
    private int pageNum = 1;
    /**
     * 每页的数量
     */
    @Range(min = 1, max = 500,message = "分页参数错误")
    private int pageSize = 10;
    /**
     * 是否统计
     */
    private Boolean count = true;
}
