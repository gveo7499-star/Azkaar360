package com.azkaar360;

public class Azkar {
    private String arabic;
    private String urdu;
    private String english;
    private String transliteration;
    private int repetitions;
    private String audioFile;
    private boolean isBookmarked;

    public Azkar(String arabic, String urdu, String english, String transliteration, int repetitions) {
        this.arabic = arabic;
        this.urdu = urdu;
        this.english = english;
        this.transliteration = transliteration;
        this.repetitions = repetitions;
        this.isBookmarked = false;
    }

    // Getters and Setters
    public String getArabic() { return arabic; }
    public void setArabic(String arabic) { this.arabic = arabic; }

    public String getUrdu() { return urdu; }
    public void setUrdu(String urdu) { this.urdu = urdu; }

    public String getEnglish() { return english; }
    public void setEnglish(String english) { this.english = english; }

    public String getTransliteration() { return transliteration; }
    public void setTransliteration(String transliteration) { this.transliteration = transliteration; }

    public int getRepetitions() { return repetitions; }
    public void setRepetitions(int repetitions) { this.repetitions = repetitions; }

    public String getAudioFile() { return audioFile; }
    public void setAudioFile(String audioFile) { this.audioFile = audioFile; }

    public boolean isBookmarked() { return isBookmarked; }
    public void setBookmarked(boolean bookmarked) { isBookmarked = bookmarked; }
}
