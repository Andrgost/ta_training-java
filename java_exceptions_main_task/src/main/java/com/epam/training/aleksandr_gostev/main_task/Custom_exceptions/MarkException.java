package com.epam.training.aleksandr_gostev.main_task.Custom_exceptions;

public class MarkException extends Exception {

    private int mark;

    public MarkException(String message, int mark) {
        super(message);
        this.mark = mark;
    }

    public MarkException(String message) {
        super(message);
    }

    public int getMark() {
        return mark;
    }
}
