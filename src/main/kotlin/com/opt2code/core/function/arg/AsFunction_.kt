/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.arg

class AsFunction_<T> private constructor(
        override val argInfo: ArgInfo,
        override val func: (List<WrapperArgValue>) -> T
): AsFunction<T> {

    companion object {
        fun <T> asFunction(func: (List<WrapperArgValue>) -> T, args: List<WrapperArgValue>, sizes: List<Int>, size: Int): AsFunction<T> = AsFunction_(ArgInfo(sizes, args, size), func)
    }
}

