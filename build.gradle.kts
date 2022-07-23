plugins {
    id("application")
    id("jacoco")
}

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

application {
    // default(README)
    mainClass.set("com.github.jeyeihro.readwritefile.example.ReadMe")
    // e.g. outputs single file
//    mainClass.set("com.github.jeyeihro.readwritefile.example.singleTarget.ExampleMain")
    // e.g. outputs multiple files
//    mainClass.set("com.github.jeyeihro.readwritefile.example.multipleTarget.ExampleMain")
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testImplementation("com.ginsberg:junit5-system-exit:1.1.2")
    testImplementation("org.mockito:mockito-core:4.6.1")
    testImplementation("org.mockito:mockito-junit-jupiter:4.6.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
}

jacoco{
    toolVersion = "0.8.+"
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.test{
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport{
    dependsOn(tasks.test)
    reports {
        xml.required.set(false)
        csv.required.set(false)
        html.outputLocation.set(layout.buildDirectory.dir("jacocoHtml"))
    }
}

tasks.javadoc {
    charset("UTF-8")
    options.encoding("UTF-8")
}