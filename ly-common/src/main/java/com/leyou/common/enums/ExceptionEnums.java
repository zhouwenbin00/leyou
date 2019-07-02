package com.leyou.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Author: zwb
 * @Date: 2019-07-01 1:30
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum  ExceptionEnums {
    PRICE_CANNOT_BE_NULL(400,"价格不能为空"),
    CATEGORY_NOT_FOUND(404,"商品分类没有找到"),
    BRAND_NOT_FOUND(404,"品牌没有找到"),
    BRAND_SAVE_ERROR(500,"新增品牌失败"),
    ;
    private int code;
    private String msg;
}
