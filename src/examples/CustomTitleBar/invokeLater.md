### SwingUtilities.invokeLater(() -> new examples.examples.ClassFileExample.ClassFileExample.CustomTitleBarCopy());

SwingUtilities.invokeLater를 사용하면 Runnable 객체를 이벤트 디스패치 스레드(EDT)에 전달해 뒤늦게 실행하게 합니다. 컴포넌트의 생성과 그래픽 변경사항이 모두 이벤트 디스패치 스레드에서 실행되도록 보장합니다. 이렇게 함으로써 UI 관련 작업이 동기화되어 UI 간섭을 피할 수 있습니다.

<br>

### new examples.examples.ClassFileExample.ClassFileExample.CustomTitleBarCopy();

이 코드는 현재 스레드에서 examples.examples.ClassFileExample.ClassFileExample.CustomTitleBarCopy 객체를 생성하고 실행합니다. 만약 이 코드가 메인 스레드 내에서 호출된다면, 그래픽 변경사항이 EDT가 아닌 메인 스레드에서 실행됩니다. Swing UI의 경우 모든 UI 관련 작업은 이벤트 디스패치 스레드에서 실행되어야 한다는 약속이 있으므로, 이러한 방식은 UI를 업데이트하는 동안 문제가 발생할 수 있습니다.




실행 결과는 비슷할 수 있지만, SwingUtilities.invokeLater를 사용하여 이벤트 디스패치 스레드에서 GUI 작업을 실행하는 것이 권장됩니다. 이렇게 함으로써 Swing 애플리케이션의 안정성과 예측 가능성을 높일 수 있습니다.