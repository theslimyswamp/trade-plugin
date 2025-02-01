import xyz.jpenilla.resourcefactory.bukkit.BukkitPluginYaml

plugins {
    java

    id("io.papermc.paperweight.userdev") version "1.7.3"
    id("xyz.jpenilla.resource-factory-bukkit-convention") version "1.2.0"
    id("xyz.jpenilla.run-paper") version "2.3.1"
    kotlin("jvm")
}

group = "org.rolypolyvole"
version = "1.1-SNAPSHOT"

val projectGroupString = group.toString()
val projectVersionString = version.toString()

val javaVersion = 21
val javaVersionEnumMember = JavaVersion.valueOf("VERSION_$javaVersion")

val paperApiMinecraftVersion = "1.21.1"
val paperApiVersion = "$paperApiMinecraftVersion-R0.1-SNAPSHOT"

java {
    sourceCompatibility = javaVersionEnumMember
    targetCompatibility = javaVersionEnumMember

    toolchain.languageVersion.set(JavaLanguageVersion.of(javaVersion))
}

repositories {
    mavenCentral()
}

dependencies {
    paperweight.paperDevBundle(paperApiVersion)

    implementation(kotlin("stdlib-jdk8"))
}

tasks {
    compileJava {
        options.release.set(javaVersion)
    }

    javadoc {
        options.encoding = Charsets.UTF_8.name()
    }
}

bukkitPluginYaml {
    name = "Trading"

    authors = listOfNotNull("rolyPolyVole")

    setVersion(project.version)

    apiVersion = paperApiMinecraftVersion
    main = "${project.group}.trading.Trading"

    load = BukkitPluginYaml.PluginLoadOrder.STARTUP

    commands.register("trade") { description = "Send a trade request to a player."; usage = "Invalid usage! /trade <player>" }
}
