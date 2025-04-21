package com.saibabui.baseapplicationstructure.data.remote.dto

import com.saibabui.baseapplicationstructure.data.remote.dto.Stats

data class LinksExtended(
    val stats: Stats,
    val type: String,
    val url: String
)