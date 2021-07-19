package com.vkt4u9999.mdevel

data class Configuration(
    val latency: Int,
    val color: Int
)


class ConfigurationBuilder{
    var latency= 100
    var color = 2


    fun latency(value: Int):ConfigurationBuilder{
        this.latency= value
        return this
    }
    fun color(value: Int): ConfigurationBuilder{
        this.color= value
        return this
    }

    fun build():Configuration= Configuration(
        latency= latency,
        color= color
    )
}