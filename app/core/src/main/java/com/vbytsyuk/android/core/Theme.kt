package com.vbytsyuk.android.core


enum class Theme(val code: Int) {
    LIGHT(0), DARK(1);

    companion object {
        fun fromCode(code: Int): Theme = values().find { it.code == code } ?: throwIllegalCode(code)

        private fun throwIllegalCode(code: Int): Nothing = throw IllegalArgumentException(
            "There are no Theme instance with code = $code. Should be in ${values().map { it.code }}."
        )
    }
}
