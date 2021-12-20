package com.cota.after_corona_api.infra.service;

public interface MessageService {
  void sendSms(String phoneNumber, String message);
}
