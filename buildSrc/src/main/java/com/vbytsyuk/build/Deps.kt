package com.vbytsyuk.build


object Deps {
    object Kotlin {
        const val Version = "1.4.10"
        const val StdLib = "org.jetbrains.kotlin:kotlin-stdlib:$Version"
    }

    object Android {
        object Support {
            const val MultiDex = "com.android.support:multidex:1.0.3"
        }

        object X {
            object KTX {
                const val Core = "androidx.core:core-ktx:1.3.2"
                const val Activity = "androidx.activity:activity-ktx:1.1.0"
            }
            const val AppCompat = "androidx.appcompat:appcompat:1.2.0"
            const val ConstraintLayout = "androidx.constraintlayout:constraintlayout:2.0.2"
        }

        const val Material = "com.google.android.material:material:1.2.1"
    }


    object Test {
        const val Junit = "junit:junit:4.13.1"

        object Android {
            const val Junit = "androidx.test.ext:junit:1.1.2"
            const val Espresso = "androidx.test.espresso:espresso-core:3.3.0"
        }
    }

    object Libs {
        object Koin {
            const val Version = "2.1.6"
            const val Core = "org.koin:koin-core:$Version"
            const val Ext = "org.koin:koin-core-ext:$Version"
            const val Test = "org.koin:koin-test:$Version"
            object Android {
                const val Android = "org.koin:koin-android:$Version"
                const val Scope = "org.koin:koin-android-scope:$Version"
                const val ViewModel = "org.koin:koin-android-viewmodel:$Version"
            }
            object AndroidX {
                const val Scope = "org.koin:koin-androidx-scope:$Version"
                const val ViewModel = "org.koin:koin-androidx-viewmodel:$Version"
                const val Fragment = "org.koin:koin-androidx-fragment:$Version"
            }
        }

        object Glide {
            private const val Version = "4.11.0"
            const val Core = "com.github.bumptech.glide:glide:$Version"
            const val Compiler = "com.github.bumptech.glide:compiler:$Version"
        }

        const val Picasso = "com.squareup.picasso:picasso:2.8"
    }
}
