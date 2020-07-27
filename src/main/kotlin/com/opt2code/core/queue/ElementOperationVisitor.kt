/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.queue

import com.opt2code.core.obj.ObjectV

interface ElementOperationVisitor {
    fun <S: ObjectV> visit(vDate: ElementOperationV<S>)
}