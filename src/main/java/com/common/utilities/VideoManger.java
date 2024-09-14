package com.common.utilities;

import org.apache.commons.io.FileUtils;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class VideoManger {
    private static CustomScreenRecorder videoRecorder;

    public static void startVideoRecording() throws IOException, AWTException {
        // Initialize videoRecorder
        GraphicsConfiguration cfg = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
                .getDefaultConfiguration();
        File movieFolder = new File("src/test/resources/Videos");
        videoRecorder = new CustomScreenRecorder(cfg, movieFolder);
        videoRecorder.start();
    }

    public static void stopVideoRecording(String scenarioName) {
        try {
            videoRecorder.stop();
            File videoFile = ((CustomScreenRecorder) videoRecorder).getVideoFile();

            if (videoFile != null && videoFile.exists()) {
                String saveDirectory = "src/test/resources/Videos"; // Directory where videos will be saved
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//                String randomString = UUID.randomUUID().toString().substring(0, 3);
                File videoDir = new File(saveDirectory);

                if (!videoDir.exists()) {
                    videoDir.mkdirs(); // Create directory if it doesn't exist
                }

                File newVideoFile = new File(videoDir, "VID_" + timestamp + ".mp4");
                FileUtils.moveFile(videoFile, newVideoFile); // Move the recorded video to the new location

                System.out.println("Video saved at: " + newVideoFile.getAbsolutePath());
            } else {
                System.out.println("Recorded video file does not exist: " + videoFile);
            }
        } catch (IOException e) {
            System.out.println("Error while stopping or saving video recording: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error while stopping video recording: " + e.getMessage());
        }
    }

}