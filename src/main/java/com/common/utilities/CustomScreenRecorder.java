package com.common.utilities;

import org.monte.media.Format;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import org.monte.media.math.Rational;
import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class CustomScreenRecorder extends ScreenRecorder {

    private File movieFolder;
    private File currentMovieFile;

    public CustomScreenRecorder(GraphicsConfiguration cfg, File movieFolder)
            throws IOException, AWTException, IOException {
        super(cfg, new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()),
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
                        Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
                null, movieFolder);
        this.movieFolder = movieFolder;
    }

    @Override
    protected File createMovieFile(Format fileFormat) throws IOException {
        if (!movieFolder.exists()) {
            movieFolder.mkdirs();
        }
        this.currentMovieFile = new File(movieFolder, "Test-" + System.currentTimeMillis() + ".mp4");
        return currentMovieFile;
    }

    @Override
    public void start() throws IOException {
        // Start recording
        super.start();
    }

    @Override
    public void stop() throws IOException {
        // Stop recording
        super.stop();
    }

    public File getVideoFile() {
        return this.currentMovieFile;
    }
}
