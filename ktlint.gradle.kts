val ktlint: Configuration by configurations.creating

dependencies {
    ktlint("com.pinterest:ktlint:0.42.1")
}

tasks.named("check") {
    dependsOn(ktlint)
}

tasks.named("check") {
    dependsOn("lint")
}

tasks.register<JavaExec>("ktlint") {
    description = "Check Kotlin code style."
    main = "com.pinterest.ktlint.Main"
    classpath = ktlint
    args("--android", "src/**/*.kt", "disabled_rules = import-ordering")
}

tasks.register<JavaExec>("ktlintFormat") {
    description = "Fix Kotlin code style devitions."
    main = "com.pinterest.ktlint.Main"
    classpath = ktlint
    args("--android", "-F", "src/**/*.kt")
}

