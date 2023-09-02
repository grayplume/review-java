package com.plume.designPatterns.factoryMode.kind;

public class DarkChocolate extends Chocolate {
    @Override
    public void make() {
        System.out.println("制作黑巧克力");
    }
}
