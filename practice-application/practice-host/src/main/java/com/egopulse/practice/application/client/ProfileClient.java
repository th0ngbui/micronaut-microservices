package com.egopulse.practice.application.client;

import io.micronaut.http.client.annotation.Client;

@Client(id = "profile", path = "/profile")
public interface ProfileClient {

}
