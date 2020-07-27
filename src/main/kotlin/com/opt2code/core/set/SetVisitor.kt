/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.set

import com.opt2code.core.obj.ObjectV

interface SetVisitor {
    fun <S: ObjectV> visit(vDate: SetV<S>)
}