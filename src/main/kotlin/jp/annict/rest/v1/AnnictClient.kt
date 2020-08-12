package jp.annict.rest.v1

import com.google.gson.Gson
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType

class AnnictClient(val token: String) {

    val client: OkHttpClient = OkHttpClient()

    val GSON = Gson()

    fun getUrlBuilder() : HttpUrl.Builder {
        return HttpUrl.Builder()
            .scheme("https")
            .host("api.annict.com")
            .addPathSegment("v1")
    }

    fun request(requestBuilder: Request.Builder) : Response {
        return this.client.newCall(requestBuilder.header("Authorization", "Bearer $token").build()).execute()
    }
}