/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj

import com.opt2code.core.function.arg.AsArgReplacementV
import com.opt2code.core.function.arg.AsFunctionReplacementV
import com.opt2code.core.function.arg.AsFunctionV
import com.opt2code.core.function.arg.AsFunctionV_

class WrapperV_ private constructor(
        override val internal: ObjectV,
        override val formulaType: ExtFormulaType
): ObjectV by internal, WrapperV {

    override fun new_(substitute: Boolean): WrapperV = WrapperV_(internal, formulaType)

    override fun operations(): List<ObjectV> {
        return internal.operations().map { wrapperV(it, formulaType) }
    }

    override fun elements(): List<ObjectV> {
        return internal.getLazyElements().map { wrapperV(it, formulaType) }
    }

    companion object {
        fun wrapperV(internal: ObjectV, formulaType: ExtFormulaType): ObjectV =
                if (internal is WrapperV
                        || internal is AsArgReplacementV
                        || internal is AsFunctionReplacementV
                        || internal.data_.forceFormulaType != null) {
                    internal
                } else {
                    if (internal is AsFunctionV<*>) {
                        AsFunctionV_.asFunctionV(
                                wrapperV(internal.hiddenMainElement(), formulaType),
                                *(internal.hiddenElements().map { wrapperV(it, formulaType) }.toTypedArray())
                        )
                    } else {
                        WrapperV_(internal, formulaType)
                    }
                }
    }

    override fun accept(r: ObjectVisitor) {
        if (r is Visitors) {
            r.setCurrentFormulaType(formulaType)
            internal.accept(r)
            r.setCurrentFormulaType(null)
        }
    }

    override fun getInterfaceClass(): Class<*> = WrapperV::class.java
}