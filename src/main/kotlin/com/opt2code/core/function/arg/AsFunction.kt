/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.arg

interface AsFunction<T> {
    val argInfo: ArgInfo

    val func: (List<WrapperArgValue>) -> T

    operator fun invoke(): T = argInfo.calculate(func) as T
}