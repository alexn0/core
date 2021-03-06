/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.arg

import com.opt2code.core.obj.ObjectV

interface AsFunctionVisitor {
    fun <S: ObjectV> visit(vDate: AsFunctionV<S>)
}