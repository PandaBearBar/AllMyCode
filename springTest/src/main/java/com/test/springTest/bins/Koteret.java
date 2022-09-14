package com.test.springTest.bins;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Koteret {
    ADD("" +
            "╔═╗╔╦╗╔╦╗\n" +
            "╠═╣ ║║ ║║\n" +
            "╩ ╩═╩╝═╩╝"),
    LIST("" +
            "╔═╗╦  ╦  \n" +
            "╠═╣║  ║  \n" +
            "╩ ╩╩═╝╩═╝"),
    UNO("" +
            "╦ ╦╔╗╔╔═╗  \n" +
            "║ ║║║║║ ║  \n" +
            "╚═╝╝╚╝╚═╝  "),
    AVG("" +
            "╔═╗╦  ╦╔═╗  ╦ ╦╔╗╔╔═╗\n" +
            "╠═╣╚╗╔╝║ ╦  ║ ║║║║║ ║\n" +
            "╩ ╩ ╚╝ ╚═╝  ╚═╝╝╚╝╚═╝"),
    ListByName("" +
            "╦  ┬┌─┐┌┬┐  ╔╗ ┬ ┬  ╔╗╔┌─┐┌┬┐┌─┐\n" +
            "║  │└─┐ │   ╠╩╗└┬┘  ║║║├─┤│││├┤ \n" +
            "╩═╝┴└─┘ ┴   ╚═╝ ┴   ╝╚╝┴ ┴┴ ┴└─┘"),
    DELETE("" +
            "╔╦╗╔═╗╦  ╔═╗╔╦╗╔═╗\n" +
            " ║║║╣ ║  ║╣  ║ ║╣ \n" +
            "═╩╝╚═╝╩═╝╚═╝ ╩ ╚═╝");
    private String msg;
}
