package ru.lebedev.servicecars.constant;

public interface CarRequestConstants {

    String REG_EX_NUMBER = "^[АВЕКМНОРСТУХ]\\d{3}(?<!000)[АВЕКМНОРСТУХ]{2}\\d{2,3}$";
    int CURRENT_YEAR = 2021;
}
