package id.solo.newsapp.model

data class ResponseNews(
	val data: List<DataItem?>? = null,
	val status: String? = null
)

data class DataItem(
	val jsonMember: String? = null,
	val namaBerita: String? = null,
	val keterangan: String? = null,
	val sumber: String? = null,
	val tanggal: String? = null,
	val timestamp: String? = null,
	val isiBerita: String? = null,
	val urlImage: String? = null
)

