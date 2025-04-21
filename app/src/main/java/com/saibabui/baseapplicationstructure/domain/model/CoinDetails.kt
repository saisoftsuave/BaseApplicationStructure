package com.saibabui.baseapplicationstructure.domain.model

import com.saibabui.baseapplicationstructure.data.remote.dto.Links
import com.saibabui.baseapplicationstructure.data.remote.dto.LinksExtended
import com.saibabui.baseapplicationstructure.data.remote.dto.Tag
import com.saibabui.baseapplicationstructure.data.remote.dto.TeamMember

data class CoinDetails (
    val description: String,
    val first_data_at: String,
    val id: String,
    val links: Links,
    val links_extended: List<LinksExtended>,
    val logo: String,
    val message: String,
    val name: String,
    val rank: Int,
    val symbol: String,
    val tags: List<Tag>,
    val team: List<TeamMember>,
    val type: String,
)