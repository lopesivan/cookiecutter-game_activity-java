plugins { id("com.android.application") }

android {
    namespace = "{{ cookiecutter.package_name }}"
    compileSdk = {{ cookiecutter.compileSdk }}

    defaultConfig {
        applicationId = "{{ cookiecutter.package_name }}"
        minSdk = {{ cookiecutter.minSdk }}
        targetSdk = {{ cookiecutter.targetSdk }}
        versionCode = {{ cookiecutter.versionCode }}
        versionName = "{{ cookiecutter.versionName }}"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        externalNativeBuild { cmake { cppFlags += "-std=c++17" } }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures { prefab = true }
    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:{{ cookiecutter.__androidx_appcompat_appcompat_version }}")
    implementation("com.google.android.material:material:{{ cookiecutter.__com_google_android_material_material_version }}")
    implementation("androidx.games:games-activity:{{ cookiecutter.__androidx_games_games_activity_version }}")
    testImplementation("junit:junit:{{ cookiecutter.__junit_junit_version }}")
    androidTestImplementation("androidx.test.ext:junit:{{ cookiecutter.__androidx_test_ext_junit_version }}")
    androidTestImplementation("androidx.test.espresso:espresso-core:{{ cookiecutter.__androidx_test_espresso_espresso_core_version }}")
}
