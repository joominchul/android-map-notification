package campus.tech.kakao.map.data.document

import com.google.gson.annotations.SerializedName

data class SameName(
	val region: List<String>,
	val keyword: String,
	@SerializedName("selected_region")
	val selectedRegion: String
)