plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.crudapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.crudapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)


    // ✅ Firebase BOM
    implementation(platform("com.google.firebase:firebase-bom:32.7.0"))


    //✅ Firebase dependencies (No version required because BOM handles it)
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-firestore")

    // ✅ Google Sign-In dependency (Keep version as it is)
    implementation("com.google.android.gms:play-services-auth:20.7.0")


    implementation("com.google.firebase:firebase-database")


    implementation("com.firebaseui:firebase-ui-firestore:8.0.2") {
        exclude(group = "com.google.firebase", module = "firebase-common")
    }
    implementation("com.firebaseui:firebase-ui-database:8.0.2") {
        exclude(group = "com.google.firebase", module = "firebase-common")
    }


    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("com.github.bumptech.glide:glide:4.16.0")
    implementation("de.hdodenhof:circleimageview:3.1.0")
    implementation ("com.orhanobut:dialogplus:1.11@aar")



    implementation(libs.constraintlayout)

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}