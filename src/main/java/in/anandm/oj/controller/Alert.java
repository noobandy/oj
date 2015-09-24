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

    private Object[] args;

    private Alert(AlertType type, String message, Object[] args) {
        this.type = type;
        this.message = message;
        if (args == null) {
            args = new Object[0];
        }
        this.args = args;
    }

    public static final Alert success(String messageCode, Object... args) {

        return new Alert(AlertType.success, messageCode, args);
    }

    public static final Alert error(String messageCode, Object... args) {
        return new Alert(AlertType.error, messageCode, args);
    }

    public static final Alert warning(String messageCode, Object... args) {
        return new Alert(AlertType.warning, messageCode, args);
    }

    public AlertType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public Object[] getArgs() {
        return args;
    }

}
