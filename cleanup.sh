cd ~/TBOXApp

# שלב 1: מחיקת קבצים רגישים מההיסטוריה (כולל בכוח)
git filter-repo --path .git-credentials --path local.properties --invert-paths --force

# שלב 2: הסרת והוספת ה־remote מחדש
git remote remove origin
git remote add origin https://github.com/talyohala/TBOX.git

# שלב 3: לוודא שהקבצים לא ייכנסו שוב לגרסה הבאה
echo "local.properties" >> .gitignore
echo ".git-credentials" >> .gitignore
git add .gitignore
git commit -m "הוספת קבצים רגישים ל-.gitignore"

# שלב 4: דחיפה בכוח ל־GitHub
git push origin main --force
