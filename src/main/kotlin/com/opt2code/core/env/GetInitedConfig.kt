/**
 * Copyright (C) 2019-present alexn0
 * All rights reserved.
 */
package com.opt2code.core.env

import com.opt2code.core.metadata.MetadataCoreInfo
import com.opt2code.env.ConfigImpl
import com.opt2code.env.globalConfig

fun getInitedConfig() = globalConfig
        ?: ConfigImpl.config(CoreEnvironmentImpl()).also {
            globalConfig = it
        }

fun <T: MetadataCoreInfo> metadataInfoFromEnv(): T = getInitedConfig().env<CoreEnvironment>().metadataInfo()