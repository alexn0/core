/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.list

import com.opt2code.core.obj.ObjectV

interface FirstListVisitor {
    fun <S: ObjectV> visit(vDate: FirstListV<S>)
}