package id.solo.newsapp.model

data class ResponseNews(
	val data: List<DataItem?>? = null,
	val status: String? = null
)

data class DataItem(
	val jsonMember: String? = null,
	val nama_berita: String? = null,
	val keterangan: String? = null,
	val sumber: String? = null,
	val tanggal: String? = null,
	val timestamp: String? = null,
	val isi_berita: String? = null,
	val url_image: String? = null
)

