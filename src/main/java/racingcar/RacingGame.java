package racingcar;

public class RacingGame {

    public RacingGame(String carNameInput, String playCountInput){
        checkCarNames(carNameInput);
        checkPlayCount(playCountInput);
    }

    /* 자동차 이름 입력값 검증 */
    private void checkCarNames(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("자동차 이름이 비어있습니다.");
        }

        String[] names = input.split(",");
        for (String name : names) {
            String nameTrimmed = name.trim();

            if (nameTrimmed.isEmpty()) {
                throw new IllegalArgumentException("빈 이름이 포함되어 있습니다.");
            }

            if (nameTrimmed.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    /* 시도 횟수 입력값 검증 */
    private void checkPlayCount(String input){
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("시도 횟수가 비어있습니다.");
        }

        if (!isInteger(input)) {
            throw new IllegalArgumentException("시도 횟수는 정수여야 합니다.");
        }

        int number = Integer.parseInt(input);
        if (number <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    /* 시도 횟수 정수인지 검증 */
    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
