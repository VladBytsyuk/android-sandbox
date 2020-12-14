package com.vbytsyuk.build


object Deps {
    object Kotlin {
        const val Version = "1.4.10"
        const val StdLib = "org.jetbrains.kotlin:kotlin-stdlib:$Version"
        const val StdLibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$Version"
        const val Test = "org.jetbrains.kotlin:kotlin-test:1.1.51"
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
            const val Compose = "androidx.ui:ui-test:${Libs.Compose.Version}"
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

        object Coil {
            private const val Version = "1.0.0-rc3"
            const val Core = "io.coil-kt:coil:$Version"
            const val Gif = "io.coil-kt:coil-gif:$Version"
        }
        object Fresco {
            private const val Version = "2.3.0"
            const val Core = "com.facebook.fresco:fresco:$Version"
            const val Gif =  "com.facebook.fresco:animated-gif:$Version"

            object WebP {
                const val Core = "com.facebook.fresco:webpsupport:$Version"
                const val Animations = "com.facebook.fresco:animated-webp:$Version"
            }
        }

        object Compose {
            const val Version = "1.0.0-alpha05"
            const val Ui = "androidx.compose.ui:ui:$Version"
            const val UiTooling = "androidx.ui:ui-tooling:$Version"
            const val Foundation = "androidx.compose.foundation:foundation:$Version"
            object Material {
                const val Core = "androidx.compose.material:material:$Version"
                object Icons {
                    const val Core = "androidx.compose.material:material-icons-core:$Version"
                    const val Extended = "androidx.compose.material:material-icons-extended:$Version"
                }
            }
            object Observable {
                const val LiveData = "androidx.compose.runtime:runtime-livedata:$Version"
                const val RxJava = "androidx.compose.runtime:runtime-rxjava2:$Version"
            }
        }
    }
}
