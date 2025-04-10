#!/data/data/com.termux/files/usr/bin/bash

cd ~/TBOX || exit
echo "Cleaning project..."
./gradlew clean

echo "Assembling APK..."
./gradlew assembleRelease

APK_PATH="~/TBOX/app/build/outputs/apk/release/app-release.apk"

if [ -f $APK_PATH ]; then
  echo "APK built successfully at: $APK_PATH"
  termux-open $APK_PATH
else
  echo "Build failed. APK not found."
fi

