package com.example.openaiImage.service;

import com.example.openaiImage.entity.ImageRequestDTO;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    private final OpenAiImageModel openAiImageModel; // dall-e-2 기본 이미지 생성 모델

    public ImageService(OpenAiImageModel openAiImageModel) {
        this.openAiImageModel = openAiImageModel;
    }

    public ImageResponse getImageGen(ImageRequestDTO request){
        ImageResponse imageResponse=openAiImageModel
                .call(new ImagePrompt(request.getMessage(),
                        OpenAiImageOptions.builder()
                                .withModel(request.getModel()) // 모델설정
                                .withQuality("hd") // 이미지 품질
                                .withN(request.getN()) // 생성할 이미지 개수
                                .withHeight(1024)
                                .withWidth(1024).build())
                );
       return  imageResponse;
    }
}