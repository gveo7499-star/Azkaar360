package com.azkaar360;

import java.util.ArrayList;
import java.util.List;

public class AzkarDatabase {

    public static List<Azkar> getMorningAzkar() {
        List<Azkar> azkarList = new ArrayList<>();
        
        azkarList.add(new Azkar(
            "أَعُوذُ بِاللَّهِ مِنَ الشَّيْطَانِ الرَّجِيمِ ۝ اللَّهُ لَا إِلَٰهَ إِلَّا هُوَ الْحَيُّ الْقَيُّومُ ۚ لَا تَأْخُذُهُ سِنَةٌ وَلَا نَوْمٌ",
            "میں شیطان مردود سے اللہ کی پناہ مانگتا ہوں۔ اللہ! اس کے سوا کوئی معبود نہیں، وہ زندہ ہے، سب کا تھامنے والا ہے",
            "I seek refuge with Allah from Satan the outcast. Allah - there is no deity except Him, the Ever-Living, the Sustainer of existence",
            "A'udhu billahi min ash-shaytan ir-rajim. Allahu la ilaha illa Huwa, Al-Hayyul-Qayyum",
            1
        ));
        
        azkarList.add(new Azkar(
            "بِسْمِ اللَّهِ الرَّحْمَٰنِ الرَّحِيمِ ۝ قُلْ هُوَ اللَّهُ أَحَدٌ ۝ اللَّهُ الصَّمَدُ ۝ لَمْ يَلِدْ وَلَمْ يُولَدْ ۝ وَلَمْ يَكُنْ لَهُ كُفُوًا أَحَدٌ",
            "شروع اللہ کے نام سے جو بڑا مہربان نہایت رحم والا ہے۔ کہہ دو وہ اللہ ایک ہے",
            "Say: He is Allah, the One and Only. Allah, the Eternal, Absolute. He begetteth not, nor is He begotten. And there is none like unto Him",
            "Qul Huwa Allahu Ahad. Allahu Samad. Lam yalid wa lam yulad. Wa lam yakul lahu kufuwan ahad",
            3
        ));
        
        azkarList.add(new Azkar(
            "أَصْبَحْنَا وَأَصْبَحَ الْمُلْكُ لِلَّهِ، وَالْحَمْدُ لِلَّهِ",
            "ہم نے صبح کی اور ساری بادشاہی اللہ کی ہے، اور تمام تعریفیں اللہ کے لیے ہیں",
            "We have reached the morning and with it all dominion is Allah's, and all praise is for Allah",
            "Asbahna wa asbahal-mulku lillah, walhamdu lillah",
            1
        ));
        
        azkarList.add(new Azkar(
            "اللَّهُمَّ إِنِّي أَصْبَحْتُ أُشْهِدُكَ، وَأُشْهِدُ حَمَلَةَ عَرْشِكَ، وَمَلَائِكَتَكَ، وَجَمِيعَ خَلْقِكَ، أَنَّكَ أَنْتَ اللَّهُ لَا إِلَٰهَ إِلَّا أَنْتَ وَحْدَكَ لَا شَرِيكَ لَكَ",
            "اے اللہ! میں نے صبح کی اور میں تجھے گواہ بناتا ہوں اور تیرے عرش کو اٹھانے والوں کو اور تیرے فرشتوں کو",
            "O Allah, I have reached the morning and call on You and the bearers of Your Throne, Your angels and all creation to witness",
            "Allahumma inni asbahtu ushhiduka, wa ushhidu hamalata 'arshika, wa mala'ikataka",
            4
        ));
        
        azkarList.add(new Azkar(
            "سُبْحَانَ اللَّهِ وَبِحَمْدِهِ",
            "اللہ پاک ہے اور اس کی تعریف کے ساتھ",
            "Glory is to Allah and praise is to Him",
            "Subhan-Allahi wa bihamdihi",
            100
        ));
        
        return azkarList;
    }

    public static List<Azkar> getEveningAzkar() {
        List<Azkar> azkarList = new ArrayList<>();
        
        azkarList.add(new Azkar(
            "أَمْسَيْنَا وَأَمْسَى الْمُلْكُ لِلَّهِ، وَالْحَمْدُ لِلَّهِ",
            "ہم نے شام کی اور ساری بادشاہی اللہ کی ہے",
            "We have reached the evening and with it all dominion is Allah's",
            "Amsayna wa amsal-mulku lillah, walhamdu lillah",
            1
        ));
        
        azkarList.add(new Azkar(
            "اللَّهُمَّ بِكَ أَمْسَيْنَا، وَبِكَ أَصْبَحْنَا، وَبِكَ نَحْيَا، وَبِكَ نَمُوتُ، وَإِلَيْكَ الْمَصِيرُ",
            "اے اللہ! تیرے سہارے ہم نے شام کی اور تیرے سہارے صبح کریں گے",
            "O Allah, by You we have reached the evening and by You we have reached the morning",
            "Allahumma bika amsayna, wa bika asbahna, wa bika nahya",
            1
        ));
        
        azkarList.add(new Azkar(
            "بِسْمِ اللَّهِ الرَّحْمَٰنِ الرَّحِيمِ ۝ قُلْ أَعُوذُ بِرَبِّ الْفَلَقِ",
            "کہہ دو میں پناہ مانگتا ہوں صبح کے رب کی",
            "Say: I seek refuge with the Lord of the daybreak",
            "Qul a'udhu bi Rabbil-falaq",
            3
        ));
        
        azkarList.add(new Azkar(
            "سُبْحَانَ اللَّهِ وَبِحَمْدِهِ عَدَدَ خَلْقِهِ، وَرِضَا نَفْسِهِ، وَزِنَةَ عَرْشِهِ، وَمِدَادَ كَلِمَاتِهِ",
            "اللہ پاک ہے اس کی مخلوق کی تعداد کے برابر، اس کی رضا کے برابر",
            "Glory is to Allah and praise to Him, by the number of His creation and His pleasure",
            "Subhan-Allahi wa bihamdihi adada khalqihi wa ridha nafsihi",
            3
        ));
        
        return azkarList;
    }

    public static List<Azkar> getAfterPrayerAzkar() {
        List<Azkar> azkarList = new ArrayList<>();
        
        azkarList.add(new Azkar(
            "أَسْتَغْفِرُ اللَّهَ",
            "میں اللہ سے بخشش مانگتا ہوں",
            "I seek Allah's forgiveness",
            "Astaghfirullah",
            3
        ));
        
        azkarList.add(new Azkar(
            "اللَّهُمَّ أَنْتَ السَّلَامُ وَمِنْكَ السَّلَامُ، تَبَارَكْتَ يَا ذَا الْجَلَالِ وَالْإِكْرَامِ",
            "اے اللہ! تو ہی سلامتی ہے اور تجھ ہی سے سلامتی ہے",
            "O Allah, You are Peace and from You comes peace. Blessed are You, O Possessor of Majesty and Honor",
            "Allahumma antas-salam wa minkas-salam, tabarakta ya dhal-jalali wal-ikram",
            1
        ));
        
        azkarList.add(new Azkar(
            "سُبْحَانَ اللَّهِ",
            "اللہ پاک ہے",
            "Glory be to Allah",
            "Subhan Allah",
            33
        ));
        
        azkarList.add(new Azkar(
            "الْحَمْدُ لِلَّهِ",
            "تمام تعریفیں اللہ کے لیے ہیں",
            "All praise is due to Allah",
            "Alhamdulillah",
            33
        ));
        
        azkarList.add(new Azkar(
            "اللَّهُ أَكْبَرُ",
            "اللہ سب سے بڑا ہے",
            "Allah is the Greatest",
            "Allahu Akbar",
            34
        ));
        
        azkarList.add(new Azkar(
            "لَا إِلَٰهَ إِلَّا اللَّهُ وَحْدَهُ لَا شَرِيكَ لَهُ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ وَهُوَ عَلَىٰ كُلِّ شَيْءٍ قَدِيرٌ",
            "اللہ کے سوا کوئی معبود نہیں، وہ اکیلا ہے، اس کا کوئی شریک نہیں",
            "There is no deity except Allah, alone without partner. To Him belongs dominion and to Him belongs praise",
            "La ilaha illallah wahdahu la sharika lah, lahul-mulku wa lahul-hamd",
            1
        ));
        
        return azkarList;
    }

    public static List<Azkar> getSleepingAzkar() {
        List<Azkar> azkarList = new ArrayList<>();
        
        azkarList.add(new Azkar(
            "بِاسْمِكَ اللَّهُمَّ أَمُوتُ وَأَحْيَا",
            "اے اللہ! تیرے نام کے ساتھ میں مرتا ہوں اور جیتا ہوں",
            "In Your name, O Allah, I die and I live",
            "Bismika Allahumma amutu wa ahya",
            1
        ));
        
        azkarList.add(new Azkar(
            "اللَّهُمَّ إِنِّي أَسْلَمْتُ نَفْسِي إِلَيْكَ، وَفَوَّضْتُ أَمْرِي إِلَيْكَ",
            "اے اللہ! میں نے اپنے آپ کو تیرے حوالے کر دیا",
            "O Allah, I submit myself to You and entrust my affairs to You",
            "Allahumma inni aslamtu nafsi ilayka, wa fawwadtu amri ilayka",
            1
        ));
        
        azkarList.add(new Azkar(
            "الْحَمْدُ لِلَّهِ الَّذِي أَطْعَمَنَا وَسَقَانَا، وَكَفَانَا، وَآوَانَا",
            "تمام تعریفیں اللہ کے لیے ہیں جس نے ہمیں کھلایا اور پلایا",
            "Praise is to Allah Who has fed us and given us drink, and Who is sufficient for us",
            "Alhamdulillahil-ladhi at'amana wa saqana, wa kafana wa awana",
            1
        ));
        
        return azkarList;
    }
}
