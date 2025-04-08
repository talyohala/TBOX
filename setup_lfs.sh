#!/data/data/com.termux/files/usr/bin/bash

# הגדרה בסיסית
echo "== התחלת התקנת Git LFS והגדרות =="
pkg install -y git-lfs
git lfs install

# מסלול לפרויקט
cd ~/MyStreamApp || exit

# הוספת קבצים גדולים לניהול עם LFS
git lfs track "*.jar"
git lfs track "*.zip"
git lfs track "*.keystore"
git lfs track "*.apk"

# הוספת קובץ .gitattributes שנוצר
git add .gitattributes
git commit -m "הוספת ניהול קבצים גדולים עם Git LFS"

# הוספת כל שאר הקבצים ודחיפה
git add .
git commit -m "עדכון מלא עם קבצים גדולים תחת Git LFS"

# דחיפה עם טוקן (שנה לטוקן האמיתי שלך!)
git push https://USERNAME:TOKEN@github.com/USERNAME/TBOX.git main

echo "== סיום! הקבצים הועלו עם LFS =="
