package com.leyou.common.exception;

import com.leyou.common.enums.ExceptionEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Author: zwb
 * @Date: 2019-07-01 1:29
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LyException extends RuntimeException {

    private ExceptionEnums exceptionEnums;
}
