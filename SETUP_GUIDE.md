# 🚀 COMPLETE SETUP GUIDE - Azkaar360 App

## 📋 Table of Contents
1. Installation Requirements
2. Android Studio Setup
3. Running the App
4. Troubleshooting
5. Customization Guide

---

## 1️⃣ INSTALLATION REQUIREMENTS

### Required Software:
- **Android Studio** (Latest version - Hedgehog or newer)
  - Download: https://developer.android.com/studio
  - Size: ~1GB
  - Install time: 15-20 minutes

- **Java JDK** (Usually included with Android Studio)
  - JDK 17 or higher

### System Requirements:
- **Windows:** 64-bit, 8GB RAM minimum
- **Mac:** macOS 10.14 or higher
- **Linux:** 64-bit distribution
- **Disk Space:** 10GB free space

---

## 2️⃣ ANDROID STUDIO SETUP

### Step 1: Install Android Studio
```
1. Download Android Studio from official website
2. Run installer
3. Follow installation wizard
4. Choose "Standard" installation
5. Wait for SDK components to download
```

### Step 2: Open Project
```
1. Launch Android Studio
2. Click "Open" or "File → Open"
3. Navigate to Azkaar360 folder
4. Click "OK"
5. Wait for Gradle sync (takes 2-5 minutes first time)
```

### Step 3: Configure SDK
```
1. Go to File → Settings (Windows/Linux) or Android Studio → Preferences (Mac)
2. Navigate to Appearance & Behavior → System Settings → Android SDK
3. Ensure Android 14.0 (API 34) is installed
4. Click "Apply" if you need to download
```

---

## 3️⃣ RUNNING THE APP

### Option A: Run on Physical Device

#### Enable Developer Options:
```
1. Go to phone Settings
2. About Phone
3. Tap "Build Number" 7 times
4. Go back to Settings
5. Find "Developer Options"
6. Enable "USB Debugging"
```

#### Connect and Run:
```
1. Connect phone via USB cable
2. Allow USB debugging on phone popup
3. In Android Studio, select your device from dropdown
4. Click green "Run" button (▶) or press Shift+F10
5. App will install and launch automatically
```

### Option B: Run on Emulator

#### Create Emulator:
```
1. Click "Device Manager" (phone icon) in Android Studio
2. Click "Create Device"
3. Select "Phone" → "Pixel 6" → "Next"
4. Download Android 14.0 (API 34) system image
5. Click "Next" → "Finish"
```

#### Run on Emulator:
```
1. Start emulator from Device Manager
2. Wait for emulator to boot (1-2 minutes)
3. Click green "Run" button (▶)
4. App will install on emulator
```

---

## 4️⃣ TROUBLESHOOTING

### Problem: Gradle Sync Failed
**Solution:**
```
1. File → Invalidate Caches → Invalidate and Restart
2. Or manually sync: File → Sync Project with Gradle Files
3. Check internet connection (Gradle downloads dependencies)
```

### Problem: "SDK not found"
**Solution:**
```
1. File → Project Structure → SDK Location
2. Set Android SDK location to: C:\Users\[YourName]\AppData\Local\Android\Sdk
3. Click "Apply" → "OK"
```

### Problem: Build Errors
**Solution:**
```
1. Build → Clean Project
2. Build → Rebuild Project
3. Make sure all dependencies downloaded
4. Check build.gradle files match provided code
```

### Problem: App Crashes on Start
**Solution:**
```
1. Check Logcat (bottom panel) for error messages
2. Ensure all activities are declared in AndroidManifest.xml
3. Verify all resource files exist in correct folders
4. Try running on different device/emulator
```

### Problem: Location Not Working
**Solution:**
```
1. Grant location permission when app asks
2. For emulator: Set location in emulator settings
3. Check AndroidManifest has location permissions
4. Enable location services on device
```

### Problem: Qibla Compass Not Working
**Solution:**
```
1. Only works on real devices (not emulator)
2. Device must have magnetometer sensor
3. Calibrate compass by moving phone in figure-8
4. Keep phone flat and away from metal objects
```

---

## 5️⃣ CUSTOMIZATION GUIDE

### Change App Name:
Edit `res/values/strings.xml`:
```xml
<string name="app_name">YourAppName</string>
```

### Change App Icon:
```
1. Right-click res folder → New → Image Asset
2. Choose icon type and image
3. Generate all sizes
```

### Add More Azkar:
Edit `AzkarDatabase.java`:
```java
public static List<Azkar> getMorningAzkar() {
    List<Azkar> azkarList = new ArrayList<>();
    
    azkarList.add(new Azkar(
        "بِسْمِ اللَّهِ الرَّحْمَٰنِ الرَّحِيمِ",
        "اللہ کے نام سے جو بڑا مہربان نہایت رحم والا ہے",
        "In the name of Allah, Most Gracious, Most Merciful",
        "Bismillahir-Rahmanir-Rahim",
        1
    ));
    
    return azkarList;
}
```

### Change Theme Colors:
Edit `res/values/colors.xml`:
```xml
<color name="primary_green">#1B5E20</color>
<color name="accent_gold">#FFD700</color>
```

### Add Audio Recitations:
```
1. Create folder: res/raw/
2. Add MP3 files: morning_1.mp3, evening_1.mp3, etc.
3. Update playButton in AzkarDetailActivity.java:

MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.morning_1);
mediaPlayer.start();
```

### Add Notifications:
```java
// In PrayerNotificationReceiver.java
@Override
public void onReceive(Context context, Intent intent) {
    NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "prayer_channel")
        .setSmallIcon(R.drawable.ic_notification)
        .setContentTitle("Prayer Time")
        .setContentText("Time for Fajr prayer")
        .setPriority(NotificationCompat.PRIORITY_HIGH);
    
    NotificationManagerCompat.from(context).notify(1, builder.build());
}
```

---

## 6️⃣ BUILDING APK FOR DISTRIBUTION

### Generate Signed APK:
```
1. Build → Generate Signed Bundle / APK
2. Select "APK" → Next
3. Create new keystore or use existing
4. Fill in keystore details
5. Choose release build variant
6. Click "Create"
7. APK will be in app/release/ folder
```

### Share APK:
```
1. Find APK in: Azkaar360/app/release/app-release.apk
2. Transfer to phone via USB or upload to drive
3. Install on any Android device
4. May need to enable "Install from Unknown Sources"
```

---

## 7️⃣ TESTING CHECKLIST

Before releasing, test:
- [ ] All azkar categories open
- [ ] Arabic text displays correctly (right-to-left)
- [ ] Tasbih counter increments
- [ ] Reset button works
- [ ] Vibration works (on device)
- [ ] Prayer times display
- [ ] Qibla compass rotates (on device)
- [ ] Share button works
- [ ] Copy to clipboard works
- [ ] Bookmark toggles
- [ ] Navigation drawer opens
- [ ] Back button navigation works
- [ ] App doesn't crash on rotation
- [ ] Permissions requested properly

---

## 8️⃣ PERFORMANCE OPTIMIZATION

### Reduce APK Size:
Edit `app/build.gradle`:
```gradle
android {
    buildTypes {
        release {
            minifyEnabled true
            shrinkResources true
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt')
        }
    }
}
```

### Enable R8 Optimization:
Add to `gradle.properties`:
```
android.enableR8.fullMode=true
```

---

## 9️⃣ URDU GUIDE / اردو گائیڈ

### ایپ چلانے کا آسان طریقہ:

**مرحلہ 1: Android Studio انسٹال**
```
1. https://developer.android.com/studio پر جائیں
2. ڈاؤن لوڈ کریں اور انسٹال کریں
```

**مرحلہ 2: پروجیکٹ کھولیں**
```
1. Android Studio کھولیں
2. "Open" پر کلک کریں
3. Azkaar360 فولڈر منتخب کریں
```

**مرحلہ 3: فون سے جوڑیں**
```
1. USB سے فون جوڑیں
2. USB Debugging ON کریں
3. سبز بٹن (▶) دبائیں
```

---

## 🆘 NEED HELP?

### Common Issues:
1. **Gradle Error:** Check internet, rebuild project
2. **SDK Error:** Download Android SDK 34
3. **Crash:** Check Logcat for errors
4. **Location:** Grant permissions in phone settings

### Resources:
- Android Documentation: https://developer.android.com/docs
- Stack Overflow: https://stackoverflow.com/questions/tagged/android
- YouTube Tutorials: Search "Android Studio beginner tutorial"

---

## ✅ SUCCESS INDICATORS

Your setup is successful when:
- ✅ Gradle sync completes without errors
- ✅ No red underlines in code
- ✅ Build succeeds (green checkmark)
- ✅ App installs on device/emulator
- ✅ App launches without crashing
- ✅ All features work as expected

---

**Good Luck! / بہترین قسمت!**

**May your app development journey be successful.**
**آپ کی ایپ ڈویلپمنٹ کا سفر کامیاب ہو۔**
