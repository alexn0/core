/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.function.supplier

import com.opt2code.core.obj.ObjectV

interface SupplierVisitor {
    fun <T: ObjectV> visit(vFunction: SupplierV<T>)
}