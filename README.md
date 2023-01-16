# ProductionControl
![image](https://img.shields.io/badge/API-26%2B-brightgreen.svg?style=flat)
<br>This is an application for stage control in production.
<br>Get the stages of production,
<br>carry out inspections for each stage,
<br>record progress and send information about defects.

![image](https://user-images.githubusercontent.com/121013858/212647208-9eb03250-13a3-4f80-b966-51357ccaeb87.png)
![image](https://user-images.githubusercontent.com/121013858/212647865-7a683815-ce5e-4b41-9ce5-ad6eb8c5bcd5.png)

## App features:
* Production stages
* Checklist of stage

## Project scructure
* Core (common packages that are used throughout the application)
* Features (the package that contains the application features)

## Architecture
+ The application is based on the MVI architecture-pattern (without special mvi libraries)
+ Uses concepts of the architecture called [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html).

## Tech stack - Library:
+ [Kotlin](https://kotlinlang.org/)
+ [Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
+ [Flow](https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/)
+ [Dagger-Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
+ [JetPack Compose](https://developer.android.com/jetpack/androidx/releases/compose)
+ [ViewModek](https://developer.android.com/topic/libraries/architecture/viewmodel)
+ [Room](https://developer.android.com/training/data-storage/room)
+ [Retrofit](https://github.com/square/retrofit)
+ [OkHttp](https://square.github.io/okhttp/)
+ [Gson](https://github.com/google/gson)
