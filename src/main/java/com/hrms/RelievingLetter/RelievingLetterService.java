package com.hrms.RelievingLetter;

import java.io.ByteArrayOutputStream;

public interface RelievingLetterService {
    ByteArrayOutputStream generateRelievingLetterPdf(RelievingLetter letter) throws Exception;
}
