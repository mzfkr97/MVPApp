dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven(
            url = "https://maven.google.com/"
        )
        maven(
            url = "https://www.jitpack.io"
        )
    }
}
rootProject.name = "MVPApp"
include(":app")
