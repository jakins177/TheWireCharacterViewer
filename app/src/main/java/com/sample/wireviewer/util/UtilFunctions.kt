package com.sample.wireviewer.util

val showQuery = "the+wire+characters"

fun parseName(example: String): String {
    val delimiter = " - "
    val splitString = example.split(delimiter)
    return if (splitString.size > 1) {
        splitString[0].trim()
    } else {
        return ""
    }
}