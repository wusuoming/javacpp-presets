package org.bytedeco.javacpp.presets;

import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.Properties;
import org.bytedeco.javacpp.tools.InfoMap;
import org.bytedeco.javacpp.tools.InfoMapper;

@Properties(
    inherit = {opencv_core.class,opencv_imgproc.class},
    value = {
        @Platform(
            include = {"<opencv2/freetype.hpp>"},
            link = "opencv_freetype@.3.4"
        ),
        @Platform(value = "ios", preload = "libopencv_freetype"),
        @Platform(value = "windows", link = "opencv_freetype342")
    },
    target = "org.bytedeco.javacpp.opencv_freetype"
)
public class opencv_freetype implements InfoMapper {
    @Override
    public void map(InfoMap infoMap) {

    }
}