package com.fh.service;

import com.fh.model.Attestation;
import com.fh.common.ServerResponse;

public interface AttestationService {
    ServerResponse realNameAuthentication(Attestation attestation);

    ServerResponse checkIdNumber(String idNumber);

    ServerResponse queryInfo();
}
