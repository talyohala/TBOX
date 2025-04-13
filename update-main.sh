#!/bin/bash

echo "=== מעדכן את כל קבצי Main ==="

mkdir -p app/src/main/java/com/tbox/app
mkdir -p app/src/main/res/values
mkdir -p app/src/main/res/values-night

# === MainActivity.kt ===
cat > app/src/main/java/com/tbox/app/MainActivity.kt << 'EOF'
package com.tbox.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.tbox.app.ui.theme.TBOXTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Surface

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TBOXTheme {
                Surface {
                    Text("ברוך הבא ל-TBOX!")
                }
            }
        }
    }
}
EOF

# === AndroidManifest.xml ===
cat > app/src/main/AndroidManifest.xml << 'EOF'
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.tbox.app">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="TBOX"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.TBOX">
        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN"/>
                <category android:name="android.intent.category.LAUNCHER"/>
            </intent-filter>
        </activity>
    </application>

</manifest>
EOF

# === themes.xml ===
cat > app/src/main/res/values/themes.xml << 'EOF'
<resources xmlns:tools="http://schemas.android.com/tools">
    <style name="Theme.TBOX" parent="Theme.Material3.Light.NoActionBar">
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorOnPrimary">@color/colorOnPrimary</item>
        <item name="colorSecondary">@color/colorSecondary</item>
        <item name="colorOnSecondary">@color/colorOnSecondary</item>
        <item name="android:statusBarColor" tools:targetApi="l">@color/colorPrimary</item>
        <item name="android:navigationBarColor">@color/colorPrimary</item>
    </style>
</resources>
EOF

# === themes-night.xml ===
cat > app/src/main/res/values-night/themes.xml << 'EOF'
<resources xmlns:tools="http://schemas.android.com/tools">
    <style name="Theme.TBOX" parent="Theme.Material3.Dark.NoActionBar">
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorOnPrimary">@color/colorOnPrimary</item>
        <item name="colorSecondary">@color/colorSecondary</item>
        <item name="colorOnSecondary">@color/colorOnSecondary</item>
        <item name="android:statusBarColor" tools:targetApi="l">@color/colorPrimary</item>
        <item name="android:navigationBarColor">@color/colorPrimary</item>
    </style>
</resources>
EOF

# === colors.xml ===
cat > app/src/main/res/values/colors.xml << 'EOF'
<resources>
    <color name="colorPrimary">#6750A4</color>
    <color name="colorOnPrimary">#FFFFFF</color>
    <color name="colorSecondary">#625B71</color>
    <color name="colorOnSecondary">#FFFFFF</color>
    <color name="colorBackground">#FFFFFF</color>
    <color name="colorOnBackground">#000000</color>
    <color name="colorSurface">#FFFFFF</color>
    <color name="colorOnSurface">#000000</color>
    <color name="colorError">#B3261E</color>
    <color name="colorOnError">#FFFFFF</color>
</resources>
EOF

# === עדכון build.gradle.kts ===
BUILD_FILE="app/build.gradle.kts"

sed -i '/compose = true/!s/buildFeatures {/buildFeatures {\n        compose = true/' "$BUILD_FILE"
sed -i '/kotlinCompilerExtensionVersion/ d' "$BUILD_FILE"
sed -i "/composeOptions {/a \        kotlinCompilerExtensionVersion = \"1.5.3\"" "$BUILD_FILE"

# הוספת תלויות אם חסרות
if ! grep -q 'material3:material3' "$BUILD_FILE"; then
    sed -i "/dependencies {/a \    implementation(\"androidx.compose.material3:material3:1.2.1\")" "$BUILD_FILE"
fi

if ! grep -q 'window-size-class' "$BUILD_FILE"; then
    sed -i "/dependencies {/a \    implementation(\"androidx.compose.material3:material3-window-size-class:1.1.2\")" "$BUILD_FILE"
fi

# === פוש לגיטאהב ===
git add .
git commit -m "עדכון מלא לכל קבצי Main: Activity, Manifest, Themes, Gradle"
git push origin main --force

echo "הכל הושלם! אתה יכול כעת להריץ ./gradlew assembleRelease"
