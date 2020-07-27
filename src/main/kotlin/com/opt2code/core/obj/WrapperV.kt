/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.obj

interface WrapperV: ObjectV {
    val internal: ObjectV

    val formulaType: ExtFormulaType
}