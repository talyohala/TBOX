#!/bin/bash

echo "== מנקה את ההיסטוריה מכל קובץ עם מידע רגיש (.git-credentials) =="

git filter-branch --force --index-filter \
  "git rm --cached --ignore-unmatch .git-credentials" \
  --prune-empty --tag-name-filter cat -- --all

rm -rf .git/refs/original/
git reflog expire --expire=now --all
git gc --prune=now --aggressive

echo "== סיום, עכשיו תוכל לדחוף עם --force =="
