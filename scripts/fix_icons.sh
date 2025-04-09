#!/bin/bash
echo "ניקוי מטמון Git של קבצי האייקון..."
git rm --cached -r app/src/main/res/mipmap-*/ic_launcher*.png

echo "ביצוע שינוי קל בקבצים כדי לאלץ את Git להבחין..."
for f in app/src/main/res/mipmap-*/ic_launcher*.png; do
  echo "" >> "$f"
done

echo "הוספה מחודשת של הקבצים ל-Git..."
git add -f app/src/main/res/mipmap-*/ic_launcher*.png

echo "ביצוע commit..."
git commit -m "תיקון קבצי האייקונים והכרחת Git לזהות שינוי"

echo "שליחת השינויים ל-GitHub..."
git push
