package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars = new ArrayList<>();
    private final int playCount;

    public RacingGame(String carNamesInput, String playCountInput){
        checkCarNames(carNamesInput);
        checkPlayCount(playCountInput);

        for (String name : carNamesInput.split(",")) {
            cars.add(new Car(name.trim()));
        }
        this.playCount = Integer.parseInt(playCountInput);
    }

    /* 자동차 경주 실행 */
    public void play() {
        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < playCount; i++){
            race();
            printRaceResult();
            System.out.println();
        }

        printWinners();
    }

    /* 각 자동차 이동 여부 결정 */
    private void race() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                car.move();
            }
        }
    }

    private void printRaceResult() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getShowPosition());
        }
    }

    /* 최종 우승자 계산 */
    private List<String> getWinners() {
        List<String> winners = new ArrayList<>();

        // 1. 가장 많이 이동한 거리 찾기
        int maxPosition = 0;
        for (Car car : cars) {
            if(car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        // 2. 최대 거리와 같은 자동차 이름만 winners 리스트에 추가
        for (Car car : cars) {
            if(car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private void printWinners() {
        List<String> winners = getWinners();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    /* 자동차 이름 입력값 검증 */
    private void checkCarNames(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름이 비어있습니다.");
        }

        String[] names = input.split(",");
        for (String name : names) {
            String nameTrimmed = name.trim();

            if (nameTrimmed.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 빈 이름이 포함되어 있습니다.");
            }

            if (nameTrimmed.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    /* 시도 횟수 입력값 검증 */
    private void checkPlayCount(String input){
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수가 비어있습니다.");
        }

        if (!isInteger(input)) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 정수여야 합니다.");
        }

        int number = Integer.parseInt(input);
        if (number <= 0) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 1 이상이어야 합니다.");
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
