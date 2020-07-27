/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.env

import com.opt2code.core.cell.CellV
import com.opt2code.core.metadata.MetadataCoreInfo
import com.opt2code.core.obj.ObjectV
import com.opt2code.env.Environment

interface CoreEnvironment: Environment {

    fun <T: MetadataCoreInfo> metadataInfo(): T

    fun <T: ObjectV> initCell(r: CellV<T>): CellV<T>

}