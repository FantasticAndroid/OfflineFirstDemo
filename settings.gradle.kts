pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "PokeDexApp"
include(":app")
include(":core:network")
include(":core:common")
include(":core:database")

include(":feature:pokedexlist:data")
include(":feature:pokedexlist:domain")
include(":feature:pokedexlist:ui")
