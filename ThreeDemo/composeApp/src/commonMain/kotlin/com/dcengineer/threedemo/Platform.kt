package com.dcengineer.threedemo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform