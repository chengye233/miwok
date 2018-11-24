package com.example.android.miwok;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok translation for that word.
 */
public class Word
{
    /**
     * Default translation for the word
     */
    private String mDefaultTranslation;
    /**
     * Miwok translation for the word
     */
    private String mMiwokTranslation;

    /**
     * 单词图标资源id
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /**
     * 没有单词图标时为-1
     */
    private static final int NO_IMAGE_PROVIDED = -1;


    /**
     * 发音资源id
     */
    private int mSongResourceId = NO_SONG_PROVIDES;

    /**
     * 没有发音资源时为-1
     */
    private static final int NO_SONG_PROVIDES = -1;

    /**
     * 构造函数 发音
     *
     * @param defaultTranslation 原来语言
     * @param miwokTranslation   Miwok语言
     * @param songResourceId     发音资源id
     */
    public Word(String defaultTranslation, String miwokTranslation, int songResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mSongResourceId = songResourceId;
    }

    /**
     * 构造函数 图片&发音
     *
     * @param defaultTranslation 源语言
     * @param miwokTranslation   miwok语言
     * @param imageResourceId    图标资源id
     * @param songResourceId     发音资源id
     */
    public Word(String defaultTranslation, String miwokTranslation,
                int imageResourceId, int songResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mSongResourceId = songResourceId;
    }

    /**
     * Get the default translation of the word.
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get the Miwok translation of the word.
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     * 获取单词图标id
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * 判断是否有图片资源
     *
     * @return true:有图片  false:无图片
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * 获得发音资源id
     */
    public int getSongResourceId() {
        return mSongResourceId;
    }

    /**
     * 判断是否有发音资源
     *
     * @return true:有发音  false:无发音
     */
    public boolean hasSong() {
        return mSongResourceId != NO_SONG_PROVIDES;
    }
}
