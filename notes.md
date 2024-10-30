# Instalacja

Java
- Pobrać i rozpakować Java JDK 21
  https://download.oracle.com/java/21/latest/jdk-21_windows-x64_bin.zip lub https://www.azul.com/downloads/?version=java-21-lts&os=macos&package=jdk#zulu
- Ustawić zmienną środowiskową JAVA_HOME na katalog z rozpakowanym JDK
- Dodać do zmiennej środowiskowej PATH katalog JAVA_HOME\bin

node.js
- Pobrać i zainstalować aktualną wersję nodejs - https://nodejs.org ewentualnie pobrać zip i ustawić zmienną środowiskową PATH do katalogu bin

Dla linux/macOS:
mkdir ~/.npm-global
npm config set prefix '~/.npm-global'
export PATH=~/.npm-global/bin:$PATH

Android Studio
- Pobrać i zainstalować aktualną wersję Android Studio - https://developer.android.com/studio
- Za pomocą SDK Manager doinstalować Android SDK Command-line Tools
- Pobrać bundle tools - https://github.com/google/bundletool/releases i skopiować do ANDROID_HOME pod nazwą bundletool.jar
- Ustawić zmienną środowiskową ANDROID_HOME na C:\Users\user_name\AppData\Local\Android\Sdk
- Dodać do zmiennej środowiskowej PATH ANDROID_HOME\platform-tools
- Dodać do zmiennej środowiskowej PATH ANDROID_HOME\bundle-tool
- Dodać do zmiennej środowiskowej PATHEXT element .jar (dla linux/macOS chmod +x bundletool.jar)

ffmpeg
- Pobrać i rozpakować https://www.ffmpeg.org/download.html lub brew install ffmpeg
- Dodać do zmiennej środowiskowej PATH ffmpeg.exe

gstreamer
- zainstalować -https://gstreamer.freedesktop.org/download i 
  ustawić zmienną środowiskową PATH do katalogu bin c:\gstreamer lub /Library/Frameworks/GStreamer.framework/Commands

Appium
- npm install -g appium
- appium setup
- appium driver doctor uiautomator2

App inspector
- Pobrać i zainstalować - https://github.com/appium/appium-inspector

Dodatkowo dla iOS
- appium driver doctor xcuitest
- sudo xcode-select -s "/Applications/Xcode.app/Contents/Developer"
- brew tap wix/brew
- brew install applesimutils
- brew tap facebook/fb
- brew install idb-companion
- pip3 install fb-idb

# Komendy
Opakowanie projektu maven wrapperem
mvn wrapper:wrapper 

# Pobieranie informacji o urządzeniach
- adb devices

- xcrun simctl list
- xcrun xctrace list devices

# Uruchamianie symulatorów/emulatorów
- avdmanager list avd
- emulator -avd <emulator-name>

- xcrun simctl list
- xcrun simctl boot <udid>

# Budowanie projekty pod Appium z XCode
- Ustawiamy platformę (Product -> Destination -> Phone x)
- Budujemy projekt (Product -> Build) 
- Otwieramy ~/Library/Developer/Xcode/DerivedData/<nazwa-projektu-random_id>/Build/Products/Debug-iphonesimulator/<nazwa-projektu>.app