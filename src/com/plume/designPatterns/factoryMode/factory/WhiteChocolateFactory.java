package com.plume.designPatterns.factoryMode.factory;

import com.plume.designPatterns.factoryMode.kind.Chocolate;
import com.plume.designPatterns.factoryMode.kind.WhiteChocolate;

public class WhiteChocolateFactory extends ChocolateFactory {
    @Override
    public Chocolate makeChocolate() {
        return new WhiteChocolate();
    }
}
