/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.cell

import com.opt2code.core.obj.ObjectV

interface GetterVisitor {
    fun <T: ObjectV> visit(vDate: GetterV<T>)
}