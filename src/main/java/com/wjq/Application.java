package com.wjq;

import com.blade.Blade;

public class Application {
    public static void main(String[] args) {
        Blade.me()
                .get("/", (req, res) -> res.text("Hello World!"))
                .start(Application.class, args);
    }
}
