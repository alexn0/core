/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.stack

import com.opt2code.core.obj.ObjectV

interface StackVisitor {
    fun <S: ObjectV> visit(vDate: StackV<S>)
}