package video.movieous.media.demo.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import video.movieous.engine.UVideoSaveListener;
import video.movieous.engine.core.env.FitViewHelper;
import video.movieous.media.demo.R;
import video.movieous.media.demo.activity.base.BaseEditActivity;
import video.movieous.media.demo.utils.UriUtil;
import video.movieous.shortvideo.UMediaUtil;
import video.movieous.shortvideo.USticker;
import video.movieous.shortvideo.UVideoEditManager;
import video.movieous.engine.view.UTextureView;

/**
 * VideoEditActivity
 */
public class VideoEditActivity extends BaseEditActivity implements UVideoSaveListener {
    private static final String TAG = "VideoEditActivity";
    private static final int REQUEST_CODE_CHOOSE_MUSIC = 2;
    public static final String VIDEO_PATH = "video_path";

    private static final String OUT_FILE = "/sdcard/movieous/shortvideo/video_edit_test.mp4";
    private static final String MV_FILE = "/sdcard/movieous/shortvideo/mv/mv_overlay.mp4"; //"android.resource://video.movieous.media.demo/" + R.raw.mv_overlay;

    private UTextureView mRenderView;
    private ImageView mPreviewImage;
    private Button mRecordButton;
    private Button mSaveButton;
    private TextView mTvTip;
    private ImageButton mPlayButton;

    private UVideoEditManager mVideoEditManager;
    private USticker mSticker;
    private USticker mTextSticker;
    private long mStartTime;
    private boolean mTouchingTextureView;
    protected VideoEditorState mEditorState = VideoEditorState.Idle;

    protected enum VideoEditorState {
        Idle,
        Playing,
        Paused,
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        mVideoFile = getIntent().getStringExtra(VIDEO_PATH);
        if (TextUtils.isEmpty(mVideoFile)) {
            startVideoSelectActivity(this);
        } else {
            getVideoFile(mVideoFile);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mVideoEditManager != null) {
            startPlayback();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mVideoEditManager != null) {
            pausePlayback();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mVideoEditManager != null) {
            stopPlayback();
            mVideoEditManager.release();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_CHOOSE_MUSIC) {
            String selectedFilepath = UriUtil.getPath(this, data.getData());
            Log.i(TAG, "Select file: " + selectedFilepath);
            if (selectedFilepath != null && !"".equals(selectedFilepath)) {
                mVideoEditManager.setMusicFile(selectedFilepath);
                mVideoEditManager.setMusicPositionMs(60 * 1000);
                mVideoEditManager.setOriginVolume(0);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initView() {
        setContentView(R.layout.activity_video_edit);
        mRenderView = $(R.id.render_view);
        mPreviewImage = $(R.id.preview_image);
        mRecordButton = $(R.id.record);
        mTvTip = $(R.id.tv_tip);
        mPlayButton = $(R.id.pause_playback);
        mSaveButton = $(R.id.save);
        mRenderView.setScaleType(FitViewHelper.ScaleType.CENTER_CROP);

        $(R.id.capture).setOnClickListener(view -> mVideoEditManager.captureVideoFrame(bitmap -> runOnUiThread(() -> mPreviewImage.setImageBitmap(bitmap))));

        $(R.id.pause_playback).setOnClickListener(v -> {
            v.setEnabled(false);
            if (mVideoEditManager.isPlaying()) {
                pausePlayback();
            } else {
                startPlayback();
            }
            v.setEnabled(true);
        });

        // 说明：编辑保存文件包含两种模式：
        // 1、离屏渲染，推荐 保存的处理操作和当前预览是分开的，速度更快
        // 2、直接录制当前预览画面显示的内容，可以分别摘取多个片段，然后进行合成保存，适用于边看边录制的模式
        mSaveButton.setOnClickListener(v -> {
            v.setEnabled(false);
            if (v.getTag() != null) {
                cancelSave();
            } else {
                v.setTag(1);
                mSaveButton.setText("取消");
                saveVideo();
            }
            v.setEnabled(true);
        });

        mRecordButton.setOnClickListener(v -> {
            if (mVideoEditManager.isRecording()) {
                stopRecording();
            } else {
                startRecording();
            }
        });

        $(R.id.combine).setOnClickListener(v -> combineClip());

        // for 文字演示
        mRenderView.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    mTouchingTextureView = true;
                    startPlayback();
                    mSticker = new USticker(USticker.StickerType.TEXT);
                    mSticker.init()
                            .setText("哈哈哈哈", 20, Color.RED)
                            .setPosition(Math.round(event.getX() * mSticker.getWidth() * 1f / mRenderView.getWidth()),
                                    Math.round(event.getY() * mSticker.getHeight() * 1f / mRenderView.getHeight()))
                            .setAngle(45);
                    mVideoEditManager.addSticker(mSticker);
                    mSticker.start();
                    break;
                case MotionEvent.ACTION_MOVE:
                    mSticker.setPosition(Math.round(event.getX() * mSticker.getWidth() * 1f / mRenderView.getWidth()),
                            Math.round(event.getY() * mSticker.getHeight() * 1f / mRenderView.getHeight()));
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    mTouchingTextureView = false;
                    pausePlayback();
                    mSticker.pause();
                    break;
            }
            return true;
        });

        // 背景音乐演示
        $(R.id.add_music).setOnClickListener(v -> {
            Intent intent = new Intent();
            if (Build.VERSION.SDK_INT < 19) {
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("audio/*");
            } else {
                intent.setAction(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("audio/*");
            }
            startActivityForResult(Intent.createChooser(intent, "请选择音乐文件："), REQUEST_CODE_CHOOSE_MUSIC);
        });

        // 文字
        $(R.id.add_text).setOnClickListener(view -> demoText());

        // MV
        $(R.id.add_mv_file).setTag(0);
        $(R.id.add_mv_file).setEnabled(false);
        $(R.id.add_mv_file).setOnClickListener(view -> {
            if ((Integer) view.getTag() == 0) {
                view.setTag(1);
                //mVideoEditManager.setOverlayVideoFile(MV_FILE);
            } else {
                view.setTag(0);
               // mVideoEditManager.setOverlayVideoFile(null);
            }
        });

    }

    private void initVideoEditManager() {
        mVideoEditManager = new UVideoEditManager();
        mVideoEditManager.setVideoFrameListener(this);
        mVideoEditManager.init(mRenderView, mVideoFile);
    }

    private void startPlayback() {
        if (mEditorState == VideoEditorState.Playing) return;
        if (mEditorState == VideoEditorState.Idle) {
            mVideoEditManager.setVideoFrameListener(this);
            mVideoEditManager.start();
            mEditorState = VideoEditorState.Playing;
            Log.i(TAG, "startPlayback: start");
        } else if (mEditorState == VideoEditorState.Paused) {
            mVideoEditManager.resume();
            Log.i(TAG, "startPlayback: resume");
            mEditorState = VideoEditorState.Playing;
        }
        setPlayButtonState(R.drawable.btn_pause);
    }

    private void stopPlayback() {
        if (mEditorState == VideoEditorState.Idle) return;
        mVideoEditManager.stop();
        mEditorState = VideoEditorState.Idle;
        setPlayButtonState(R.drawable.btn_play);
    }

    private void pausePlayback() {
        if (mEditorState == VideoEditorState.Playing) {
            mVideoEditManager.pause();
            mEditorState = VideoEditorState.Paused;
            setPlayButtonState(R.drawable.btn_play);
        }
    }

    private void setPlayButtonState(int resId) {
        if (mPlayButton == null) return;
        runOnUiThread(() -> mPlayButton.setImageResource(resId));
    }

    private void startRecording() {
        mRecordButton.setText("停止");
        if (mVideoEditManager != null) {
            mVideoEditManager.startRecording();
        }
    }

    private void stopRecording() {
        mRecordButton.setText("录制");
        if (mVideoEditManager != null) {
            mVideoEditManager.stopRecording();
        }
    }

    private void combineClip() {
        if (mVideoEditManager != null) {
            mStartTime = System.currentTimeMillis();
            mVideoEditManager.combineClip(OUT_FILE, this);
        }
    }

    @Override
    protected void getVideoFile(String file) {
        mVideoFile = file;
        initVideoEditManager();
        startPlayback();
    }

    private void demoText() {
        startPlayback();
        if (mTextSticker == null) {
            addText();
        } else {
            removeText();
        }
    }

    private void addText() {
        mTextSticker = new USticker(USticker.StickerType.TEXT);
        mTextSticker.init()
                .setText("这是一个美丽的传说", 20, Color.RED)
                .setDuration(0, (int) UMediaUtil.getMetadata(mVideoFile).duration)
                .setPosition(50, 500);
        mVideoEditManager.addSticker(mTextSticker);
    }

    private void removeText() {
        mVideoEditManager.removeSticker(mTextSticker);
        mTextSticker = null;
    }


    private void cancelSave() {
        mVideoEditManager.cancelSave();
    }

    private void saveVideo() {
        stopPlayback();
        mStartTime = System.currentTimeMillis();
        mVideoEditManager.setVideoSaveListener(this);
        mVideoEditManager.save(OUT_FILE);
    }

    @Override
    public void onVideoSaveProgress(float progress) {
        @SuppressLint("DefaultLocale")
        String msg = String.format("%.1f", progress * 100) + "%";
        runOnUiThread(() -> mTvTip.setText(msg));
    }

    @Override
    public void onVideoSaveSuccess(String path) {
        Log.i(TAG, "onVideoSaveSuccess: " + path);
        String msg = "耗时：" + (System.currentTimeMillis() - mStartTime) / 1000 + " 秒";
        runOnUiThread(() -> {
            mTvTip.setText(msg);
            mSaveButton.setText("保存");
            mSaveButton.setTag(null);
        });
    }

    @Override
    public void onVideoSaveCancel() {
        Log.i(TAG, "onVideoSaveCancel");
        runOnUiThread(() -> {
            mSaveButton.setText("保存");
            mSaveButton.setTag(null);
            mTvTip.setText("已取消");
        });
    }
}
