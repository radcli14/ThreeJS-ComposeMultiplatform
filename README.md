# ThreeJS-ComposeMultiplatform
Integration of the Three.js toolset into the Compose Multiplatform framework 

## Procedure

### Coding Environment Setup
- Install the latest Android Studio. [Link](https://developer.android.com/studio)
  * Optional: install XCode if building for iOS. 
- Configure Android Studio for Compose Multiplatform. [Link](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-multiplatform-create-first-app.html)
  * Install the Kotlin Multiplatform plugin.
  * Run Kdoctor to verify.
- Optional: Create a GitHub project.
  * Give it a name.
  * Select public or private.
  * Optional: create README and license files.

![New GitHub Project](screenshots/newGithubProject.png)
 
### Compose Multiplatform Template
- Visit the Kotlin Multiplatform wizard site. [Link](https://kmp.jetbrains.com/?)
  * Provide a name, does not have to match your Github repository, I chose `ThreeDemo`.
  * Provide a unique project ID, I use `com.dcengineer.threedemo`.
    - These will generally use reverse domain syntax, and if you publish your app, will be used by the Google Play or App Store to identify it.
    - You should choose carefully as this may become semi-permanent.
  * Select which OS's you want to support.
    - For demonstration, I only selected Android and iOS.
    - For iOS, I selected to share UI, which is the purpose of Compose Multiplatform.
    - It is possible to migrate back to SwiftUI at a later date, Compose is likely a good choice for early prototyping.
    - Desktop, web, and server options are available, but will have varying degrees of support.
- Click the Download button
- Unzip, and move into your project folder.
- Optional, if you are using git, add, commit, and push your project to the remote.
```bash
git add ThreeDemo
git commit -am "added the compose multiplatform template files"
git push
```

![Kotlin Multiplatform Wizard](screenshots/composeMultiplatformWizard.png)

### Open the Project in Android Studio
- Start Android Studio
- Click `File -> Open`
- Open the folder you just copied over.
   * In my case, I am selecting the `ThreeDemo` folder.
   * You do not need to select the root directory of the GitHub folder, just the folder created by the wizard.
- Usually, select to open the project in a new window
- "Trust" the project (its yours, after all)
- Android Studio will open starting from the `README.md` file
- After various gradle build and sync tasks complete, you may "Run" the project
   * You may need to set up an emulator, which is out of scope of this tutorial, but you may search online or use this [Link](https://developer.android.com/studio/run/emulator).
   * Or, you can run on your own device if you have one. [Link](https://developer.android.com/studio/run/device)
- The template app is just a simple button, which will display a Compose Multiplatform logo and platform-specific greeting when tapped.

![Selection](screenshots/openProject_00_Selection.png)
![In New Window](screenshots/openProject_01_InNewWindow.png)
![Trust](screenshots/openProject_02_Trust.png)
![README](screenshots/openProject_03_README.png)
![Run](screenshots/openProject_04_Run.gif)
