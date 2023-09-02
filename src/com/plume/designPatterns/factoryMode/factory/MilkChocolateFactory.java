package com.plume.designPatterns.factoryMode.factory;

import com.plume.designPatterns.factoryMode.kind.Chocolate;
import com.plume.designPatterns.factoryMode.kind.MilkChocolate;

public class MilkChocolateFactory extends ChocolateFactory {
    @Override
    public Chocolate makeChocolate() {
        return new MilkChocolate();
    }
}

