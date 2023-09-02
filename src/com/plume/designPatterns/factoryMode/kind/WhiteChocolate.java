package com.plume.designPatterns.factoryMode.kind;

public class WhiteChocolate extends Chocolate {
    @Override
    public void make() {
        System.out.println("制作白巧克力");
    }
}
