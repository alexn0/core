/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.list

import com.opt2code.core.obj.ObjectV

interface RemoveLastListVisitor {
    fun <S: ObjectV> visit(vDate: RemoveLastListV<S>)
}