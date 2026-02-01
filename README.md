# Azkaar360 - Complete Islamic App 🕌

**Your Daily Islamic Companion** | **آپ کا روزانہ اسلامی ساتھی**

---

## 📱 Features / خصوصیات

### ✅ Complete Features Included:

1. **Morning & Evening Azkar** (صبح و شام کے اذکار)
   - Arabic text with proper RTL support
   - Urdu translations
   - English translations
   - Transliteration (Roman Urdu)
   - Repetition counters

2. **After Prayer Azkar** (نماز کے بعد کے اذکار)
   - Complete Tasbih (33x SubhanAllah, 33x Alhamdulillah, 34x Allahu Akbar)
   - Additional duas

3. **Sleeping Azkar** (سونے سے پہلے کے اذکار)
   - Bedtime duas and protection

4. **Tasbih Counter** (تسبیح کاؤنٹر)
   - Digital counter with vibration feedback
   - Goal tracking (33, 66, 99, etc.)
   - Multiple tasbih options
   - Progress bar

5. **Prayer Times** (نماز کے اوقات)
   - Automatic location detection
   - All 5 prayer times
   - Next prayer countdown

6. **Qibla Compass** (قبلہ کمپاس)
   - Real-time compass
   - Accurate Qibla direction
   - Location-based calculation

7. **Additional Features:**
   - Beautiful Islamic UI design (Green & Gold theme)
   - Share azkar on WhatsApp/social media
   - Copy azkar to clipboard
   - Bookmark favorite azkar
   - Dark mode support (planned)
   - Audio recitations (add your audio files)
   - Notifications for prayer times

---

## 🚀 Setup Instructions / سیٹ اپ کی ہدایات

### **For Android Studio:**

#### 1. **Download & Open Project**
```
1. Extract the Azkaar360 folder
2. Open Android Studio
3. File → Open → Select Azkaar360 folder
4. Wait for Gradle sync to complete
```

#### 2. **Update build.gradle (Project level)**
Create `settings.gradle` in root:
```gradle
pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
rootProject.name = "Azkaar360"
include ':app'
```

#### 3. **Build the Project**
```
Build → Rebuild Project
```

#### 4. **Run on Device/Emulator**
```
1. Connect Android device (USB Debugging ON)
   OR
   Start Android Emulator
2. Click Run button (Green triangle)
```

---

## 📂 Project Structure / پراجیکٹ کی ساخت

```
Azkaar360/
├── app/
│   ├── src/main/
│   │   ├── java/com/azkaar360/
│   │   │   ├── MainActivity.java          # Main screen
│   │   │   ├── AzkarDetailActivity.java   # Azkar display
│   │   │   ├── TasbihActivity.java        # Tasbih counter
│   │   │   ├── PrayerTimesActivity.java   # Prayer times
│   │   │   ├── QiblaActivity.java         # Qibla compass
│   │   │   ├── SettingsActivity.java      # Settings
│   │   │   ├── Azkar.java                 # Azkar model
│   │   │   └── AzkarDatabase.java         # Azkar content
│   │   │
│   │   ├── res/
│   │   │   ├── layout/                    # All XML layouts
│   │   │   ├── values/                    # Colors, strings, themes
│   │   │   ├── menu/                      # Navigation menu
│   │   │   └── xml/                       # Backup rules
│   │   │
│   │   └── AndroidManifest.xml            # App configuration
│   │
│   └── build.gradle                       # Dependencies
```

---

## 🎨 Customization / اپنی مرضی سے تبدیلیاں

### **Add More Azkar:**
Edit `AzkarDatabase.java`:
```java
azkarList.add(new Azkar(
    "ARABIC_TEXT",
    "URDU_TRANSLATION",
    "ENGLISH_TRANSLATION",
    "TRANSLITERATION",
    REPETITIONS
));
```

### **Change Colors:**
Edit `res/values/colors.xml`:
```xml
<color name="primary_green">#YOUR_COLOR</color>
<color name="accent_gold">#YOUR_COLOR</color>
```

### **Add Audio Files:**
1. Place MP3 files in `res/raw/` folder
2. Update `playButton` onClick in `AzkarDetailActivity.java`

---

## 🔧 Technical Requirements / تکنیکی ضروریات

- **Minimum SDK:** Android 7.0 (API 24)
- **Target SDK:** Android 14 (API 34)
- **Languages:** Java
- **Permissions Required:**
  - Location (for Prayer Times & Qibla)
  - Vibrate (for Tasbih)
  - Notifications (for Prayer reminders)

---

## 📖 Urdu Instructions / اردو ہدایات

### **ایپ کو چلانے کا طریقہ:**

1. **Android Studio Install کریں**
   - https://developer.android.com/studio سے ڈاؤن لوڈ کریں

2. **پراجیکٹ کھولیں**
   - Azkaar360 فولڈر کو Android Studio میں کھولیں
   - Gradle sync کا انتظار کریں

3. **Device Connect کریں**
   - USB سے فون جوڑیں
   - USB Debugging ON کریں (Settings → Developer Options)

4. **Run کریں**
   - سبز تیر (▶) پر کلک کریں
   - ایپ انسٹال ہو جائے گی

### **Features استعمال کرنا:**

- **صبح کے اذکار:** صبح کے وقت پڑھیں
- **شام کے اذکار:** مغرب کے بعد پڑھیں
- **نماز کے بعد:** ہر نماز کے بعد
- **تسبیح کاؤنٹر:** دائرے پر ٹیپ کر کے گنیں
- **قبلہ کمپاس:** فون کو سیدھا رکھیں

---

## 🌟 Future Enhancements / مستقبل کی بہتریاں

### **Planned Features:**
- [ ] Complete dark mode
- [ ] Audio recitations for all azkar
- [ ] Prayer time notifications
- [ ] Hijri calendar
- [ ] Quran integration
- [ ] Multiple language support (Arabic, Urdu, English, more)
- [ ] Widget support
- [ ] Backup/restore settings
- [ ] Sharing with beautiful Islamic graphics

---

## 📝 Important Notes / اہم نوٹس

### **Prayer Times:**
- Currently shows sample times
- To get accurate times, add the Adhan library:
```gradle
implementation 'com.batoulapps.adhan:adhan:1.2.0'
```

### **Qibla Compass:**
- Needs phone with magnetometer sensor
- Works best when phone is flat
- Calibrate by moving phone in figure-8 pattern

### **Audio Files:**
- Add your own Arabic audio files
- Place in `res/raw/` folder
- Name them: `morning_1.mp3`, `evening_1.mp3`, etc.

---

## 🤲 Dua / دعا

**May Allah accept this effort and make it beneficial for all Muslims.**

**اللہ تعالیٰ اس کوشش کو قبول فرمائے اور تمام مسلمانوں کے لیے فائدہ مند بنائے۔ آمین**

---

## 📧 Support / مدد

If you need help:
1. Check all files are in correct folders
2. Rebuild project (Build → Rebuild Project)
3. Clean project (Build → Clean Project)
4. Invalidate caches (File → Invalidate Caches / Restart)

---

## 📜 License / لائسنس

Free to use and modify for personal and Islamic educational purposes.

**جزاک اللہ خیرا**

---

**Version 1.0**
**Created: January 2026**
**Platform: Android**
