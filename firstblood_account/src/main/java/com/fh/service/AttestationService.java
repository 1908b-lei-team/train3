package com.fh.service;

import com.fh.model.Attestation;
import com.fh.common.ServerResponse;

import javax.servlet.http.HttpServletRequest;

public interface AttestationService {
    ServerResponse realNameAuthentication(Attestation attestation, HttpServletRequest request);

    ServerResponse checkIdNumber(String idNumber);

    ServerResponse queryInfo(HttpServletRequest request);
}
