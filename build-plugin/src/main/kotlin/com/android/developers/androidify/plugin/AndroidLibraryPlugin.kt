package com.android.developers.androidify.plugin

import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.assign
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

class AndroidLibraryPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            apply(plugin = "com.android.library")
            // AGP 9.0 built-in Kotlin (KGP 2.2.21 via root buildscript); kotlin.android incompatible with new DSL

            extensions.configure<LibraryExtension> {
                compileOptions.apply {
                    val javaVersion = JavaVersion.toVersion(getVersionByName("javaVersion"))
                    sourceCompatibility = javaVersion
                    targetCompatibility = javaVersion
                }
            }
            extensions.configure<KotlinAndroidProjectExtension> {
                compilerOptions.apply {
                    jvmTarget = JvmTarget.fromTarget(getVersionByName("javaVersion"))
                }
            }
        }
    }
}
