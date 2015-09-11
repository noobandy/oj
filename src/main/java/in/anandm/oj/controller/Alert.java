package in.anandm.oj.controller;

/**
 * @className:in.anandm.todo.controller.Alert.java
 * @description:TODO
 * @author anandm
 * @date Aug 14, 2015 11:10:56 AM
 */
public class Alert {

    /**
     * @className:in.anandm.todo.controller.Alert.java
     * @description:TODO
     * @author anandm
     * @date Aug 14, 2015 11:14:45 AM
     */
    private enum AlertType {
        success, error, warning;
    }

    private AlertType type;

    private String message;

    private Alert(AlertType type, String message) {
        this.type = type;
        this.message = message;
    }

    public static final Alert success(String messageCode, Object... args) {
        return null;
    }

    public static final Alert error(String messageCode, Object... args) {
        return null;
    }

    public static final Alert warning(String messageCode, Object... args) {
        return null;
    }
}
