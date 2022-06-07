package com.CarSaleWebsite.Kolesa.Services;

import com.CarSaleWebsite.Kolesa.DTO.Code;
import com.CarSaleWebsite.Kolesa.DTO.PhoneNumber;
import com.CarSaleWebsite.Kolesa.DTO.SmsRequest;
import com.CarSaleWebsite.Kolesa.DTO.UsernameAndPasswordDTO;
import com.CarSaleWebsite.Kolesa.MessageSenders.TwilioSmsSenderService;
import com.CarSaleWebsite.Kolesa.MessageSenders.interfaces.SmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsSenderService {
    private final SmsSender smsSender;

    @Autowired
    public SmsSenderService(TwilioSmsSenderService smsSender) {
        this.smsSender = smsSender;
    }

    public void sendSms(SmsRequest smsRequest) {
        smsSender.sendSms(smsRequest);
    }

    public String sendVerificationCode(PhoneNumber phoneNumber) {
        return smsSender.sendVerificationCode(phoneNumber);
    }

    public UsernameAndPasswordDTO checkVerificationCode(Code code) throws Exception {
        return smsSender.checkVerificationCode(code);
    }

}
