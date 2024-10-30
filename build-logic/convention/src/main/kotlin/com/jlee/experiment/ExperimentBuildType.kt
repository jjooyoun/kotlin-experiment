package com.jlee.experiment

/**
 * This is shared between :app and :benchmarks module to provide configurations type safety.
 */
enum class ExperimentBuildType(val applicationIdSuffix: String? = null) {
    DEBUG(applicationIdSuffix = ".debug"),
    RELEASE,
}
