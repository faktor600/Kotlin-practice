package com.simbir.kotlinpractice.data.json

import java.io.InputStream
import javax.inject.Inject

class InitJson @Inject constructor() : (InputStream?) -> String? {

    override fun invoke(inputStream: InputStream?): String? {
        return inputStream?.bufferedReader().use { it?.readLine() }
    }
}