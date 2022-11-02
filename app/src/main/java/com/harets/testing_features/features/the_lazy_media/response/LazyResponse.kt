package com.harets.testing_features.features.the_lazy_media.response

import com.google.gson.annotations.SerializedName

data class LazyResponse(

	@field:SerializedName("LazyResponse")
	val lazyResponse: List<LazyResponseItem?>? = null
)

data class LazyResponseItem(

	@field:SerializedName("thumb")
	val thumb: String? = null,

	@field:SerializedName("author")
	val author: String? = null,

	@field:SerializedName("tag")
	val tag: String? = null,

	@field:SerializedName("time")
	val time: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("key")
	val key: String? = null,

	@field:SerializedName("desc")
	val desc: String? = null
)
