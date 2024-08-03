package campus.tech.kakao.map.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import campus.tech.kakao.map.data.document.Document
import campus.tech.kakao.map.data.document.PlaceResponse
import campus.tech.kakao.map.data.remote.UrlContract.AUTHORIZATION
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RetrofitData @Inject constructor(private val retrofitService: RetrofitService) {
	private val _documents = MutableLiveData<List<Document>>()

	fun searchPlace(query : String){
		retrofitService.requestPlaces(AUTHORIZATION,query).enqueue(object : Callback<PlaceResponse> {
			override fun onResponse(
				call: Call<PlaceResponse>,
				response: Response<PlaceResponse>
			) {
				if (response.isSuccessful) {
					val documentList = mutableListOf<Document>()
					val body = response.body()
					body?.documents?.forEach {document ->
						documentList.add(
							Document(
							document.placeName,
							document.categoryGroupName,
							document.addressName,
							document.longitude,
							document.latitude)
						)
					}
					_documents.value = documentList
				}
			}

			override fun onFailure(call: Call<PlaceResponse>, t: Throwable) {
			}
		})
	}

//	fun searchPlace(query: String): Flow<List<Document>> = flow {
//		try {
//			val response = retrofitService.requestPlaces(AUTHORIZATION, query).execute()
//			if (response.isSuccessful) {
//				val documentList = response.body()?.documents?.map { document ->
//					Document(
//						document.placeName,
//						document.categoryGroupName,
//						document.addressName,
//						document.longitude,
//						document.latitude
//					)
//				} ?: emptyList()
//				emit(documentList)
//			} else {
//				// 에러 처리
//				Log.e("RetrofitData", "else Error: ${response.code()}")
//				emit(emptyList())
//			}
//		} catch (e: Exception) {
//			// 에러 처리
//			Log.e("RetrofitData", "catch Error: ${e.message}")
//			emit(emptyList())
//		}
//	}

	fun getDocuments() :LiveData<List<Document>>{
		return _documents
	}
}