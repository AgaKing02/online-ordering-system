package com.CarSaleWebsite.Kolesa.MessageSenders.interfaces;

import com.CarSaleWebsite.Kolesa.DTO.Code;
import com.CarSaleWebsite.Kolesa.DTO.PhoneNumber;
import com.CarSaleWebsite.Kolesa.DTO.SmsRequest;
import com.CarSaleWebsite.Kolesa.DTO.UsernameAndPasswordDTO;

public interface SmsSender {

    void sendSms(SmsRequest smsRequest);

    String sendVerificationCode(PhoneNumber phoneNumber);

    UsernameAndPasswordDTO checkVerificationCode(Code code) throws Exception;
}
