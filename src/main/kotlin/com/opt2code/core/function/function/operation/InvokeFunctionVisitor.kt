/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.function.operation

import com.opt2code.core.obj.ObjectV

interface InvokeFunctionVisitor {
    fun <S: ObjectV, T: ObjectV> visit(vDate: InvokeFunctionV<S, T>)
}

