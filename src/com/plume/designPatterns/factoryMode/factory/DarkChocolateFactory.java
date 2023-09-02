package com.plume.designPatterns.factoryMode.factory;

import com.plume.designPatterns.factoryMode.kind.Chocolate;
import com.plume.designPatterns.factoryMode.kind.DarkChocolate;

public class DarkChocolateFactory extends ChocolateFactory {
    @Override
    public Chocolate makeChocolate() {
        return new DarkChocolate();
    }
}
