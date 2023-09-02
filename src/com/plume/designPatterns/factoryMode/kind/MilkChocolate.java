package com.plume.designPatterns.factoryMode.kind;

public class MilkChocolate extends Chocolate {
    @Override
    public void make() {
        System.out.println("制作牛奶巧克力");
    }
}

