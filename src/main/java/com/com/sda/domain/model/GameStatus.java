package com.com.sda.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
public class GameStatus {
    private String name;
    private String pharse;
    private Character[] pharseState;
    private Integer maxAttempts;
    private Integer successAttempts;
    private Integer failedAttempts;
    private List<Character> history;

    public GameStatus(String name, String pharse, Integer maxAttempts) {
        this.name = name;
        this.pharse = pharse;
        this.pharseState = new GameStatusHepler().preparePharseState(pharse);
        this.maxAttempts = maxAttempts;
        this.successAttempts = 0;
        this.failedAttempts = 0;
        this.history = new ArrayList<>();
    }

    public boolean isGameFinished() {
        for (Character character : pharseState) {
            if (character == null) {
                return false;
            }
        }
        return true;
    }

    public void incrementFailueCounter() {
        failedAttempts++;
    }

    public void incrementSuccessCounter() {
        successAttempts++;
    }

    public void updatehHistory(char letter) {
        history.add(letter);

    }


    public boolean historyContains(char letter) {
        return history.contains(letter);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPharse() {
        return pharse;
    }

    public void setPharse(String pharse) {
        this.pharse = pharse;
    }

    public Character[] getPharseState() {
        return pharseState;
    }

    public void setPharseState(Character[] pharseState) {
        this.pharseState = pharseState;
    }

    public Integer getSuccessAttempts() {
        return successAttempts;
    }

    public void setSuccessAttempts(Integer successAttempts) {
        this.successAttempts = successAttempts;
    }

    public Integer getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(Integer failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    public List<Character> getHistory() {
        return history;
    }

    public void setHistory(List<Character> history) {
        this.history = history;
    }


    public static class GameStatusHepler {
        public Character[] preparePharseState(String pharse) {
            char[] chars = pharse.toCharArray();
            Character[] result = new Character[chars.length];
            for (int i = 0; i < chars.length; i++) {
                if (!Character.isLetter(chars[i])) {
                    result[i] = chars[i];
                }

            }

            return result;
        }


    }
}
