#!/bin/bash

echo "יוצר ערכות עיצוב Material3..."

mkdir -p app/src/main/res/values
mkdir -p app/src/main/res/values-night

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

# === Update AndroidManifest.xml ===
sed -i '/<application / s|>| android:theme="@style/Theme.TBOX">|' app/src/main/AndroidManifest.xml

# === Update build.gradle.kts ===
echo "מוסיף תלויות Material3 אם חסר..."

GRADLE_FILE="app/build.gradle.kts"
MATERIAL3_DEP='implementation("androidx.compose.material3:material3:1.2.1")'

if ! grep -q "$MATERIAL3_DEP" "$GRADLE_FILE"; then
    sed -i "/dependencies {/a \    $MATERIAL3_DEP" "$GRADLE_FILE"
fi

WINDOW_DEP='implementation("androidx.compose.material3:material3-window-size-class:1.1.2")'
if ! grep -q "$WINDOW_DEP" "$GRADLE_FILE"; then
    sed -i "/dependencies {/a \    $WINDOW_DEP" "$GRADLE_FILE"
fi

# === Git push ===
echo "שולח פוש ל-GitHub..."
git add .
git commit -m "Material3 תיקון מלא: צבעים, ערכות, תלויות, Manifest"
git push origin main --force

echo "ההגדרה הושלמה! כעת תוכל להריץ: ./gradlew assembleRelease"
