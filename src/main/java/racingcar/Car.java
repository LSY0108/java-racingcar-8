package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    /* 자동차 전진 */
    public void move() {
        position++;
    }

    /* 자동차 이름 반환 */
    public String getName() {
        return name;
    }

    /* 현재 위치 반환 */
    public int getPosition() {
        return position;
    }

    /* 자동차 이동 거리 표현 */
    public String getShowPosition() {
        return "-".repeat(position);
    }
}
