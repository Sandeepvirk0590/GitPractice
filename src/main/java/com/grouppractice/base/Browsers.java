package com.grouppractice.base;

public enum Browsers {
	
	CHROME("chrome"),
    FIREFOX("firefox"),
    EDGE("edge"),
	INTERNET_EXPLORER("Internet explorer");

    private String browserName;

    Browsers(String browserName) {
        this.browserName = browserName;
    }

    public String getBrowserName() {
        return browserName;
    }
	
}
