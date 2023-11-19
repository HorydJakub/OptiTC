package core;

import enumerates.Priorities;

import java.awt.*;

public abstract class ConstantValues {

    public static final String APP_NAME = "OptiTC";
    public static final String APP_VERSION = "1.0";
    public static final String APP_AUTHOR = "Jakub Horyd";
    public static final String LICENCE = "GNU GPL v3.0";
    public static final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    // New for OptiTC
    public static final String DEFAULT_VALUE_FOR_EMPTY_FIELD = "Please fill out this field!";
    public static final String DEFAULT_VALUE_FOR_PRIORITY_COMBO_BOX = Priorities.MEDIUM.getPriority();
    public static final String DEFAULT_VALUE_FOR_TYPE_COMBO_BOX = "Functional";
}
