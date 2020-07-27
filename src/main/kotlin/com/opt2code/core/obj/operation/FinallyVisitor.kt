/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj.operation

import com.opt2code.core.obj.ObjectV

interface FinallyVisitor {
    fun <T: ObjectV> visit(vDate: FinallyV<T>)
}