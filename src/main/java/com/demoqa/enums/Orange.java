package com.demoqa.enums;

import lombok.Getter;

public enum Orange {
    ADMIN("Admin"),
    PIM("PIM"),
    LEAVE("Leave"),
    TIME("Time"),
    RECRUITMENT("Recruitment"),
    MYINFO("My Info"),
    PERFORMANCE("Performance"),
    DASHBOARD("Dashboard"),
    DIRECTORY("Directory"),
    MAINTENANCE("Maintenance"),
    CLAIM("Claim"),
    BUZZ("Buzz");
    @Getter
    String panelMenu;

    Orange(String panelMenu){
        this.panelMenu = panelMenu;
    }
    }