# Application Demonstrating Screenshot Testing in Jetpack Compose

## Application Overview :
   This is a Sample application demonstrating screenshot testing. 
   It uses `https://www.healthcare.gov/` provided APIs to build a few screens.
   Screens : Splash screen, Home Screen, Article / Blog listing Screen, Article or Blog Details Screen which is a web view
   
## Architecture :
- MultiModule Application with MVI Clean architecture pattern
- JetPack Compose for UI layer
- Retrofit for making network calls
- Dagger Hilt for DI
- Coroutines + Flows
- Shot, Showkase and Paparazzi are used for screenshot testing

## Module structure
- `app` combines all `feature` modules and decides navigation between pages
- `design` contains reusable component UIs. Primarily screenshot testing is done here This involves `showkase`+`paparazzi` tests as unit tests and `showkase` + `shot` as instrumentation tests
- `core` Has retrofit setup and common utility classes
- `feature` module contains multiple stand alone features which depend on `design` and `core` modules. Only Paparazzi tests are written here
    - `launcher`
    - `home` has home, article / blog listing and detail screens

## Running Tests

   Device specifications and respective commands
   ###### Pixel 4 XL API 33
   - 6.3",  1440x3040, xxhdpi, API 33
   - ./gradlew executeScreenshotTests -PdirectorySuffix=Pixel4XL
   ./gradlew executeScreenshotTests -Precord -PdirectorySuffix=Pixel4XL

   ###### Pixel 5
   - 6.0'', 1080x2340, xxhdpi, Android R
   - ./gradlew executeScreenshotTests -PdirectorySuffix=Pixel5
   - ./gradlew executeScreenshotTests -Precord -PdirectorySuffix=Pixel5
   
   To use Showkase along with other screenshot testing libraries such as Shot and Paparazzi, write 
   @Preview composables (Or showkase has @ShowkaseComposable annotation for the same purpose)

   Detailed configurations for these libraries present at the end of this screen

  ###### Showkase + Shot
  - Showkase provides bitmaps of the @Preview composables in androidTests. Dependency is added for the same.
  - Shot uses the bitmaps, takes screenshots, records them in specified folder or verifies them against already recorded screenshots
  - Tests can be run using following commands.
      - `./gradlew :design:executeScreenshotTests -Precord` This will record screenshots into the folder. This folder will be 
               present in the module root folder
      - `./gradlew :design:executeScreenshotTests` This will verify te screenshots against the recorded ones and gives error description if not matching
  - Refer `DesignTests.kt` in androidTest package
  - Sample Screenshots

![com yml design DesignTests_ShowkaseCodegen_toolbar_title](https://user-images.githubusercontent.com/102218374/183367914-ee481c6b-6f10-45b6-81dc-ec1d7168b2d9.png)
  
![com yml design DesignTests_ShowkaseCodegen_error_error-screen](https://user-images.githubusercontent.com/102218374/183367967-592b61d1-3b4a-44b1-b02c-49f0fb5b11ab.png)

![com yml design DesignTests_ShowkaseCodegen_card_filled](https://user-images.githubusercontent.com/102218374/183368041-47b66296-f2b6-488b-93a7-a51eb38e256a.png)

![com yml design DesignTests_ShowkaseCodegen_bottom_bar_home_selected](https://user-images.githubusercontent.com/102218374/183368076-1e38f533-2714-45f1-8aa9-f8c0acfbe4a9.png)


![com yml design DesignTests_ShowkaseCodegen_Logo Colors_BahamaBlue](https://user-images.githubusercontent.com/102218374/183368516-b0f66956-950f-461d-9ca8-ab5327690ca2.png)


   ###### Showkase + Paparazzi
   - Showkase gives Preview components into the unitTest (dependency has to be added, see the configuration below), using Googles test parameter injection these
list of showkase preview components are injected into a single test method, where paparazzi uses them in a composable to take sanpshots and verify them.
- Paparazzi tests are unit tests, Paparazzi is similar to android preview render, and do not require device or emulator to run these.Hence they are unitTests and comparatively run faster as packaging is not required.
- To run tests run following command
   - `./gradlew :design:recordPaparazzi` will record the screenshots and place them in the test package
   - `./gradlew :design:verifyPaparazzi` verify against the recorded screens.
- Refer `SnapTest.kt` in test package

- Sample Screenshots : 

Card variants :

![com yml design_SnapTest_sample card_filled,PIXEL_4_XL,Ltr,debug](https://user-images.githubusercontent.com/102218374/183363436-7395e86d-ac49-4416-9dde-43a992376aed.png)
![com yml design_SnapTest_sample card_filled,PIXEL_4_XL,Rtl,debug](https://user-images.githubusercontent.com/102218374/183363499-ccc9a4bd-79bc-4b07-890e-c01e0a17aadc.png)
![com yml design_SnapTest_sample card_filled,NEXUS_5_LAND,Ltr,debug](https://user-images.githubusercontent.com/102218374/183363530-154bbae9-f726-4117-8e1c-41f744bbac78.png)
![com yml design_SnapTest_sample card_filled,NEXUS_5_LAND,Rtl,debug](https://user-images.githubusercontent.com/102218374/183363541-c204014b-d706-4e1f-ac26-164d777e6ef1.png)


###### Paparazzi :
- feature module contains paparazzi only tests.
- These are unit tests, and screenshots are taken by invoking each compose methods seperately.
- Sample Screenshots
![com yml healthcare home ui view_LoadedHomeKtTest_verify home screen with articles and blogs_home_fully_loaded](https://user-images.githubusercontent.com/102218374/183365810-ceb7e892-7b68-47c1-ab9b-2f70f90bf680.png)
![com yml healthcare home ui view_ArticleListScreenKtTest_verify article list loaded_articles_loaded](https://user-images.githubusercontent.com/102218374/183365883-89b37d56-a3ed-449e-a290-28c72466c2e4.png)
![com yml launcher_SplashDestinationKtTest_record splash screen and verify_splash](https://user-images.githubusercontent.com/102218374/183366176-9253d1bb-aeba-4d68-856f-ed66910f0f8b.png)



## Configurations

###### Showkase : 

Add the following dependencies in your modules
   ```
   implementation "com.airbnb.android:showkase:1.0.0-beta13"
   kapt "com.airbnb.android:showkase-processor:1.0.0-beta13"
   ```
In order to use showkase with shot or paparazzi, make sure that the below dependencies are added to the respective test flavor androidTestImplementation or testImplementation `com.airbnb.android:showkase-screenshot-testing:1.0.0-beta13`

Test parameter Injector dependency is used to inject set of values for a single test. In this project, it is used for showKase + Paparazzi tests in design module `com.google.testparameterinjector:test-parameter-injector:1.8`

###### Shot :
- Add the plugin dependency in project classpath `com.karumi:shot:5.14.1`
- Apply the plugin in the module in which tests should be run
   ```
   plugins {
      id 'shot'
   }
   ```
- Specify `testInstrumentationRunner "com.karumi.shot.ShotTestRunner"`
- Provide `testApplicationId "com.yml.healthcare.test"` This is only for library modules as they do not have application IDs
- Additional Configurations,
   ```
   shot { 
      runInstrumentation = true // Can choose not to run instrumentation tests
      tolerance = 0.1 // To vary percentatge tolerance 0 - 100, 0% tolerance => most accurate comparision
   }
   ```
- Provide manifest in the androidTest.
   ```
   <manifest xmlns:android="http://schemas.android.com/apk/res/android"
      package="<applicationId>.test" Should match the test application ID
      android:sharedUserId="<applicationId>.uid" />
   ```

###### Paparazzi :
- Plugin dependency in project gradle file
   ```
   dependencies {
      classpath 'app.cash.paparazzi:paparazzi-gradle-plugin:1.0.0'
   }
   ```
- Apply Plugin in the module where tests should be written
   ```
   plugins {
      id 'app.cash.paparazzi'
   }
   ```

