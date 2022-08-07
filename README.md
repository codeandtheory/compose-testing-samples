#Application Demonstrating Screenshot Testing in Jetpack Compose

Application Overview :
   This is a Sample application demonstrating screenshot testing. 
   It uses `https://www.healthcare.gov/` provided APIs to build a few screens.
   Screens : Splash screen, Home Screen, Article / Blog listing Screen, Article or Blog Details Screen which is a web view
   
Architecture :
   MultiModule Application with MVI Clean architecture pattern
   JetPack Compose for UI layer
   Retrofit for making network calls
   Dagger Hilt for DI
   Coroutines + Flows
   Shot, Showkase and Paparazzi are used for screenshot testing

   Module structure
      `app` combines all `feature` modules and decides navigation between pages
      `design` contains reusable component UIs. Primarily screenshot testing is done here
         This involves `showkase`+`paparazzi` tests as unit tests and `showkase` + `shot` as instrumentation tests
      `core` Has retrofit setup and common utility classes
      `feature` module contains multiple stand alone features which depend on `design` and `core` modules. Only Paparazzi tests are written here
         `launcher`
         `home` has home, article / blog listing and detail screens

Running Tests
   To use Showkase along with other screenshot testing libraries such as Shot and Paparazzi, write 
   @Preview composables (Or showkase has @ShowkaseComposable annotation for the same purpose)

   Detailed configurations for these libraries present at the end of this screen

   `Showkase` + `Shot` :
      - Showkase provides bitmaps of the @Preview composables in androidTests. Dependency is added for the same.
      - Shot uses the bitmaps, takes screenshots, records them in specified folder or verifies them against already recorded screenshots
      - Tests can be run using following commands.
            `./gradlew :design:executeScreenshotTests -Precord` This will record screenshots into the folder. This folder will be 
               present in the module root folder
            `./gradlew :design:executeScreenshotTests` This will verify te screenshots against the recorded ones and gives error description if not matching
      - Refer `DesignTests.kt` in androidTest package

   `Showkase` + `Paparazzi` :
      -  Showkase gives Preview components into the unitTest (dependency has to be added, see the configuration below), using Googles test parameter injection these
list of showkase preview components are injected into a single test method, where paparazzi uses them in a composable to take sanpshots and verify them.
      - Paparazzi tests are unit tests, Paparazzi is similar to android preview render, and do not require device or emulator to run these.
         Hence they are unitTests and comparatively run faster as packaging is not required.
      -  To run tests run following commands
         `./gradlew :design:recordPaparazzi` will record the screenshots and place them in the test package
         `./gradlew :design:verifyPaparazzi` verify against the recorded screens.



      - Refer `SnapTest.kt` in test package

Test Demonstrations 
   Shot tests can be run on design modules. These tests are instrumentation tests. Here shot depends on showkase to
   provide bitmaps of the `@Preview` Composable.

Configurations : 
Showkase : 

Add the following dependencies in your modules
   implementation "com.airbnb.android:showkase:1.0.0-beta13"
   kapt "com.airbnb.android:showkase-processor:1.0.0-beta13"

In order to use showkase with shot or paparazzi, make sure that the below dependencies are added 
to the respective test flavor androidTestImplementation or testImplementation
   "com.airbnb.android:showkase-screenshot-testing:1.0.0-beta13"


Test parameter Injector dependency is used to inject set of values for a single test. In this project, it
is used for showKase + Paparazzi tests in design module
"com.google.testparameterinjector:test-parameter-injector:1.8"

Shot :
   Add the plugin dependency in project classpath `com.karumi:shot:5.14.1`
   Apply the plugin in the module in which tests should be run
      `plugins {
         id 'shot'
      }`
   
   Specify `testInstrumentationRunner "com.karumi.shot.ShotTestRunner"`
   Provide `testApplicationId "com.yml.healthcare.test"` This is only for library modules as they do not have application IDs
   Additional Configurations :-
   `shot { 
      runInstrumentation = true // Can choose not to run instrumentation tests
      tolerance = 0.1 // To vary percentatge tolerance 0 - 100, 0% tolerance => most accurate comparision
   }`
   Provide manifest in the androidTest.
   `<manifest xmlns:android="http://schemas.android.com/apk/res/android"
      package="<applicationId>.test" Should match the test application ID
      android:sharedUserId="<applicationId>.uid" />`

Paparazzi :
   Plugin dependency in project gradle file
      `dependencies {
         classpath 'app.cash.paparazzi:paparazzi-gradle-plugin:1.0.0'
      }`
   Apply Plugin in the module where tests should be written
      `plugins {
         id 'app.cash.paparazzi'
      }`

