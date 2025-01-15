plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.seleniumhq.selenium:selenium-java:4.27.0")
    implementation("io.rest-assured:rest-assured:5.5.0")
    implementation("org.testng:testng:7.10.2")
    compileOnly("org.projectlombok:lombok:1.18.36")
    annotationProcessor("org.projectlombok:lombok:1.18.36")
    implementation("org.slf4j:slf4j-api:2.0.16")
    implementation("org.json:json:20250107")
    implementation("com.jayway.jsonpath:json-path:2.9.0")
}

tasks.test {
    useJUnitPlatform()
}