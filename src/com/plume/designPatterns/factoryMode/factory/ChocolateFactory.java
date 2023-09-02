package com.plume.designPatterns.factoryMode.factory;

import com.plume.designPatterns.factoryMode.kind.Chocolate;

public abstract class ChocolateFactory {
    public abstract Chocolate makeChocolate();
}
