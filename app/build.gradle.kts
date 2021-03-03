/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java application project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/6.7/userguide/building_java_projects.html
 */
import org.gradle.jvm.tasks.Jar

plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    //no dependencies is the goal
}

application {
    // Define the main class for the application.
    mainClass.set("ru.aielemental.agile.planning.poker.PlanningPokerServer")
}

val uberJar = task("uberJar", type = Jar::class) {
    baseName = "${project.name}"
    manifest {
        attributes["Implementation-Title"] = "Gradle Jar For Agile Poker app"
        attributes["Implementation-Version"] = "Alpha.1"
        attributes["Main-Class"] = "ru.aielemental.agile.planning.poker.PlanningPokerServer"
    }
    from(configurations.runtimeClasspath.get().map({ if (it.isDirectory) it else zipTree(it) }))
    with(tasks.jar.get() as CopySpec)
}

tasks {
    "build" {
        dependsOn(uberJar)
    }
}

//tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class.java).all {
//    kotlinOptions {
//        jvmTarget = "1.8"
//    }
//}