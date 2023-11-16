package com.printifyproject.printifyapi.api;

import com.printifyproject.printifyapi.upload.PagedImages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ApiUploadTest {
    ApiUpload apiUpload;

    @BeforeEach
    void setUp() {
        Logger logger = LogManager.getLogger();
        apiUpload = new ApiUpload(logger);
    }
    @Test
    void archiveUploadedImage() {
    }

    @Test
    void getUploadedImage() {

    }

    @Test
    void getUploads() {
        PagedImages pagedImages = apiUpload.GetUploads();
    }

    @Test
    void uploadImage() {
    }

    @Test
    void testUploadImage() {
    }
}