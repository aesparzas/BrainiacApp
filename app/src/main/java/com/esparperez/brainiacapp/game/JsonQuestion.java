package com.esparperez.brainiacapp.game;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonQuestion {

    private String question;
    private String firstOption;
    private String secondOption;
    private String thirdOption;
    private String fourthOption;
    private String answer;

    private String JsonQuestion;
    private String JsonFirstOption;
    private String JsonSecondOption;
    private String JsonThirdOption;
    private String JsonFourthOption;
    private String JsonAnswer;

    public JsonQuestion() {
    }

    public JsonQuestion(String jsonQuestion, String jsonFirstOption, String jsonSecondOption, String jsonThirdOption, String jsonFourthOption, String jsonAnswer) {
        JsonQuestion = jsonQuestion;
        JsonFirstOption = jsonFirstOption;
        JsonSecondOption = jsonSecondOption;
        JsonThirdOption = jsonThirdOption;
        JsonFourthOption = jsonFourthOption;
        JsonAnswer = jsonAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getFirstOption() {
        return firstOption;
    }

    public void setFirstOption(String firstOption) {
        this.firstOption = firstOption;
    }

    public String getSecondOption() {
        return secondOption;
    }

    public void setSecondOption(String secondOption) {
        this.secondOption = secondOption;
    }

    public String getThirdOption() {
        return thirdOption;
    }

    public void setThirdOption(String thirdOption) {
        this.thirdOption = thirdOption;
    }

    public String getFourthOption() {
        return fourthOption;
    }

    public void setFourthOption(String fourthOption) {
        this.fourthOption = fourthOption;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getJsonQuestion() {
        return JsonQuestion;
    }

    public void setJsonQuestion(String jsonQuestion) {
        JsonQuestion = jsonQuestion;
    }

    public String getJsonFirstOption() {
        return JsonFirstOption;
    }

    public void setJsonFirstOption(String jsonFirstOption) {
        JsonFirstOption = jsonFirstOption;
    }

    public String getJsonSecondOption() {
        return JsonSecondOption;
    }

    public void setJsonSecondOption(String jsonSecondOption) {
        JsonSecondOption = jsonSecondOption;
    }

    public String getJsonThirdOption() {
        return JsonThirdOption;
    }

    public void setJsonThirdOption(String jsonThirdOption) {
        JsonThirdOption = jsonThirdOption;
    }

    public String getJsonFourthOption() {
        return JsonFourthOption;
    }

    public void setJsonFourthOption(String jsonFourthOption) {
        JsonFourthOption = jsonFourthOption;
    }

    public String getJsonAnswer() {
        return JsonAnswer;
    }

    public void setJsonAnswer(String jsonAnswer) {
        JsonAnswer = jsonAnswer;
    }

    public JsonQuestion fromJson(JSONObject object) {
        try {
            this.question = object.getString(this.JsonQuestion);
            this.answer = object.getString(this.JsonAnswer);
            this.firstOption = object.getString(this.JsonFirstOption);
            this.secondOption = object.getString(this.JsonSecondOption);
            this.thirdOption = object.getString(this.JsonSecondOption);
            this.fourthOption = object.getString(this.JsonSecondOption);
        } catch (JSONException err) {
            err.printStackTrace();
        }
        return this;
    }
//
//    public void func(){
//        JsonQuestion jsonQuestion = new JsonQuestion("question","first", "second", "third", "fourth", "answer");
//        JSONObject newJson;
//        jsonQuestion = jsonQuestion.fromJson(newJson);
//        jsonQuestion.getAnswer();
//    }
}
