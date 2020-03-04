package spp.gps.api

import android.os.AsyncTask
import java.io.*
import java.net.HttpURLConnection
import java.net.URL


class Api : AsyncTask<String, String, String>() {

    override fun doInBackground(vararg params: String?): String? {
        val urlString = params[0] // URL to call
        val data = params[1] //data to post
        var out: OutputStream? = null

        try {
            val url = URL(urlString)
            val urlConnection = url.openConnection() as HttpURLConnection
            out = BufferedOutputStream(urlConnection.outputStream)

            val writer = BufferedWriter(OutputStreamWriter(out, "UTF-8"))
            writer.write(data)
            writer.flush()
            writer.close()
            out.close()

            urlConnection.connect()
        } catch (e: Exception) {
            println(e.message)
        }
        return ""
    }
}