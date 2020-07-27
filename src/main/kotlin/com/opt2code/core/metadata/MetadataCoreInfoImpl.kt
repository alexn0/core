/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.metadata

class MetadataCoreInfoImpl private constructor(): MetadataCoreInfo {
    companion object {
        fun metadataCoreInfo_(): MetadataCoreInfo = MetadataCoreInfoImpl()
    }
}