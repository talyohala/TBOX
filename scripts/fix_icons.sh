#!/bin/bash

echo "==> שלב 1: מחיקת אייקונים ישנים מהפרויקט וה־Git..."
find app/src/main/res/ -type f -name "ic_launcher*" -exec git rm --cached -f {} \; -exec rm -f {} \;

echo "==> שלב 2: העתקת אייקונים מתיקיית res..."
SOURCE_DIR="$HOME/storage/downloads/res"
cp -r "$SOURCE_DIR"/mipmap-* app/src/main/res/ || { echo "שגיאה: לא נמצאו תיקיות mipmap"; exit 1; }

echo "==> שלב 3: בדיקת תקינות הקבצים (שזה PNG)..."
for f in app/src/main/res/mipmap-*/ic_launcher*.png; do
    file "$f" | grep -q 'PNG image data' || { echo "שגיאה: הקובץ '$f' אינו PNG תקני!"; exit 1; }
done

echo "==> שלב 4: הוספה ל־Git..."
git add -f app/src/main/res/mipmap-*/ic_launcher*.png

echo "==> שלב 5: ביצוע Commit ודחיפה..."
git commit -m "עדכון אייקונים תקינים מתוך תיקיית res"
git push

echo "==> הצלחה! האייקונים עודכנו ונשלחו ל־GitHub."
