/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.env

import com.opt2code.core.cell.CellV
import com.opt2code.core.metadata.MetadataCoreInfo
import com.opt2code.core.metadata.MetadataCoreInfoImpl.Companion.metadataCoreInfo_
import com.opt2code.core.obj.ObjectV

class CoreEnvironmentImpl: CoreEnvironment {
    override fun <T: MetadataCoreInfo> metadataInfo(): T = metadataCoreInfo_() as T

    override fun <T: ObjectV> initCell(r: CellV<T>): CellV<T> = r
}