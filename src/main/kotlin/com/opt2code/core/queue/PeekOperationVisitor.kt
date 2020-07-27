/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.queue

import com.opt2code.core.obj.ObjectV

interface PeekOperationVisitor {
    fun <S: ObjectV> visit(vDate: PeekOperationV<S>)
}