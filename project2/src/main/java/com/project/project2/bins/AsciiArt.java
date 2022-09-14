package com.project.project2.bins;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AsciiArt {
    ADMIN_LOGIN("" +
            " █████╗ ██████╗ ███╗   ███╗██╗███╗   ██╗    ██╗      ██████╗  ██████╗ ██╗███╗   ██╗\n" +
            "██╔══██╗██╔══██╗████╗ ████║██║████╗  ██║    ██║     ██╔═══██╗██╔════╝ ██║████╗  ██║\n" +
            "███████║██║  ██║██╔████╔██║██║██╔██╗ ██║    ██║     ██║   ██║██║  ███╗██║██╔██╗ ██║\n" +
            "██╔══██║██║  ██║██║╚██╔╝██║██║██║╚██╗██║    ██║     ██║   ██║██║   ██║██║██║╚██╗██║\n" +
            "██║  ██║██████╔╝██║ ╚═╝ ██║██║██║ ╚████║    ███████╗╚██████╔╝╚██████╔╝██║██║ ╚████║\n" +
            "╚═╝  ╚═╝╚═════╝ ╚═╝     ╚═╝╚═╝╚═╝  ╚═══╝    ╚══════╝ ╚═════╝  ╚═════╝ ╚═╝╚═╝  ╚═══╝\n" +
            "                                                                                   "),
    ADMIN_LOGOUT("" +
            " █████╗ ██████╗ ███╗   ███╗██╗███╗   ██╗    ██╗      ██████╗  ██████╗  ██████╗ ██╗   ██╗████████╗\n" +
            "██╔══██╗██╔══██╗████╗ ████║██║████╗  ██║    ██║     ██╔═══██╗██╔════╝ ██╔═══██╗██║   ██║╚══██╔══╝\n" +
            "███████║██║  ██║██╔████╔██║██║██╔██╗ ██║    ██║     ██║   ██║██║  ███╗██║   ██║██║   ██║   ██║   \n" +
            "██╔══██║██║  ██║██║╚██╔╝██║██║██║╚██╗██║    ██║     ██║   ██║██║   ██║██║   ██║██║   ██║   ██║   \n" +
            "██║  ██║██████╔╝██║ ╚═╝ ██║██║██║ ╚████║    ███████╗╚██████╔╝╚██████╔╝╚██████╔╝╚██████╔╝   ██║   \n" +
            "╚═╝  ╚═╝╚═════╝ ╚═╝     ╚═╝╚═╝╚═╝  ╚═══╝    ╚══════╝ ╚═════╝  ╚═════╝  ╚═════╝  ╚═════╝    ╚═╝   \n" +
            "                                                                                                 "),
    COMPANY_LOGIN("" +
            " ██████╗ ██████╗ ███╗   ███╗██████╗  █████╗ ███╗   ██╗██╗   ██╗    ██╗      ██████╗  ██████╗ ██╗███╗   ██╗\n" +
            "██╔════╝██╔═══██╗████╗ ████║██╔══██╗██╔══██╗████╗  ██║╚██╗ ██╔╝    ██║     ██╔═══██╗██╔════╝ ██║████╗  ██║\n" +
            "██║     ██║   ██║██╔████╔██║██████╔╝███████║██╔██╗ ██║ ╚████╔╝     ██║     ██║   ██║██║  ███╗██║██╔██╗ ██║\n" +
            "██║     ██║   ██║██║╚██╔╝██║██╔═══╝ ██╔══██║██║╚██╗██║  ╚██╔╝      ██║     ██║   ██║██║   ██║██║██║╚██╗██║\n" +
            "╚██████╗╚██████╔╝██║ ╚═╝ ██║██║     ██║  ██║██║ ╚████║   ██║       ███████╗╚██████╔╝╚██████╔╝██║██║ ╚████║\n" +
            " ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚═╝     ╚═╝  ╚═╝╚═╝  ╚═══╝   ╚═╝       ╚══════╝ ╚═════╝  ╚═════╝ ╚═╝╚═╝  ╚═══╝\n" +
            "                                                                                                          "),
    COMPANY_LOGOUT("" +
            " ██████╗ ██████╗ ███╗   ███╗██████╗  █████╗ ███╗   ██╗██╗   ██╗    ██╗      ██████╗  ██████╗  ██████╗ ██╗   ██╗████████╗\n" +
            "██╔════╝██╔═══██╗████╗ ████║██╔══██╗██╔══██╗████╗  ██║╚██╗ ██╔╝    ██║     ██╔═══██╗██╔════╝ ██╔═══██╗██║   ██║╚══██╔══╝\n" +
            "██║     ██║   ██║██╔████╔██║██████╔╝███████║██╔██╗ ██║ ╚████╔╝     ██║     ██║   ██║██║  ███╗██║   ██║██║   ██║   ██║   \n" +
            "██║     ██║   ██║██║╚██╔╝██║██╔═══╝ ██╔══██║██║╚██╗██║  ╚██╔╝      ██║     ██║   ██║██║   ██║██║   ██║██║   ██║   ██║   \n" +
            "╚██████╗╚██████╔╝██║ ╚═╝ ██║██║     ██║  ██║██║ ╚████║   ██║       ███████╗╚██████╔╝╚██████╔╝╚██████╔╝╚██████╔╝   ██║   \n" +
            " ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚═╝     ╚═╝  ╚═╝╚═╝  ╚═══╝   ╚═╝       ╚══════╝ ╚═════╝  ╚═════╝  ╚═════╝  ╚═════╝    ╚═╝   \n" +
            "                                                                                                                        "),
    CUSTOMER_LOGIN("" +
            " ██████╗██╗   ██╗███████╗████████╗ ██████╗ ███╗   ███╗███████╗██████╗     ██╗      ██████╗  ██████╗ ██╗███╗   ██╗\n" +
            "██╔════╝██║   ██║██╔════╝╚══██╔══╝██╔═══██╗████╗ ████║██╔════╝██╔══██╗    ██║     ██╔═══██╗██╔════╝ ██║████╗  ██║\n" +
            "██║     ██║   ██║███████╗   ██║   ██║   ██║██╔████╔██║█████╗  ██████╔╝    ██║     ██║   ██║██║  ███╗██║██╔██╗ ██║\n" +
            "██║     ██║   ██║╚════██║   ██║   ██║   ██║██║╚██╔╝██║██╔══╝  ██╔══██╗    ██║     ██║   ██║██║   ██║██║██║╚██╗██║\n" +
            "╚██████╗╚██████╔╝███████║   ██║   ╚██████╔╝██║ ╚═╝ ██║███████╗██║  ██║    ███████╗╚██████╔╝╚██████╔╝██║██║ ╚████║\n" +
            " ╚═════╝ ╚═════╝ ╚══════╝   ╚═╝    ╚═════╝ ╚═╝     ╚═╝╚══════╝╚═╝  ╚═╝    ╚══════╝ ╚═════╝  ╚═════╝ ╚═╝╚═╝  ╚═══╝\n" +
            "                                                                                                                 "),
    CUSTOMER_LOGOUT("" +
            " ██████╗██╗   ██╗███████╗████████╗ ██████╗ ███╗   ███╗███████╗██████╗     ██╗      ██████╗  ██████╗  ██████╗ ██╗   ██╗████████╗\n" +
            "██╔════╝██║   ██║██╔════╝╚══██╔══╝██╔═══██╗████╗ ████║██╔════╝██╔══██╗    ██║     ██╔═══██╗██╔════╝ ██╔═══██╗██║   ██║╚══██╔══╝\n" +
            "██║     ██║   ██║███████╗   ██║   ██║   ██║██╔████╔██║█████╗  ██████╔╝    ██║     ██║   ██║██║  ███╗██║   ██║██║   ██║   ██║   \n" +
            "██║     ██║   ██║╚════██║   ██║   ██║   ██║██║╚██╔╝██║██╔══╝  ██╔══██╗    ██║     ██║   ██║██║   ██║██║   ██║██║   ██║   ██║   \n" +
            "╚██████╗╚██████╔╝███████║   ██║   ╚██████╔╝██║ ╚═╝ ██║███████╗██║  ██║    ███████╗╚██████╔╝╚██████╔╝╚██████╔╝╚██████╔╝   ██║   \n" +
            " ╚═════╝ ╚═════╝ ╚══════╝   ╚═╝    ╚═════╝ ╚═╝     ╚═╝╚══════╝╚═╝  ╚═╝    ╚══════╝ ╚═════╝  ╚═════╝  ╚═════╝  ╚═════╝    ╚═╝   \n" +
            "                                                                                                                               "),
    LINE("" +
            "                                                                        \n" +
            "█████╗█████╗█████╗█████╗█████╗█████╗█████╗█████╗█████╗█████╗█████╗█████╗\n" +
            "╚════╝╚════╝╚════╝╚════╝╚════╝╚════╝╚════╝╚════╝╚════╝╚════╝╚════╝╚════╝\n" +
            "███████╗███████╗███████╗███████╗███████╗███████╗███████╗███████╗███████╗\n" +
            "╚══════╝╚══════╝╚══════╝╚══════╝╚══════╝╚══════╝╚══════╝╚══════╝╚══════╝\n" +
            "                                                                        ")
    ;
    private String msg;

    @Override
    public String toString() {
        return  msg ;
    }
}