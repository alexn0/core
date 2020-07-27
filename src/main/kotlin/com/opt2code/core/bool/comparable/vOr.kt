/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.bool.comparable

import com.opt2code.core.bool.BooleanV

fun BooleanV.vOr(second: () -> BooleanV) = OrV_.orV(this, second())