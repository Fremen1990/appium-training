# Instalacja

Java
- Pobrać i rozpakować Java JDK 21 - https://download.oracle.com/java/21/latest/jdk-21_windows-x64_bin.zip
- Ustawić zmienną środowiskową JAVA_HOME na katalog z rozpakowanym JDK
- Dodać do zmiennej środowiskowej PATH katalog JAVA_HOME\bin

node.js
- Pobrać i zainstalować aktualną wersję nodejs - https://nodejs.org ewentualnie pobrać zip i ustawić zmienną środowiskową PATH do katalogu bin

Android Studio
- Pobrać i zainstalować aktualną wersję Android Studio - https://developer.android.com/studio
- Za pomocą SDK Manager doinstalować Android SDK Command-line Tools
- Pobrać bundle tools - https://github.com/google/bundletool/releases i skopiować do ANDROID_HOME pod nazwą bundletool.jar
- Ustawić zmienną środowiskową ANDROID_HOME na C:\Users\user_name\AppData\Local\Android\Sdk
- Dodać do zmiennej środowiskowej PATH ANDROID_HOME\platform-tools
- Dodać do zmiennej środowiskowej PATH ANDROID_HOME\bundle-tool
- Dodać do zmiennej środowiskowej PATHEXT element .jar

ffmpeg
- Pobrać i rozpakować https://www.ffmpeg.org/download.html
- Dodać do zmiennej środowiskowej PATH ffmpeg.exe

gstreamer
- zainstalować - https://gstreamer.freedesktop.org/data/pkg/windows/1.24.8/msvc/gstreamer-1.0-msvc-x86_64-1.24.8.msi i ustawić zmienną środowiskową PATH do katalogu bin

Appium
- npm install -g appium
- appium setup
- appium driver doctor uiautomator2

App inspector
- Pobrać i zainstalować - https://github.com/appium/appium-inspector

# Komendy
pip install Appium-Python-Client
py nazwa_skryptu.py