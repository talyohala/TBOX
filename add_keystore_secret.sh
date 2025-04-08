#!/bin/bash

KEYSTORE_FILE="my-release-key.jks"
SECRET_NAME="KEYSTORE_BASE64"

if [ ! -f "$KEYSTORE_FILE" ]; then
  echo "קובץ keystore '$KEYSTORE_FILE' לא נמצא בתיקייה הנוכחית."
  exit 1
fi

# קידוד base64
ENCODED=$(base64 -w 0 "$KEYSTORE_FILE")

# יצירת הסוד דרך GitHub CLI
gh secret set "$SECRET_NAME" -b"$ENCODED"

echo "הסוד '$SECRET_NAME' נוסף לריפו שלך בהצלחה!"
